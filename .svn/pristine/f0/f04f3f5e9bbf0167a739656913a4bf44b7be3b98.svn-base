package com.fudian.szhjg.busiservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.busiservice.TxImagsService;
import com.fudian.szhjg.mapper.TJianjiMapper;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.pojo.TBatch;
import com.fudian.szhjg.pojo.TJianji;
import com.fudian.szhjg.pojo.TJuanji;
import com.fudian.szhjg.pojo.vo.ImageDto;
import com.fudian.szhjg.service.TBatchService;
import com.fudian.szhjg.service.TJianjiService;
import com.fudian.szhjg.service.TJuanjiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;


//图片(图像)操作处理
@Service
public class TxImagsServiceImpl implements TxImagsService {

    //批次
    @Autowired
    private TBatchService batchService;

    //案卷
    @Autowired
    private TJuanjiMapper juanjiMapper;
    @Autowired
    private TJuanjiService juanjiService;

    //文件
    @Autowired
    private TJianjiMapper jianjiMapper;
    @Autowired
    private TJianjiService jianjiService;



    //查询文件图片(图像)列表
    @Override
    public CommonResult queryFileImageList(String ajId, String jh) {
        LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        //根据案卷和件号进行查询,根据页码排序
        wrapper.eq(TJianji::getAjId,ajId).eq(TJianji::getJh,jh).orderByAsc(TJianji::getYm);
        List<TJianji> listJian = jianjiService.list(wrapper);
        //获取图片信息
        List<ImageDto> imageDtos = new ArrayList<>();
        int page = 0;
        for (TJianji t: listJian){
            ImageDto imageDto = new ImageDto();
            imageDto.setId(t.getId());
            imageDto.setFileName(extractFileName(t.getTpdz()));
            imageDto.setFileCount(jh);
            imageDto.setPageCount(++page);
            imageDto.setImgDes("第"+t.getYm()+"页");
            imageDto.setImgUrl(getPhoto(t.getTpdz()));
            imageDtos.add(imageDto);
        }
        return CommonResult.success(imageDtos);
    }

    //path为图片在服务器的绝对路径
    private String getPhoto(String path) {
        try {
            if (path == null || path.isEmpty()) {
                //如果路径为空或没有值，返回空字符串
                return "";          //返回空字符串

                /*//创建一个空白图片
                BufferedImage blankImage = new BufferedImage(600, 300, BufferedImage.TYPE_INT_ARGB);
                // 在空白图片上绘制文本
                Graphics2D graphics = blankImage.createGraphics();
                graphics.setBackground(Color.WHITE);                             //设置背景色为白色
                graphics.clearRect(0, 0, 600, 300);           //清除背景
                graphics.setFont(new Font("Serif", Font.BOLD, 32));  // 置文本样式、大小等
                graphics.setColor(Color.BLACK);                                 // 设置文本颜色为黄色
                String text = "当前没有图片, 请添加图片! ";
                FontMetrics fontMetrics = graphics.getFontMetrics();
                int textWidth = fontMetrics.stringWidth(text);
                int textHeight = fontMetrics.getHeight();
                int x = (blankImage.getWidth() - textWidth) / 2;
                int y = (blankImage.getHeight() - textHeight) / 2 + fontMetrics.getAscent();
                graphics.drawString(text, x, y);                                 //绘制文本
                // 将空白图片转换为字节数组
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    ImageIO.write(blankImage, "png", baos);
                    baos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        baos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return Base64.getEncoder().encodeToString(baos.toByteArray());*/
            }

            //用于图片文件的读取和编码
            String suffix = path.substring(path.lastIndexOf(".") + 1);
            BufferedImage image = ImageIO.read(new File(path));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, suffix, outputStream);
            byte[] data = outputStream.toByteArray();
            return Base64.getEncoder().encodeToString(data);

            /*//针对所有类型文件的读取和编码
            File file = new File(path);
            FileInputStream fis;
            fis = new FileInputStream(file);
            long size = file.length();
            byte[] temp = new byte[(int) size];
            fis.read(temp, 0, (int) size);
            fis.close();
            byte[] data = temp;
            return new String(Base64.getEncoder().encodeToString(data));*/
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据地址获取文件名
    public static String extractFileName(String path) {
        if (path == null || path.isEmpty()) {
            //如果路径为空或没有值，返回空字符串
            return "";          //返回空字符串
            //返回信息"2000121200000000000000000.png"的后缀名需要跟上面生成默认图片的类型一样
            //return "2000121200000000000000000.png";
        }
        File file = new File(path);
        return file.getName();  //使用File类提供的方法获取文件名
    }




    //图片(图像)上下移动  [currentId:当前页; editId:上(下)移页]
    @Override
    public CommonResult pictureMoveUpAndDown(String currentId, String editId) {
        //根据id查询
        TJianji current = queryPageMessage(currentId);   //查询当前页信息
        TJianji edit = queryPageMessage(editId);         //查询需要上(下)移页信息
        //获取图片(图像)地址
        String currentTpDz = current.getTpdz();
        String editTpDz = edit.getTpdz();
        //交换图片(图像)地址
        current.setTpdz(editTpDz);
        edit.setTpdz(currentTpDz);
        //保存信息
        boolean b1 = jianjiService.updateById(current);
        boolean b2 = jianjiService.updateById(edit);
        //返回信息
        if (b1 && b2){
            return CommonResult.success("修改成功");
        }else {
            return CommonResult.error("修改失败");
        }
    }

    //根据id查询对应图片信息
    private TJianji queryPageMessage(String id) {
        LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJianji::getId,id).orderByAsc(TJianji::getYm);
        List<TJianji> list = jianjiService.list(wrapper);
        TJianji tJianji = new TJianji();
        if (list.size()>0){
            tJianji = list.get(0);
        }
        return tJianji;
    }




