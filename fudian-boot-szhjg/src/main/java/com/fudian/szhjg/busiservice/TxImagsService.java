package com.fudian.szhjg.busiservice;


import com.fudian.common.pojo.CommonResult;
import org.springframework.web.multipart.MultipartFile;

//图片(图像)操作处理
public interface TxImagsService {

    //查询文件图片(图像)列表
    CommonResult queryFileImageList(String ajId, String jh);

    //图片(图像)上下移动
    CommonResult pictureMoveUpAndDown(String currentId, String editId);

    //查询上(下)一件图片(图像)列表
    CommonResult queryNextPiece(String id);

    //图片(图像)替换或保存
    CommonResult imageReplacement(MultipartFile replaceFile, String id);

}
