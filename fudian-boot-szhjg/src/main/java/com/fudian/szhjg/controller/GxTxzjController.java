package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.szhjg.busiservice.TxImageService;
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

import java.io.IOException;


@Api(tags = "A35  数据加工-图像质检(质检和处理)")
@RestController
@RequestMapping("/sjjg/txzj")
public class GxTxzjController {

    @Autowired
    private TJuanjiMapper tJuanjiMapper;
    @Autowired
    private TJuanjiService tJuanjiService;

    @Autowired
    private TxImageService txImageService;



    @ApiOperation("图像质检-查询任务列表")
    @ApiOperationSupport(order = 11)
    @GetMapping("/queryTxzjTaskList")
    @ResponseBody
    public CommonGridResult queryTxzjTaskList(TJuanji taskJuan){
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();
        CommonTemplate commonTemplate = new CommonTemplate(taskJuan,tJuanjiService,tJuanjiMapper);
        LambdaQueryWrapper<TJuanji> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(taskJuan.getPcId())){
            wrapper.eq(TJuanji::getPcId,taskJuan.getPcId());
        }
        if (StringUtils.isNotBlank(taskJuan.getBh())){
            wrapper.like(TJuanji::getBh,taskJuan.getBh());
        }
        wrapper.eq(TJuanji::getDqgx,"5").eq(TJuanji::getLqr,userName).eq(TJuanji::getRwzt,"进行中");
        wrapper.ne(TJuanji::getCataloged,"著录中");
        wrapper.orderByAsc(TJuanji::getClaimTime);
        CommonGridResult commonGridResult = commonTemplate.list(wrapper);
        return commonGridResult;
    }


    @ApiOperation("质检和处理-查询任务列表")
    @ApiOperationSupport(order = 21)
    @GetMapping("/queryZjHClTaskList")
    @ResponseBody
    public CommonGridResult queryZjHClTaskList(TJuanji taskJuan){
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();
        CommonTemplate commonTemplate = new CommonTemplate(taskJuan,tJuanjiService,tJuanjiMapper);
        LambdaQueryWrapper<TJuanji> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(taskJuan.getPcId())){
            wrapper.eq(TJuanji::getPcId,taskJuan.getPcId());
        }
        if (StringUtils.isNotBlank(taskJuan.getBh())){
            wrapper.like(TJuanji::getBh,taskJuan.getBh());
        }
        wrapper.and(w ->w.eq(TJuanji::getDqgx,"4").or().eq(TJuanji::getDqgx,"5").or().eq(TJuanji::getDqgx,"6"));
        wrapper.eq(TJuanji::getLqr,userName).eq(TJuanji::getRwzt,"进行中");
        wrapper.ne(TJuanji::getCataloged,"著录中");
        wrapper.orderByAsc(TJuanji::getClaimTime);
        CommonGridResult commonGridResult = commonTemplate.list(wrapper);
        return commonGridResult;
    }

    @ApiOperation("查看图片缩略图")
    @ApiOperationSupport(order = 31)
    @GetMapping("/imageThumbnail")
    public CommonResult imageThumbnail(@RequestParam("id") String id) throws IOException {
        return txImageService.imageThumbnail(id);
    }
    /*public CommonGridResult imageThumbnail(@RequestParam("id") String id) throws IOException {
        CommonGridResult commonGridResult = txImageService.imageThumbnail(id);
        return commonGridResult;
    }*/


}