    //查询上(下)一件图片(图像)列表
    @Override
    public CommonResult queryNextPiece(String id) {
        //查询当前id信息,获取案卷id
        TJianji tJianji = queryPageMessage(id);
        //查询案卷id对应的文件信息
        LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJianji::getAjId,tJianji.getAjId()).eq(TJianji::getSfsy,"是").orderByAsc(TJianji::getYm);
        List<TJianji> list = jianjiService.list(wrapper);
        //根据获取到的tJianji实体类中的jh值，获取集合list中的下一件信息
        int currentIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (tJianji.getJh().equals(list.get(i).getJh())) {
                currentIndex = i;
                break;
            }
        }
        if (currentIndex != -1 && currentIndex < list.size() - 1) {
            //获取到的下一件件号
            String fileCount = list.get(currentIndex + 1).getJh();
            //查询对应件号下信息
            LambdaQueryWrapper<TJianji> JhWrapper = new LambdaQueryWrapper<>();
            JhWrapper.eq(TJianji::getAjId,tJianji.getAjId()).eq(TJianji::getJh,fileCount).orderByAsc(TJianji::getYm);
            List<TJianji> listJh = jianjiService.list(JhWrapper);
            //存放图片信息
            List<ImageDto> imageDtoList = new ArrayList<>();
            int page = 0;
            for (TJianji jian : listJh){
                ImageDto imageDto = new ImageDto();
                imageDto.setId(jian.getId());
                imageDto.setFileName(extractFileName(jian.getTpdz()));
                imageDto.setFileCount(fileCount);
                imageDto.setPageCount(++page);
                imageDto.setImgDes("第"+jian.getYm()+"页");
                imageDto.setImgUrl(getPhoto(jian.getTpdz()));
                imageDtoList.add(imageDto);
            }
            return CommonResult.success(imageDtoList);
        } else {
            //return CommonResult.error("未查询到下一件信息");
            return CommonResult.success("NoData");
        }
    }




    //图片(图像)替换或保存
    @Override
    public CommonResult imageReplacement(MultipartFile replaceFile, String id) {
        try {
            //根据id获取单条信息
            TJianji tJianji = queryPageMessage(id);
            if (tJianji.getId() == null) {
                return CommonResult.success("未能查询到相关数据，图片保存失败! ","9999");
            }
            //获取图片地址
            String chartAddress = tJianji.getTpdz();
            //获取图片(图像)名
            String fileName = replaceFile.getOriginalFilename();
            //获取图片(图像)后缀
            if (fileName == null || fileName.isEmpty()) {
                return CommonResult.success("获取保存图片名称失败，无法获取图片名称信息。","9999");
            }
            fileName = convertExtensionToLowerCase(fileName);   //文件后缀名转换为小写
            String fileType = getFileType(fileName);
            //判断后缀名是否符合要求
            if (!suffixList(fileType)) {
                return CommonResult.success("图片格式不支持","9999");
            }
            //判断图片地址是否存在  [(存在-替换);(不存在-保存)]
            if (StringUtils.isNotBlank(chartAddress)){
                //删除原图像
                File fileOriginal = new File(chartAddress);
                if (fileOriginal.exists() && !fileOriginal.delete()) {
                    return CommonResult.error("图片删除失败");
                }
                //判断后缀名是否改变
                String change = "";
                String suffix = chartAddress.substring(chartAddress.lastIndexOf("."));
                if ( !fileType.equals(suffix) ){
                    //使用replaceFirst方法替换后缀名  如将".jpg"替换为".png"
                    chartAddress = chartAddress.replaceFirst("\\.\\w+$", fileType);
                    change = "change";
                }
                //保存图片
                File file = new File(chartAddress);  //将文件保存到指定路径
                replaceFile.transferTo(file);
                /*//保存图片
                FileOutputStream out = new FileOutputStream(chartAddress);
                //获取输入流
                InputStream in = replaceFile.getInputStream();
                //写入目标文件
                byte[] buffer = new byte[4096];
                int byteRead;
                while ((byteRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, byteRead);
                    out.flush();
                }
                out.close();
                in.close();*/
                //修改数据库中文件路径
                if ("change".equals(change)){
                    tJianji.setTpdz(chartAddress);
                    boolean b = jianjiService.updateById(tJianji);
                    if ( !b ){
                        return CommonResult.success("图片地址更新失败","9999");
                    }
                }
                return CommonResult.success("图片保存成功");
            }else {
                //查询保存路径文件夹
                String savePath = savePathName(tJianji.getAjId());
                if (savePath.isEmpty()) {
                    return CommonResult.success("图片保存路径为空，请检查相关数据。","9999");
                }
                //判断保存路径文件夹是否存在,不存在创建新的文件夹
                File folder = new File(savePath);
                if (!folder.exists()) {
                    boolean created = folder.mkdirs();
                    if (!created) {
                        return CommonResult.success("图片保存失败","9999");
                    }
                }
                //获取当前时间戳
                String timestamp = soleTimestamp();
                //拼接保存图片名称
                String filePath = savePath+"\\" + timestamp + fileType;
                File file = new File(filePath);  //将文件保存到指定路径
                replaceFile.transferTo(file);
                //添加数据库中文件路径
                tJianji.setTpdz(filePath);
                boolean b = jianjiService.updateById(tJianji);
                if ( !b ){
                    return CommonResult.success("图片地址更新失败","9999");
                }
                return CommonResult.success("图片保存成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.success("图片保存失败","9999");
        }
    }

    //文件后缀名转换为小写
    private String convertExtensionToLowerCase(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex != -1) {
            String extension = fileName.substring(dotIndex + 1).toLowerCase();
            String baseName = fileName.substring(0, dotIndex);
            return baseName + "." + extension;
        }
        return fileName;
    }
    //获取文件后缀名(.jpg)
    private String getFileType(String fileName) {
        //return fileName.substring((fileName.lastIndexOf("."))+1,fileName.length());  //jpg
        //return fileName.substring(fileName.lastIndexOf("."),fileName.length());    //.jpg
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex != -1) {
            return fileName.substring(dotIndex);
        }
        return "";
    }
    //判断是否支持的图片格式
    private boolean suffixList(String fileType) {
        //存放图片(图像)后缀名
        List<String> suffixList = Arrays.asList(".jpg",".png",".gif",".jpeg");
        //return suffixList.contains(fileType.toLowerCase());    //支持fileType传大写字母转换小写字母比较
        return suffixList.contains(fileType);
    }

    //查询图片保存路径
    private String savePathName(String ajId) {
        LambdaQueryWrapper<TJuanji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJuanji::getId,ajId);
        List<TJuanji> list = juanjiService.list(wrapper);
        if (!list.isEmpty()) {
            LambdaQueryWrapper<TBatch> batchWrapper = new LambdaQueryWrapper<>();
            batchWrapper.eq(TBatch::getId,list.get(0).getPcId());
            List<TBatch> batchList = batchService.list(batchWrapper);
            if (!batchList.isEmpty()) {
                return batchList.get(0).getPrjFilepath()+"\\"+list.get(0).getBh();
            }
        }
        return "";
    }
    //获取唯一时间戳
    private String soleTimestamp() {
        //获取当前的精确时间
        //Instant now = Instant.now();      //时间戳是指从1970年1月1日00:00:00 UTC（协调世界时）开始计算的经过的毫秒数
        Instant now = Instant.now();
        ZoneId zone = ZoneId.of("Asia/Shanghai");      //获取东八区(UTC+8),这里指定上海时区
        ZoneOffset offset = zone.getRules().getOffset(now);
        Instant chinaTime = now.plusSeconds(offset.getTotalSeconds());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").withZone(ZoneOffset.UTC);
        String timestamp = formatter.format(chinaTime);
        //获取uuid
        UUID uuid = UUID.randomUUID();
        //String uniqueId = Long.toHexString(uuid.getMostSignificantBits()) + Long.toHexString(uuid.getLeastSignificantBits());
        String uniqueId = uuid.toString().replace("-", "");
        return timestamp + uniqueId.substring(0, 8);
    }

}
