package com.fudian.szhjg.busiservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.common.utils.uuid.IdUtils;
import com.fudian.system.mapper.SysDictDataMapper;
import com.fudian.szhjg.busiservice.CommonSzhjgService;
import com.fudian.szhjg.busiservice.TaskService;
import com.fudian.szhjg.mapper.*;
import com.fudian.szhjg.pojo.*;
import com.fudian.szhjg.pojo.vo.JuanjiVO;
import com.fudian.szhjg.service.TBatchService;
import com.fudian.szhjg.service.TJuanjiService;
import com.fudian.szhjg.util.excel.ExcelUtil;
import com.fudian.szhjg.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.io.File;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private TBatchService tBatchService;
    @Autowired
    private TBatchMapper tBatchMapper;

    @Autowired
    private TMapperService mapperService;
    @Autowired
    private TMapperMapper tMapperMapper;

    @Autowired
    private TJuanjiService tJuanjiService;
    @Autowired
    private TJuanjiMapper tJuanjiMapper;

    @Autowired
    private TJianjiMapper tJianjiMapper;

    @Autowired
    private CommonSzhjgService commonSzhjgService;

    @Autowired
    private SysDictDataMapper  sysDictDataMapper;






    //获取批次档案类型
    @Override
    public String getOneTask(String pcId) {
        return getOneDh(pcId);
    }
    //根据批次id查询批次表
    private String getOneDh(String pcId) {
        LambdaQueryWrapper<TBatch> batchWrapper = new LambdaQueryWrapper<>();
        batchWrapper.eq(TBatch::getId,pcId);
        List<TBatch> list = tBatchService.list(batchWrapper);
        TBatch batch = new TBatch();
        if ( list.size()>0 ){
            batch = list.get(0);
        }
        return batch.getDalx();
    }


    //查询编号组成字段信息
    @Override
    public CommonResult queryNumberedComposition(String batchNameId) {
        //获取批次的档案类型
        String dalx = getOneDh(batchNameId);
        //获取动态编号组成字段
        LambdaQueryWrapper<TMapper> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TMapper::getDaId,dalx).eq(TMapper::getPoints,"0").eq(TMapper::getBerSet,"2");
        wrapper.orderByAsc(TMapper::getBerSort);
        List<TMapper> listMapper = mapperService.list(wrapper);

        List<Object> objectList = new ArrayList<>();
        for (TMapper mapper : listMapper){
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("sourceName", mapper.getSourceName());
            map.put("metadataMode", mapper.getMetadataMode());
            objectList.add(map);
        }
        return CommonResult.success(objectList);
    }



    /**
     * excel案卷导入
     * @return java.lang.String
     * @author MCY
     * @date 2023/5/30 17:24
     */
    @Override
    @Transactional
    public CommonResult excelFileImport(MultipartFile[] multipartFiles, String batchId,Integer gxxh) {
        //获取当前的用户
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();
        /*根据批次id获取当类型id*/
        TBatch tBatch = tBatchMapper.selectOne(Wrappers.<TBatch>lambdaQuery().eq(TBatch::getId, batchId));
        /*表头字段*/
        List<TMapper> tMappers = tMapperMapper.selectList(Wrappers.<TMapper>lambdaQuery().eq(TMapper::getDaId, tBatch.getDalx()).eq(TMapper::getPoints, 0));
        if (tMappers.size() <= 0) return CommonResult.error("未找到映射字段");
        /*生成一个线程安全的值*/
        AtomicInteger i = new AtomicInteger();
        /*解析数据，获取list*/
        for (MultipartFile multipart : multipartFiles) {
            String filePath = ExcelUtil.checkAndStorageFile(multipart).getPath();
            File file = new File(filePath);
            if (file == null) return CommonResult.error("未找到文件");
            List<TJuanji> mapperList = ExcelUtil.readExcel(file, tMappers);
            /*判断list是否为空*/
            Optional<List<TJuanji>> tJuanjis = Optional.ofNullable(mapperList);
            if (!tJuanjis.get().isEmpty()) {
                tJuanjis.ifPresent(tJuanjis1 -> {
                    JuanjiVO tJuanjiVO = new JuanjiVO()
                            .setJuanjiList(tJuanjis1)
                            .setRwzt("未进行")
                            .setCataloged("未著录")
                            .setGxxh(gxxh)
                            .setPcId(batchId)
                            .setDalx(tBatch.getDalx())
                            .setCreateTime(new Date())
                            .setCreateBy(userName);
                    long start = System.nanoTime();
                    int i1 = tJuanjiMapper.bulkAdditions(tJuanjiVO);
                    long end = System.nanoTime();
                    System.out.println(String.format("导入时间：%d ms", (end - start) / 1000000));
                    i.addAndGet(i1);
                });
                return CommonResult.success("解析到【" + tJuanjis.get().size() + "】条数据，导入成功【"
                        + i + "】条，重复【" + String.valueOf(tJuanjis.get().size() - i.get()) + "】条");
            }
            /*删除临时文件*/
            file.deleteOnExit();
        }
        return CommonResult.error("导入失败");
    }


    /**
     * excel文件导入
     * @return java.lang.String
     * @author MCY
     * @date 2023/5/30 17:24
     */
    @Override
    @Transactional
    public CommonResult importDataPiece(MultipartFile[] multipartFiles, String batchId,Integer gxxh) {
        // 获取当前的用户
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();
        /*根据批次id获取当类型id*/
        TBatch tBatch = tBatchMapper.selectOne(Wrappers.<TBatch>lambdaQuery().eq(TBatch::getId, batchId));
        /*表头字段*/
        List<TMapper> tMappers = tMapperMapper.selectList(Wrappers.<TMapper>lambdaQuery().eq(TMapper::getDaId, tBatch.getDalx()).eq(TMapper::getPoints, 1));
        /*档号拼接字段集合*/
        List<TMapper> berSetMappers = tMapperMapper.selectList(Wrappers.<TMapper>lambdaQuery().eq(TMapper::getDaId, tBatch.getDalx()).eq(TMapper::getPoints, 0).eq(TMapper::getBerSet, "2").orderByAsc(TMapper::getBerSort));
        if (tMappers.size() <= 0) return CommonResult.error("未找到映射字段");
        /*生成一个线程安全的值*/
        AtomicInteger i = new AtomicInteger();
        Map<String, String> fileInformation = new HashMap<>(10);
        /*获取案卷数据*/
        tMapperMapper.mybatisStreamQueryBybatch(resultContext -> {
            Map<String, String> resultObject = resultContext.getResultObject();
            String key = String.valueOf(resultObject.get("bh"));
            String value = String.valueOf(resultObject.get("id"));
            fileInformation.put(key, value);
        },batchId);
        for (MultipartFile multipart : multipartFiles) {
            String filePath = ExcelUtil.checkAndStorageFile(multipart).getPath();
            File file = new File(filePath);
            if (file == null) return CommonResult.error("未找到文件");
            /*解析数据，获取list*/
            List<TJianji> mapperList = ExcelUtil.readExcelFile(file, tMappers,fileInformation,berSetMappers);
            /*判断list是否为空*/
            Optional<List<TJianji>> tJianjis = Optional.ofNullable(mapperList);
            if (!tJianjis.get().isEmpty()) {
                tJianjis.ifPresent(tJianjis1 -> {
                    JuanjiVO tJuanjiVO = new JuanjiVO()
                            .setJianjiList(tJianjis1)
                            //.setGxxh(gxxh)
                            .setDalx(tBatch.getDalx())
                            .setCreateTime(new Date())
                            .setCreateBy(userName);
                    long start = System.nanoTime();
                    int i1 = tJianjiMapper.bulkAdditions(tJuanjiVO);
                    long end = System.nanoTime();
                    System.out.println(String.format("导入时间：%d ms", (end - start) / 1000000));
                    i.addAndGet(i1);
                });
                return CommonResult.success("解析到" + tJianjis.get().size() + "条数据，成功" + i + "条");
            }
            /*删除临时文件*/
            file.deleteOnExit();
        }
        return CommonResult.error("未找到匹配数据");
    }



    //下载-导入模板-查询字段列表
    @Override
    public List<String> headerNameList(String batchId, String pointsId) {
        //存放动态生成表头字段信息
        List<String> headerList = new ArrayList<>();
        //获取批次的档案类型
        String daId = getOneDh(batchId);
        //查询字段列表
        if ("0".equals(pointsId)){
            headerList = archivesMapper(daId);
        }else if ("1".equals(pointsId)){
            headerList = documentMapper(daId);
        }
        return headerList;
    }
    //查询案卷
    private List<String> archivesMapper(String daId) {
        List<String> archivesList = new ArrayList<>();
        LambdaQueryWrapper<TMapper> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TMapper::getDaId,daId).eq(TMapper::getPoints,"0").eq(TMapper::getEnterSet,"1");
        wrapper.orderByAsc(TMapper::getSort);
        List<TMapper> listMapper = mapperService.list(wrapper);
        for (TMapper mapper : listMapper){
            archivesList.add(mapper.getMetadataName());
        }
        return archivesList;
    }
    //查询文件
    private List<String> documentMapper(String daId) {
        List<String> documentList = new ArrayList<>();
        //查询案卷编号
        LambdaQueryWrapper<TMapper> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(TMapper::getDaId,daId).eq(TMapper::getPoints,"0").eq(TMapper::getBerSet,"2");
        wrapper1.orderByAsc(TMapper::getBerSort);
        List<TMapper> listJu = mapperService.list(wrapper1);
        if ( listJu.size()>0 ){
            for (TMapper mapper : listJu){
                documentList.add(mapper.getMetadataName());
            }
            documentList.add("件号");
            documentList.add("页码");
            documentList.add("页数");
        }
        //查询文件著录字段
        LambdaQueryWrapper<TMapper> wrapper2 = new LambdaQueryWrapper<>();
        wrapper2.eq(TMapper::getDaId,daId).eq(TMapper::getPoints,"1").eq(TMapper::getDescriptionSet,"1");
        wrapper2.orderByAsc(TMapper::getDescriptionSort);
        List<TMapper> listJi = mapperService.list(wrapper2);
        if ( listJi.size()>0 ){
            for (TMapper mapper : listJi){
                documentList.add(mapper.getMetadataName());
            }
            //去掉重复数据
            List<String> uniqueList = documentList.stream().distinct().collect(Collectors.toList());
            return uniqueList;
        }else {
            documentList = new ArrayList<>();
            return documentList;
        }
    }


    //批量添加任务
    @Override
    public CommonResult insertBatchAdd(TJuanji tJuanji) {
        // 获取当前的用户
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();
        //获取批次的档案类型
        String dalx = getOneDh(tJuanji.getPcId());
        //获取当前工序   0--不存在工序
        Integer integer = commonSzhjgService.processId(tJuanji.getPcId(), null);
        //查询编号对应的字段
        List<TMapper> listMapper = queryNumberList(dalx);

        //获取(起始-终止)信息
        String start = tJuanji.getStartNumber();
        String terminate = tJuanji.getTerminateNumber();
        String zero = (start.length() == 3) ? "000" : "0000";  //存放零(0)字段
        //转换类型
        Integer a = Integer.valueOf(start);
        Integer b = Integer.valueOf(terminate);

        //创建一个存放编号的空集合
        List<String> objectName = new ArrayList<>();
        //生成编号
        while(a<=b){
            DecimalFormat df = new DecimalFormat(zero);
            String j = df.format(Integer.parseInt(String.valueOf(a)));
            StringBuilder name = new StringBuilder(); //存放拼接编号
            try {
                Class<?> entityType = TJuanji.class;
                for (TMapper mapper: listMapper){
                    if ("是".equals(mapper.getBulkAdd())){
                        name.append(j).append('-');
                    }else {
                        Field field = entityType.getDeclaredField(mapper.getSourceName());
                        field.setAccessible(true);
                        Object value = field.get(tJuanji);
                        name.append(value.toString()).append('-');
                    }
                }
                name.deleteCharAt(name.length() - 1);    // 删除最后一个"-"
                objectName.add(name.toString());
                a++;
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        //判断编号集合是否有数据
        if ( objectName.isEmpty() ){
            return CommonResult.error("批量新增失败");
        }
        //查询编号是否重复
        LambdaQueryWrapper<TJuanji> juanWrapper = new LambdaQueryWrapper<>();
        juanWrapper.in(TJuanji::getBh,objectName).orderByAsc(TJuanji::getBh);
        List<TJuanji> listJuan = tJuanjiService.list(juanWrapper);
        if (listJuan.size()>0){
            //创建存放信息数据变量
            int failureNum = 0;
            StringBuilder failureMsg = new StringBuilder();   //存放重复数据信息
            for (TJuanji t : listJuan){
                failureNum++;
                String msg = "<br/>" + failureNum + "、生成的信息【" + t.getBh() + "】已存在。";
                failureMsg.append(msg);
            }
            failureMsg.insert(0, "批量新增失败！共 " + failureNum + " 条数据已存在 ：");
            return new CommonResult(200,failureMsg.toString(),0);
        }

        //生成编号对应信息
        //获取批量字段
        List<TMapper> mapperList = listMapper.stream().filter(m -> "是".equals(m.getBulkAdd())).collect(Collectors.toList());
        String mapper = mapperList.get(0).getSourceName();
        List<TJuanji> juanList = new ArrayList<>();   //存放信息
        try {
            Field field = TJuanji.class.getDeclaredField(mapper);    //根据属性名获取对应的对象
            field.setAccessible(true);   //设置可访问
            Integer k = Integer.valueOf(start);
            for (String s : objectName ){
                DecimalFormat df = new DecimalFormat(zero);
                String o = df.format(Integer.parseInt(String.valueOf(k)));
                TJuanji juan = new TJuanji();             //创建实体类
                BeanUtils.copyProperties(tJuanji,juan);   //拷贝赋值
                juan.setId(IdUtils.simpleUUID());
                juan.setRwzt("未进行");
                juan.setDqgx(integer);
                juan.setCataloged("未著录");
                juan.setCreateBy(userName);
                juan.setCreateTime(new Date());
                juan.setDalx(dalx);
                juan.setBh(s);
                field.set(juan, o );  //修改属性值
                juanList.add(juan);
                k++;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        boolean i = tJuanjiService.saveBatch(juanList);
        if (i) {
            return new CommonResult(200, "批量新增任务成功！共 " + juanList.size() + " 条。", 2);
        } else {
            return new CommonResult(200,"批量新增任务失败！",0);
        }
    }



    //查询编号组成
    private List<TMapper> queryNumberList(String dalx) {
        LambdaQueryWrapper<TMapper> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TMapper::getDaId,dalx).eq(TMapper::getPoints,"0").eq(TMapper::getBerSet,"2");
        wrapper.orderByAsc(TMapper::getBerSort);
        return  mapperService.list(wrapper);
    }






    /*//查询人事档案分类
    @Override
    public List<Object> queryDictType() {
        List<Object> listMap = null;
        try {
            List<SysDictData> dataList = queryClassification();
            listMap = new ArrayList<>();
            for (SysDictData sysDictData : dataList) {
                Map<String, Object> map = new HashMap<>();
                map.put("label", sysDictData.getDictValue()+". "+sysDictData.getDictLabel());
                map.put("value", sysDictData.getDictLabel());
                if ("四".equals(sysDictData.getDictValue()) || "九".equals(sysDictData.getDictValue())){
                    map.put("disabled",true);
                }
                listMap.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ArithmeticException("查询字典表人事档案分类数据失败");
        }
        return listMap;
    }

    //著录--案件著录查询人事档案分类类号
    @Override
    public String casePersonnelClass(String ajId, String clfl) {
        String num = "";
        LambdaQueryWrapper<TTaskPiece> pieceWrapper = new LambdaQueryWrapper<>();
        pieceWrapper.eq(TTaskPiece::getAjId,ajId).eq(TTaskPiece::getClfl,clfl);
        pieceWrapper.eq(TTaskPiece::getSfsy,"是");
        List<TTaskPiece> pieceList = tTaskPieceService.list(pieceWrapper);

        List<SysDictData> dataList = queryClassification();
        String number = "";
        for(SysDictData dictData :dataList){
            if (dictData.getDictLabel().equals(clfl)){
                number = dictData.getDictValue();
            }
        }
        if (pieceList.size()>0){
            //获取集合中,类号字段
            Set<String> clList = pieceList.stream().map(TTaskPiece::getCllh).collect(Collectors.toSet());//过滤重复内容
            int i1 = 0;
            if(number.contains("-")){
                for (String cl : clList){
                    int lastIndex = cl.lastIndexOf("-");
                    if (lastIndex != -1) {
                        String suffix = cl.substring(lastIndex + 1);
                        int i2 = Integer.parseInt(suffix);
                        if ( i2>i1 ){
                            i1 = i2;
                        }
                    }
                }
                num = number+"-"+(i1+1);
            }else {
                for (String cl : clList){
                    int i2 = Integer.parseInt(cl);
                    if ( i2>i1 ){
                        i1 = i2;
                    }
                }
                num = i1+1+"";
            }
        }else {
            if (number.contains("-")){
                num = number+ "-1";
            } else {
                num = "1";
            }
        }
        return num;
    }

    //查询字典表人事档案材料类别
    private List<SysDictData> queryClassification() {
        List<SysDictData> dataList = sysDictDataMapper.selectDictDataByType("zb97");
        if (StringUtils.isNotEmpty(dataList)){
            return dataList;
        }else {
           dataList = new ArrayList<>();
            return dataList;
        }
    }*/


}
