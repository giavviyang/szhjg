package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.busiservice.CheckService;
import com.fudian.szhjg.mapper.TJianjiMapper;
import com.fudian.szhjg.pojo.TChoujianTask;
import com.fudian.szhjg.pojo.TJianji;
import com.fudian.szhjg.service.TJianjiService;
import com.fudian.szhjg.templateMode.CommonTemplate;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "A62  抽检")
@RestController
@RequestMapping("/spot/check")
public class CheckController {

    @Autowired
    private TJianjiMapper tJianjiMapper;
    @Autowired
    private TJianjiService tJianjiService;

    @Autowired
    private CheckService checkService;

    /**抽检查询案卷信息列表
     * 2023-03-22
     * @param choujianTask
     * @return
     */
    @ApiOperation("抽检--查看案卷信息列表")
    @ApiOperationSupport(order = 1)
    @GetMapping("/queryRandomCase")
    @ResponseBody
    public CommonGridResult queryRandomCase(TChoujianTask choujianTask){
        choujianTask.setTaskFlag("0");
        return checkService.queryRandomCase(choujianTask);
    }


    /**查询案件信息
     * 2023-03-23
     * @param tJianji
     * @return
     */
    @ApiOperation("抽检--查询查看文件(案件)信息列表")
    @ApiOperationSupport(order = 2)
    @GetMapping("/queryCaseInspection")
    @ResponseBody
    public CommonGridResult queryCaseInspection(TJianji tJianji){
        CommonTemplate commonTemplate = new CommonTemplate(tJianji,tJianjiService,tJianjiMapper);
        LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJianji::getAjId,tJianji.getAjId()).eq(TJianji::getSfsy,"是");
        wrapper.orderByAsc(TJianji::getYm);
        CommonGridResult commonGridResult = commonTemplate.list2(wrapper);
        return commonGridResult;
    }


    @ApiOperation("完成抽检")
    @ApiOperationSupport(order = 6)
    @GetMapping("/completeSpotCheck")
    public CommonResult completeSpotCheck(String id){
        return checkService.completeSpotCheck(id);
    }

    @ApiOperation("一键完成")
    @GetMapping("/completeClickList")
    @ApiOperationSupport(order = 7)
    public CommonResult completeClickList(String pcId){
        return checkService.completeClickList(pcId);
    }


    @ApiOperation("查看抽检案卷历史信息列表")
    @ApiOperationSupport(order = 8)
    @GetMapping("/queryRandomHistory")
    @ResponseBody
    public CommonGridResult queryRandomHistory(TChoujianTask choujianTask){
        choujianTask.setTaskFlag("1");
        return checkService.queryRandomCase(choujianTask);
    }

    @ApiOperation("历史抽检回退")
    @ApiOperationSupport(order = 9)
    @GetMapping("/spotCheckRollback")
    public CommonResult spotCheckRollback(String id){
        return checkService.spotCheckRollback(id);
    }


    @ApiOperation("抽检页面查询抽检人")
    @ApiOperationSupport(order = 10)
    @GetMapping("/querySamplingPeople")
    public List<Map<String, String>> querySamplingPeople() {
        return checkService.querySamplingPeople();
    }


    @ApiOperation("抽检历史记录中查询抽检时间")
    @ApiOperationSupport(order = 11)
    @GetMapping("/querySamplingTime")
    public List<Map<String, String>> querySamplingTime() {
        return checkService.querySamplingTime();
    }



}
