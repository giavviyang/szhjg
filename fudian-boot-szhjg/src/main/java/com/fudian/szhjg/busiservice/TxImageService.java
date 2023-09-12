package com.fudian.szhjg.busiservice;

import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.pojo.TJianji;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TxImageService {

    //目录著录-文件查询图片列表方法
    CommonGridResult queryPicturePiece(TJianji tJianji);
    //数据质检-查询案件信息(查询每件下详细信息)
    CommonGridResult searchCasePieceList(TJianji tJianji);


    //图像处理修改替换图片
    CommonResult addFileImage(MultipartFile file, String fileType, String id) throws IOException;

    //查看图片缩略图
    CommonResult imageThumbnail(String id) throws IOException;
    //CommonGridResult imageThumbnail(String id) throws IOException;

}
