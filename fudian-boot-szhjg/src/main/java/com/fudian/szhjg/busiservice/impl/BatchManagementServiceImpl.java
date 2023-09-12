package com.fudian.szhjg.busiservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.szhjg.busiservice.BatchManagementService;
import com.fudian.szhjg.mapper.TJianjiMapper;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.pojo.*;
import com.fudian.szhjg.service.*;
import org.apache.commons.compress.archivers.zip.ZipUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class BatchManagementServiceImpl implements BatchManagementService {

    private static Map<String, Future<?>> futures = new HashMap<>();

    @Autowired
    private TProjectService tProjectService;   //项目表
    @Autowired
    private TBatchService tBatchService;       //批次表
    @Autowired
    private TJuanjiMapper tJuanjiMapper;       //案卷表
    @Autowired
    private TJuanjiService tJuanjiService;
    @Autowired
    private TJianjiMapper tJianjiMapper;       //文件表
    @Autowired
    private TJianjiService tJianjiService;
    @Autowired
    private TDalxglService dalxglService;      //档案类型表
    @Autowired
    private TMapperService mapperService;      //档案类型对应元数据字段设置表
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    //查询进行中项目名称
    @Override
    public List<Object> queryProjectName() {
        List<Object> listMap = null;
        try {
            LambdaQueryWrapper<TProject> tProjectWrapper = new LambdaQueryWrapper<>();
            tProjectWrapper.eq(TProject::getIsfinished, 0);
            tProjectWrapper.orderByDesc(TProject::getCreateTime);
            List<TProject> list = tProjectService.list(tProjectWrapper);
            listMap = new ArrayList<>();
            for (TProject tProject : list) {
                Map<String, String> map = new HashMap<>();
                map.put("label", tProject.getProjectName());
                map.put("value", tProject.getId());
                listMap.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ArithmeticException("查询进行中项目名称数据失败");
        }
        return listMap;
    }


    //查询进行中项目id
    @Override
    public List<String> ProjectLists() {
        //查询进行中项目
        LambdaQueryWrapper<TProject> projectWrapper = new LambdaQueryWrapper<>();
        projectWrapper.eq(TProject::getIsfinished, 0);
        List<TProject> list = tProjectService.list(projectWrapper);

        //过滤当前的案卷id
        //List<String> ids = list.stream().map(TProject::getId).collect(Collectors.toList());
        // 过滤掉null值
        List<String> ids = list.stream().map(TProject::getId).filter(Objects::nonNull).collect(Collectors.toList());
        if ( ids.size()>0 ){
            return ids;
        } else {
            ids = new ArrayList<>();
            return ids;
        }
    }


    //查询批次下是否有案卷
    @Override
    public String queryBatchData(String id) {
        String flag="false";
        LambdaQueryWrapper<TJuanji> taskWrapper = new LambdaQueryWrapper<>();
        taskWrapper.eq(TJuanji::getPcId,id);
        List<TJuanji> list = tJuanjiService.list(taskWrapper);
        if ( list.size()>0 ){
            flag = "true";
        }
        return flag;
    }


    //完成批次
    @Override
    public CommonResult completeBatch(String id) {
        //查询当前批次信息
        LambdaQueryWrapper<TBatch> batchWrapper = new LambdaQueryWrapper<>();
        batchWrapper.eq(TBatch::getId,id);
        List<TBatch> list = tBatchService.list(batchWrapper);
        TBatch tBatch = new TBatch();
        if ( list.size()>0 ){
            tBatch = list.get(0);
        }
        //查询案卷信息
        LambdaQueryWrapper<TJuanji> taskWrapper = new LambdaQueryWrapper<>();
        taskWrapper.eq(TJuanji::getPcId,tBatch.getId());
        taskWrapper.and(wrapper->wrapper.ne(TJuanji::getRwzt,"已完成").or().isNull(TJuanji::getRwzt));
        Integer i = tJuanjiMapper.selectCount(taskWrapper);
        if ( i>0 ){
            return new CommonResult(500,"当前批次存在未完成的任务,无法提交");
        }
        //获取当前的用户
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();

        //保存当前批次信息
        tBatch.setIsfinished("1");
        tBatch.setUpdateBy(userName);
        Date date = new Date();
        tBatch.setUpdateTime(date);
        tBatch.setEnddate(date);
        boolean b = tBatchService.updateById(tBatch);
        if ( b ){
            return new CommonResult(200,"批次完成提交成功");
        }else {
            return new CommonResult(500,"批次完成提交失败");
        }
    }


    //根据id查询项目信息
    @Override
    public String getProjectOne(String projectId) {
        LambdaQueryWrapper<TProject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TProject::getId,projectId);
        List<TProject> list = tProjectService.list(wrapper);
        TProject tProject = new TProject();
        if ( list.size()>0 ){
            tProject = list.get(0);
        }

        LambdaQueryWrapper<TDalxgl> dalxglWrapper = new LambdaQueryWrapper<>();
        dalxglWrapper.eq(TDalxgl::getId,tProject.getDalx());
        List<TDalxgl> list1 = dalxglService.list(dalxglWrapper);
        TDalxgl dalxgl = new TDalxgl();
        if ( list1.size()>0 ){
            dalxgl = list1.get(0);
        }
        return dalxgl.getId();
    }



    //导出完成数据包
    @Override
    @Transactional
    public CommonResult<?> exportCompletedInformation(TBatch batch) {
        try {
            //获取案卷字段和案件字段的数据
            Map<String,Map<Object, String>> fieldDataMap = getFieldsByPoints(batch.getDalx());
            Map<Object, String> aFields = fieldDataMap.get("编号组成");
            Map<Object, String> bFields = fieldDataMap.get("案卷表头");
            Map<Object, String> cFields = fieldDataMap.get("案卷英文");
            Map<Object, String> dFields = fieldDataMap.get("文件编号");
            Map<Object, String> eFields = fieldDataMap.get("文件表头");
            Map<Object, String> fFields = fieldDataMap.get("文件英文");
            Map<Object, String> gFields = fieldDataMap.get("文件动态");
            //获取当前时间
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = dateFormat.format(System.currentTimeMillis());
            //创建导出数据文件夹
            String exportFolder = createFolder(batch.getPrjFilepath(),batch.getPcName(),date);
            if (exportFolder.equals("false")){
                return CommonResult.success("导出数据包生成失败","9999");
            }
            //创建案卷.xlsx文件
            exportToExcel(bFields, "案卷数据.xlsx", exportFolder);
            //获取案卷信息
            List<TJuanji> listJu = getJuanListPcId(cFields,batch.getId());
            //案卷信息写入xlsx文件
            writeListJuToExcel(cFields,listJu,exportFolder+File.separator+"案卷数据.xlsx");
            //根据案卷查询文件并生成对应文件
            for (TJuanji juan:listJu){
                //获取案件信息
                List<TJianji> listJA = getJianListPcId(juan.getId(),1);   //查询首页信息
                List<TJianji> listJB = getJianListPcId(juan.getId(),2);   //查询全部信息
                //创建案件文件夹
                String caseFolder = generateFolder(exportFolder,juan.getBh());
                if (caseFolder.equals("false")){
                    return CommonResult.success("导出数据包生成失败","9999");
                }
                //创建案卷.xlsx文件
                writeListJiToExcel(eFields,aFields,dFields,fFields,gFields,juan,listJA,caseFolder);
                //创建图像文件夹
                String ImageFolder = generateFolder(caseFolder,"图像数据") ;
                if (ImageFolder.equals("false")) {
                    return CommonResult.success("导出数据包生成失败","9999");
                }
                //保存图片
                saveImagesFolder(listJB,ImageFolder);
            }

            CompletableFuture<String> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
                String zipPath = "失败";
                try {
                    zipPath = createZip(exportFolder,exportFolder);
                } catch (Exception e) {
                    return "压缩失败,请重试或联系管理员";
                }
                return "压缩成功,开始下载文件="+zipPath;
            },threadPoolTaskExecutor);
            voidCompletableFuture.thenAccept((result) -> {
                futures.put(date, voidCompletableFuture);
            });
            voidCompletableFuture.exceptionally((e) -> {
                futures.put(date, voidCompletableFuture);
                e.printStackTrace();
                return "下载异常,请重试或联系管理员";
            });
            return CommonResult.success("正在后台压缩数据,请稍后!", date);
        }catch (Exception e) {
            e.printStackTrace();
            return CommonResult.success("导出数据包生成失败","9999");
        }
    }

    //获取异步任务执行结果
    @Override
    public CommonResult<Object> getzipInformation(String id) {
        if (futures.containsKey(id)) {
            Future<?> future = futures.get(id);
            if (future.isDone()) {
                String s = "";
                try {
                    s = (String) future.get();
                } catch (InterruptedException | ExecutionException e) {
                    //e.printStackTrace();
                    return CommonResult.success(e.getMessage(), "失败");   //任务执行完毕,定时停止,前台提示任务失败
                } finally {
                    futures.remove(id);
                }
                if (s.startsWith("压缩失败,请重试或联系管理员") || s.startsWith("下载异常,请重试或联系管理员")) {
                    return CommonResult.success(s, "失败");
                }
                return CommonResult.success(s, "成功");          //任务执行完毕,定时停止,前台提示成功
            } else {
                return CommonResult.success(id, "未完成");       //任务未执行完毕,继续执行,不提示信息
            }
        }
        return CommonResult.success("下载失败", "失败");    //任务执行完毕,定时停止,提示任务失败
    }


    //获取案卷/案件字段
    private Map<String, Map<Object, String>> getFieldsByPoints(String dalx) {
        Map<String, Map<Object, String>> resultMap = new HashMap<>();
        //1.获取案卷编号字段
        LambdaQueryWrapper<TMapper> mapperWrapperA = new LambdaQueryWrapper<>();
        mapperWrapperA.eq(TMapper::getDaId,dalx).eq(TMapper::getPoints,"0").in(TMapper::getBerSet, "1", "2");
        mapperWrapperA.orderByAsc(TMapper::getBerSet).orderByAsc(TMapper::getBerSort);
        List<TMapper> listMapperA = mapperService.list(mapperWrapperA);
        Map<Object, String> metadataNameList0 = new LinkedHashMap<>();       //编号组成
        Map<String, String> metadataNameList1 = new LinkedHashMap<>();       //编号全部
        Map<Object, String> metadataNameList2 = new LinkedHashMap<>();       //编号中文
        Map<Object, String> metadataNameList3 = new LinkedHashMap<>();       //编号英文
        int counterA = 0;
        for (TMapper mapperA : listMapperA) {
            if (mapperA.getBerSet().equals("2")) {
                metadataNameList0.put(mapperA.getMetadataName(), mapperA.getSourceName());
            }
            metadataNameList1.put(mapperA.getMetadataName(), mapperA.getSourceName());
            metadataNameList2.put((long) counterA, mapperA.getMetadataName());
            metadataNameList3.put((long) counterA, mapperA.getSourceName());
            counterA++;
        }
        //2.获取案卷字段
        LambdaQueryWrapper<TMapper> mapperWrapperB = new LambdaQueryWrapper<>();
        mapperWrapperB.eq(TMapper::getDaId,dalx).eq(TMapper::getPoints,"0").eq(TMapper::getBerSet,"0").orderByAsc(TMapper::getSort);
        List<TMapper> listMapperB = mapperService.list(mapperWrapperB);
        Map<Object, String> metadataNameList4 = new LinkedHashMap<>(metadataNameList2);    //案卷表头
        Map<Object, String> metadataNameList5 = new LinkedHashMap<>(metadataNameList3);    //案卷英文
        int counterB = metadataNameList1.size();
        for (TMapper mapperB : listMapperB) {
            metadataNameList4.put((long) counterB, mapperB.getMetadataName());
            metadataNameList5.put((long) counterB, mapperB.getSourceName());
            counterB++;
        }
        //3.获取文件字段
        Map<Object, String> metadataNameList6 = new LinkedHashMap<>();                      //文件编号
        Map<String, String> metadataNameList7 = new LinkedHashMap<>();                      //文件替换
        Map<Object, String> metadataNameList8 = new LinkedHashMap<>();                      //文件表头
        Map<Object, String> metadataNameList9 = new LinkedHashMap<>();                      //文件英文
        Map<Object, String> metadataNameList10 = new LinkedHashMap<>();                     //文件动态
        //3.1.获取案卷编号字段名称集合
        List<String> numBering = listMapperA.stream().map(TMapper::getMetadataName).collect(Collectors.toList());
        //3.2.查询文件中只包含案卷编号的数据
        LambdaQueryWrapper<TMapper> mapperWrapperC = new LambdaQueryWrapper<>();
        mapperWrapperC.eq(TMapper::getDaId,dalx).eq(TMapper::getPoints,"1").in(TMapper::getMetadataName,numBering).orderByAsc(TMapper::getSort);
        List<TMapper> listMapperC = mapperService.list(mapperWrapperC);
        for (TMapper mapperC : listMapperC){
            metadataNameList6.put(mapperC.getMetadataName(), mapperC.getSourceName());
        }
        //3.3.替换编号中相关字段
        metadataNameList1.forEach((key, value) -> {
            if (metadataNameList6.containsKey(key)) {
                value = metadataNameList6.get(key);
            }
            metadataNameList7.put(key, value);
        });
        int counterC = 0;
        for (Map.Entry<String, String> entry : metadataNameList7.entrySet()) {
            metadataNameList8.put((long) counterC, entry.getKey());
            metadataNameList9.put((long) counterC, entry.getValue());
            counterC++;
        }
        //3.3查询文件中不包含案卷编号的数据
        LambdaQueryWrapper<TMapper> mapperWrapperD = new LambdaQueryWrapper<>();
        mapperWrapperD.eq(TMapper::getDaId,dalx).eq(TMapper::getPoints,"1").notIn(TMapper::getMetadataName, numBering).orderByAsc(TMapper::getSort);
        List<TMapper> listMapperD = mapperService.list(mapperWrapperD);
        //4.添加固定字段
        int counterD = metadataNameList7.size();
        Map<String, String> metadata = fixedField();
        for (Map.Entry<String, String> entry : metadata.entrySet()) {
            metadataNameList8.put((long) counterD, entry.getKey());
            metadataNameList9.put((long) counterD, entry.getValue());
            counterD++;
        }
        //5.添加动态字段
        for (int i = 0; i < listMapperD.size(); i++) {
            TMapper mapper3 = listMapperD.get(i);
            metadataNameList8.put((long) i+counterD, mapper3.getMetadataName());
            metadataNameList9.put((long) i+counterD, mapper3.getSourceName());
            metadataNameList10.put((long) i, mapper3.getSourceName());
        }
        //保存数据
        resultMap.put("编号组成", metadataNameList0 );
        resultMap.put("案卷表头", metadataNameList4 );
        resultMap.put("案卷英文", metadataNameList5 );
        resultMap.put("文件编号", metadataNameList6 );
        resultMap.put("文件表头", metadataNameList8 );
        resultMap.put("文件英文", metadataNameList9 );
        resultMap.put("文件动态", metadataNameList10 );
        return resultMap;
    }
    //获取文件固定字段(存放固定字段集合)
    private Map<String, String> fixedField() {
        Map<String, String> metadata = new LinkedHashMap<>();
        metadata.put("件号", "jh");
        metadata.put("页码", "ym");
        metadata.put("页数", "ys");
        return metadata;
    }


    //根据批次id,获取案卷信息
    private List<TJuanji> getJuanListPcId(Map<Object, String> fieldsMap, String id) {
        //拼接成字符串
        StringBuilder sb = new StringBuilder();
        sb.append("id");     //添加默认字段
        // 获取所有value并拼接到StringBuilder中
        for (String value : fieldsMap.values()) {
            if (value.startsWith("int")) {
                sb.append(", ").append("int_").append(value.substring(3));     //在 "int" 后添加下划线 "_"
            }else {
                sb.append(", ").append(value);
            }
        }
        //拼接sql
        String sql = "SELECT " + sb.toString() + " FROM t_juanji WHERE pc_id = '"+id+"' ORDER BY bh ASC";
        //返回查询数据
        return tJuanjiMapper.getList(sql);
    }
    //根据案卷id查询文件信息
    private List<TJianji> getJianListPcId(String id, int i) {
        LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJianji::getAjId,id);
        if ( i==1 ){
            wrapper.eq(TJianji::getSfsy,"是");
        }
        wrapper.orderByAsc(TJianji::getYm);
        return tJianjiService.list(wrapper);
    }



    //获取生成文件夹路径
    private String createFolder(String prjFilepath, String pcName, String date) {
        //判断根文件夹是否存在,不存在创建
        String savePath = prjFilepath+File.separator+"0-packet";
        File folder = new File(savePath);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (!created) {
                return "false";
            }
        }
        //创建导出数据文件夹
        String exportFolder = savePath+File.separator+ pcName + date;
        File folder1 = new File(exportFolder);
        if (!folder1.exists()) {
            boolean created = folder1.mkdirs();
            if (!created) {
                return "false";
            }
        }
        return exportFolder;
    }
    //生成(案卷/图片)文件夹
    private String generateFolder(String path, String name) {
        //拼接路径名称
        String newPath = path+File.separator+name;
        File folder = new File(newPath);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (!created) {
                return "false";
            }
        }
        return newPath;
    }



    //创建.xlsx文件
    public static void exportToExcel(Map<Object, String> metadataList, String fileName, String exportFolder) {
        //1.创建Excel对象
        XSSFWorkbook wb = new XSSFWorkbook();
        //2.创建Sheet对象
        Sheet sheet = wb.createSheet("案卷条目");
        //3.创建行对象(索引从0开始)
        Row nRow = sheet.createRow(0);
        //4.设置行高和列宽
        nRow.setHeightInPoints(22f);
        //(列的索引,列宽*256(理解为固定写法))
        //5.创建单元格对象(索引从0开始)
        int size = metadataList.size();
        // 表头样式
        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);// 左右居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
        // 字体样式
        XSSFFont fontStyle = wb.createFont();
        fontStyle.setFontName("黑体");
        fontStyle.setFontHeightInPoints((short) 10);
        style.setFont(fontStyle);
        for (int i = 0; i < size; i++) {
            Cell cell = nRow.createCell(i);
            sheet.autoSizeColumn(i);
            //6.设置单元格内容
            if (metadataList.containsKey((long) i)) {
                String s = metadataList.get((long) i);
                sheet.setColumnWidth(i, 24 * 256);
                cell.setCellValue(s);
                //11.为单元格应用样式
                cell.setCellStyle(style);
            }
        }
        FileOutputStream outFile = null;
        try {
            outFile = new FileOutputStream(exportFolder+File.separator + fileName);
            wb.write(outFile);
            outFile.close();
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //案卷信息写入xlsx文件
    public void writeListJuToExcel(Map<Object, String> appointFields,List<TJuanji> listJu, String filePath) {
        try {
            //读取已经创建好的xlsx文件, 获取第一个Sheet页.
            Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
            Sheet sheet = workbook.getSheetAt(0);
            //获取当前表格中已经存在的行数，用于写入新数据时确定行号
            int rowNum = sheet.getLastRowNum();
            //创建(单元格样式/字体)对象，并设置样式和大小
            Font font = workbook.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 10);
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);         //左右居中
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);   //上下居中
            cellStyle.setFont(font);

            //缓存字段名与字段值的映射关系
            Map<String, Object> fieldValues = new ConcurrentHashMap<>();
            //写入新数据
            for (TJuanji juanji : listJu) {
                fieldValues.clear();     //清空字段值缓存
                Row row = sheet.createRow(++rowNum);
                row.setHeightInPoints(16f);                 //设置行高
                row.setRowStyle(cellStyle);                 //设置行的样式
                //遍历字段名，缓存字段值
                int columnNum = 0;
                for (String fieldName : appointFields.values()) {
                    if (!fieldValues.containsKey(fieldName)) {
                        fieldValues.put(fieldName, juanji.getFieldValue(fieldName));
                    }
                    Cell cell = row.createCell(columnNum++);
                    Object cellName = fieldValues.get(fieldName);
                    cell.setCellValue(cellName != null ? cellName.toString() : "");
                    cell.setCellStyle(cellStyle);           //使用设置的单元格样式
                }
            }

            //保存文件
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }
            //关闭工作簿
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //文件信息(创建/写入)xlsx文件
    //[headerFields(eFields:表头), aFields(fieldsA):案卷编号, dFields(fieldsD):文件编号, fFields(fieldsC):表头字段英文, gFields(fieldsG):动态字段 ]
    //[juan:案卷信息,  listJi:文件信息集合,  caseFolder:文件路径 ]
    private void writeListJiToExcel(Map<Object,String> headerFields,
                                    Map<Object,String> fieldsA, Map<Object,String> fieldsD,
                                    Map<Object,String> fieldsC, Map<Object,String> fieldsG,
                                    TJuanji juan, List<TJianji> listJA, String caseFolder) {
        XSSFWorkbook workbook = new XSSFWorkbook();                  //创建Excel对象
        Sheet sheet = workbook.createSheet("案卷条目");    //创建Sheet对象
        Row nRow = sheet.createRow(0);                            //创建行对象(索引从0开始)
        nRow.setHeightInPoints(22f);                                //设置行高和列宽
        XSSFCellStyle style = workbook.createCellStyle();        //表头样式
        style.setAlignment(HorizontalAlignment.CENTER);              //左右居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);        //上下居中
        XSSFFont fontStyle = workbook.createFont();              //字体样式
        fontStyle.setFontName("黑体");
        fontStyle.setFontHeightInPoints((short) 10);
        style.setFont(fontStyle);
        //创建表头
        int size = headerFields.size();                          //创建单元格对象(索引从0开始)
        for (int i = 0; i < size; i++) {
            Cell cell = nRow.createCell(i);
            sheet.autoSizeColumn(i);
            if (headerFields.containsKey((long) i)) {
                String s = headerFields.get((long) i);
                sheet.setColumnWidth(i, 24 * 256);
                cell.setCellValue(s);
                cell.setCellStyle(style);      //单元格应用样式
            }
        }
        //添加数据
        try {
            Font font = workbook.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 10);
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);         //左右居中
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);   //上下居中
            cellStyle.setFont(font);
            int rowNum = sheet.getLastRowNum();          //获取表格中已经存在的行数，用于写入数据时确定行
            //缓存字段名与字段内容
            Map<String, Object> hashMap1 = new ConcurrentHashMap<>();
            for (Object key : fieldsA.keySet()) {
                String fieldNameA = fieldsA.get(key);
                String fieldNameD = fieldsD.get(key);
                if (!hashMap1.containsKey(fieldNameD)) {
                    hashMap1.put(fieldNameD, juan.getFieldValue(fieldNameA));
                }
            }
            //循环文件列表
            for (TJianji jian :listJA){
                Map<String, Object> hashMap2 = new ConcurrentHashMap<>();
                hashMap2.put("bh", jian.getBh());
                hashMap2.putAll(hashMap1);
                hashMap2.put("jh", jian.getJh());
                hashMap2.put("ym", jian.getYm());
                hashMap2.put("ys", jian.getYs());
                for (String fieldName : fieldsG.values()) {
                    if (!hashMap2.containsKey(fieldName)) {
                        hashMap2.put(fieldName, jian.getFieldValue(fieldName));
                    }
                }
                //写入文件
                Row row = sheet.createRow(++rowNum);        //先将rowNum(0)的值+1，再将值(1)赋值给row
                row.setHeightInPoints(16f);                 //设置行高
                row.setRowStyle(cellStyle);                 //设置行的样式
                int columnNum = 0;                          //遍历字段名，缓存字段值
                for (Object key : fieldsC.keySet()) {
                    String value = fieldsC.get(key);
                    Cell cell = row.createCell(columnNum++);
                    Object cellName =hashMap2.get(value);
                    cell.setCellValue(cellName != null ? cellName.toString() : "");
                    cell.setCellStyle(cellStyle);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //保存文件
        FileOutputStream outFile = null;
        try {
            String filePath = caseFolder+File.separator + "文件数据.xlsx";
            outFile = new FileOutputStream(filePath);
            workbook.write(outFile);
            outFile.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //文件信息保存图像
    private void saveImagesFolder(List<TJianji> listJB, String imageFolder) {
        try {
            for (TJianji jian : listJB ){
                String imagePath = jian.getTpdz();       //获取图片路径
                if (imagePath != null && !imagePath.isEmpty()) {
                    File imageFile = new File(imagePath);    //获取图片文件名
                    if (imageFile.exists()) {
                        try {
                            //获取图片文件名
                            String fileName = imageFile.getName();
                            //新的图片名称
                            String[] nameParts = fileName.split("\\.");
                            String extension = nameParts[1];
                            String newFileName = jian.getBh()+"-"+jian.getYm() +"."+extension;
                            File targetFile = new File(imageFolder, newFileName);
                            Path sourcePath = imageFile.toPath();
                            Path targetPath = targetFile.toPath();
                            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



    //创建ZIP文件
    private String createZip(String exportFolder, String zipPath) {
        String packagePath = zipPath +".zip";
        createZip(exportFolder, packagePath, true);
        return packagePath;
    }
    private static final Logger log = LoggerFactory.getLogger(ZipUtil.class);
    /**@param sourcePath 文件或文件夹路径
     * @param zipPath 生成的zip文件存在路径（包括文件名）
     * @param isDrop  是否删除原文件:true删除、false不删除  */
    public boolean createZip(String sourcePath, String zipPath,Boolean isDrop) {
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipPath);
            zos = new ZipOutputStream(fos);
            writeZip(new File(sourcePath), "", zos);
            if(isDrop) {
                deleteFileAll(new File(sourcePath));
            }
        } catch (FileNotFoundException e) {
            log.error("创建ZIP文件失败",e);
            return false;
        } finally {
            try {
                if (zos != null) {
                    zos.close();
                }
            } catch (IOException e) {
                log.error("创建ZIP文件失败",e);
            }

        }
        return true;
    }
    private static void writeZip(File file, String parentPath, ZipOutputStream zos) {
        if(file.exists()){
            if(file.isDirectory()){//处理文件夹
                parentPath+=file.getName()+File.separator;
                File [] files=file.listFiles();
                if(files.length != 0) {
                    for(File f:files){
                        writeZip(f, parentPath, zos);
                    }
                }else {
                    //空目录则创建当前目录
                    try {
                        zos.putNextEntry(new ZipEntry(parentPath));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }else{
                FileInputStream fis=null;
                try {
                    fis=new FileInputStream(file);
                    ZipEntry ze = new ZipEntry(parentPath + file.getName());
                    zos.putNextEntry(ze);
                    byte [] content=new byte[1024];
                    int len;
                    while((len=fis.read(content))!=-1){
                        zos.write(content,0,len);
                        zos.flush();
                    }
                } catch (FileNotFoundException e) {
                    log.error("创建ZIP文件失败",e);
                } catch (IOException e) {
                    log.error("创建ZIP文件失败",e);
                }finally{
                    try {
                        if(fis!=null){
                            fis.close();
                        }
                    }catch(IOException e){
                        log.error("创建ZIP文件失败",e);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    //删除文件下所有文件夹和文件 (file：文件名)
    public static void deleteFileAll(File file) {
        if (file.exists()) {
            File files[] = file.listFiles();
            int len = files.length;
            for (int i = 0; i < len; i++) {
                if (files[i].isDirectory()) {
                    deleteFileAll(files[i]);
                } else {
                    files[i].delete();
                }
            }
            file.delete();
        }
    }

}
