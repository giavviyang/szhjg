package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.pojo.TJuanji;
import com.fudian.szhjg.service.TJuanjiService;
import com.fudian.szhjg.templateMode.CommonTemplate;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "A33  数据加工-图像扫描")
@RestController
@RequestMapping("/sjjg/txsm")
public class GxTxsmController {

    @Autowired
    private TJuanjiMapper tJuanjiMapper;
    @Autowired
    private TJuanjiService tJuanjiService;


    @ApiOperation("图像扫描-查询任务列表")
    @ApiOperationSupport(order = 1)
    @GetMapping("/queryTxsmTaskList")
    @ResponseBody
    public CommonGridResult queryTxsmTaskList(TJuanji tJuanji){
        //获取当前的用户
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();

        CommonTemplate commonTemplate = new CommonTemplate(tJuanji,tJuanjiService,tJuanjiMapper);
        LambdaQueryWrapper<TJuanji> tWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(tJuanji.getPcId())){
            tWrapper.eq(TJuanji::getPcId,tJuanji.getPcId());
        }
        if (StringUtils.isNotBlank(tJuanji.getBh())){
            tWrapper.like(TJuanji::getBh,tJuanji.getBh());
        }
        tWrapper.eq(TJuanji::getDqgx,"3").eq(TJuanji::getLqr,userName).eq(TJuanji::getRwzt,"进行中");
        tWrapper.ne(TJuanji::getCataloged,"著录中");
        tWrapper.orderByAsc(TJuanji::getClaimTime);
        CommonGridResult commonGridResult = commonTemplate.list(tWrapper);
        return commonGridResult;
    }


}
