package com.fudian.szhjg.busiservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.busiservice.TxImageService;
import com.fudian.szhjg.pojo.TJianji;
import com.fudian.szhjg.pojo.TTaskPiece;
import com.fudian.szhjg.service.TJianjiService;
import com.fudian.szhjg.service.TTaskPieceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TxImageServiceImpl implements TxImageService {

    @Autowired
    private TJianjiService tJianjiService;
    /*@Autowired
    private TTaskPieceService taskPieceService;*/



    //目录著录-文件查询图片列表方法
    @Override
    public CommonGridResult queryPicturePiece(TJianji tJianji) {
        LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJianji::getAjId,tJianji.getAjId()).eq(TJianji::getJh,tJianji.getJh());
        wrapper.orderByAsc(TJianji::getYm);
        List<TJianji> pieceList = tJianjiService.list(wrapper);
        return new CommonGridResult(pieceList.size(),pieceList);
    }

    //数据质检-查询案件信息(查询每件下详细信息)
    @Override
    public CommonGridResult searchCasePieceList(TJianji tJianji) {
        LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJianji::getAjId,tJianji.getAjId()).eq(TJianji::getSfsy,"是");
        wrapper.orderByAsc(TJianji::getYm);
        List<TJianji> pieceList = tJianjiService.list(wrapper);
        if ( pieceList.size() != 0 ){
            for (TJianji piece : pieceList){
                LambdaQueryWrapper<TJianji> taskPiece =  new LambdaQueryWrapper<>();
                taskPiece.eq(TJianji::getAjId,piece.getAjId()).eq(TJianji::getJh,piece.getJh()).eq(TJianji::getSfsy,"否");
                taskPiece.orderByAsc(TJianji::getYm);
                List<TJianji> listPiece = tJianjiService.list(taskPiece);
                piece.setChildren(listPiece);
            }
        }
        return new CommonGridResult(pieceList.size(),pieceList);
    }



    //图像处理修改替换图片
    @Override
    public CommonResult addFileImage(MultipartFile file, String fileType, String id) throws IOException {
        //查询单条数据
        LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJianji::getId,id);
        List<TJianji> list = tJianjiService.list(wrapper);
        TJianji taskPiece = new TJianji();
        if ( list.size()>0 ){
            taskPiece = list.get(0);
        }
        //获取图片的路径
        String imagePath = taskPiece.getTpdz();
        if (StringUtils.isBlank(imagePath)){
            return CommonResult.error("获取图片地址失败");
        }
        //删除原图像
        File fileOriginal = new File(imagePath);  //创建文件对象
        //判断图片是否存在
        if ( fileOriginal.exists() ) {
            //删除文件
            Boolean flag = fileOriginal.delete();
            if( !flag ){
                return CommonResult.error("图片删除失败");
            }
        }
        //判断后缀名是否改变
        String change = "";
        String suffix = imagePath.substring(imagePath.lastIndexOf(".") + 1);
        if ( !fileType.equals(suffix) ){
            //使用replaceFirst方法替换后缀名  如将".jpg"替换为".png"
            imagePath = imagePath.replaceFirst("\\.\\w+$", "."+fileType);
            change = "change";
        }

        //保存图片
        FileOutputStream out = new FileOutputStream(imagePath);
        //获取输入流
        InputStream in = file.getInputStream();
        //写入目标文件
        byte[] buffer = new byte[4096];
        int byteRead;
        while ((byteRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, byteRead);
            out.flush();
        }
        out.close();
        in.close();

        //修改数据库中文件路径
        if ("change".equals(change)){
            taskPiece.setTpdz(imagePath);
            boolean b = tJianjiService.updateById(taskPiece);
            if ( !b ){
                return CommonResult.error("图片地址更新失败");
            }
        }

        return CommonResult.success("图片替换成功");
    }


    //查看图片缩略图
    @Override
    public CommonResult imageThumbnail(String id) throws IOException{
        CommonResult result = new CommonResult();
        LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJianji::getAjId,id).eq(TJianji::getSfsy,"是");
        wrapper.orderByAsc(TJianji::getYm);
        List<TJianji> pieceList = tJianjiService.list(wrapper);
        List<String> img = new LinkedList<>();
        for (TJianji piece : pieceList){
            if (StringUtils.isNotBlank(piece.getTpdz())){
                img.add(piece.getTpdz());
            }
        }
        result.put("img",img);
        return result;
    }
    /*@Override
    public CommonGridResult imageThumbnail(String id) throws IOException{
        List<byte[]> imagesList = new ArrayList<>();
        try {
            LambdaQueryWrapper<TTaskPiece> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(TTaskPiece::getAjId,id).eq(TTaskPiece::getSfsy,"是");
            wrapper.orderByAsc(TTaskPiece::getYm);
            List<TTaskPiece> pieceList = taskPieceService.list(wrapper);
            for ( TTaskPiece piece : pieceList){
                String name = piece.getTpdz();
                if (StringUtils.isBlank(name)){
                    continue;
                }
                String suffix = name.substring(name.lastIndexOf(".") + 1);
                BufferedImage image = ImageIO.read(new File(name));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(image, suffix, outputStream);
                byte[] imageBytes = outputStream.toByteArray();
                imagesList.add(imageBytes); // 添加字节数组到列表
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new CommonGridResult(imagesList.size(),imagesList);
    }*/


}
