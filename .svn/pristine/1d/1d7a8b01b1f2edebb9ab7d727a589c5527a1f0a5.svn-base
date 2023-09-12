package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.szhjg.busiservice.TxImageService;
import com.fudian.szhjg.busiservice.TxImagsService;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.pojo.TJuanji;
import com.fudian.szhjg.service.TJuanjiService;
import com.fudian.szhjg.templateMode.CommonTemplate;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Api(tags = "A34  数据加工-图像处理")
@RestController
@RequestMapping("/sjjg/txcl")
public class GxTxclController {

    @Autowired
    private TJuanjiMapper tJuanjiMapper;
    @Autowired
    private TJuanjiService tJuanjiService;

    @Autowired
    private TxImageService txImageService;

    @Autowired
    private TxImagsService txImagsService;


    @ApiOperation("图像处理-查询任务列表")
    @ApiOperationSupport(order = 1)
    @GetMapping("/queryTxclTaskList")
    @ResponseBody
    public CommonGridResult queryTxclTaskList(TJuanji tJuanji){
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();
        CommonTemplate commonTemplate = new CommonTemplate(tJuanji,tJuanjiService,tJuanjiMapper);
        LambdaQueryWrapper<TJuanji> tWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(tJuanji.getPcId())){
            tWrapper.eq(TJuanji::getPcId,tJuanji.getPcId());
        }
        if (StringUtils.isNotBlank(tJuanji.getBh())){
            tWrapper.like(TJuanji::getBh,tJuanji.getBh());
        }
        tWrapper.eq(TJuanji::getDqgx,"4").eq(TJuanji::getLqr,userName).eq(TJuanji::getRwzt,"进行中");
        tWrapper.ne(TJuanji::getCataloged,"著录中");;
        tWrapper.orderByAsc(TJuanji::getClaimTime);
        CommonGridResult commonGridResult = commonTemplate.list(tWrapper);
        return commonGridResult;
    }



    @ApiOperation("图像处理修改替换图片")
    @PostMapping("/viewPictureImage")
    @ResponseBody
    public CommonResult addFileImage(MultipartFile file, String id) {
        CommonResult commonResult =new CommonResult();
        try {
            String a = file.getContentType();
            String fileName=file.getOriginalFilename();
            String fileType=fileName.substring((fileName.lastIndexOf("."))+1,fileName.length());
            if(fileType.equals("jpg") || fileType.equals("png") || fileType.equals("gif") || a.equals("jpg") || a.equals("png") || a.equals("gif")){
                commonResult = txImageService.addFileImage(file,a,id);
            }else {
                return CommonResult.error(500,"图片格式不支持");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.error(500,"图片替换失败");
        }
        return commonResult;
    }



    //[ajId:案卷id; jh:件号]
    @ApiOperation("查询文件图片(图像)列表")
    @ApiOperationSupport(order = 11)
    @GetMapping("/queryFileImageList")
    public CommonResult queryFileImageList(@RequestParam("ajId") String ajId, @RequestParam("jh") String jh){
        return txImagsService.queryFileImageList(ajId,jh);
    }


    //[currentId:当前页; editId:上(下)移页]
    @ApiOperation("图片(图像)上(下)移动")
    @ApiOperationSupport(order = 12)
    @PostMapping("/pictureMoveUpAndDown")
    @ResponseBody
    public CommonResult pictureMoveUpAndDown(@RequestParam("currentId") String currentId,
                                             @RequestParam("editId") String editId){
     return txImagsService.pictureMoveUpAndDown(currentId,editId);
    }


    @ApiOperation("查询上(下)一件图片(图像)列表")
    @ApiOperationSupport(order = 13)
    @GetMapping("/queryNextPiece")
    public CommonResult queryNextPiece(@RequestParam("id") String id){
        return txImagsService.queryNextPiece(id);
    }


    @ApiOperation("图片(图像)替换或保存")
    @ApiOperationSupport(order = 14)
    @PostMapping("/imageReplacement")
    public CommonResult imageReplacement(@RequestParam("replaceFile") MultipartFile replaceFile,
                                         @RequestParam("id") String id){
        return txImagsService.imageReplacement(replaceFile,id);
    }

}
