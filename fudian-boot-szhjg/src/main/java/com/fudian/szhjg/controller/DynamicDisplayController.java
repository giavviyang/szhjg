package com.fudian.szhjg.controller;

import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.busiservice.DynamicDisplayService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@Api(tags = "A44  业务管理-查询动态展示信息")
@Api(tags = "A03  动态查询字段方法")
@RestController
@RequestMapping("/ywgl/dynamic")
public class DynamicDisplayController {

    @Autowired
    private DynamicDisplayService dynamicDisplayService;


    /**项目管理--完成项目查询案卷动态展示字段
     * @param headId  档案类型id (daId)
     * @return
     */
    @ApiOperation("项目管理--完成项目查询案卷字段")
    @ApiOperationSupport(order = 1)
    @GetMapping("/completeDynamicsList")
    @ResponseBody
    public CommonResult completeDynamicsList(String headId){
        return dynamicDisplayService.completeDynamicsList(headId);
    }

    /**项目管理--完成项目查询文件(案件)动态字段"
     * @param headId  档案类型id (daId)
     * @return
     */
    @ApiOperation("项目管理--完成项目查询文件(案件)字段")
    @ApiOperationSupport(order = 2)
    @GetMapping("/completeDescriptionList")
    @ResponseBody
    public CommonResult completeDescriptionList(String headId){
        return dynamicDisplayService.completeDescriptionList(headId);
    }



    /**动态查询字段列表
     * @param headId  档案类型id (daId)
     * @param headPoints 案卷(0)/文件(1)  (points)
     * @param headType 表头展示(0)/表单录入(1)
     * @return
     */
    @ApiOperation("批次管理--查询动态字段")
    @ApiOperationSupport(order = 3)
    @GetMapping("/headDisplayList")
    @ResponseBody
    public CommonResult headDisplayList(String headId, String headPoints, String headType){
        if ("0".equals(headType)){
            return dynamicDisplayService.headDisplayList(headId,headPoints);
        }else if ("1".equals(headType)){
            return dynamicDisplayService.formEntryList(headId,headPoints);
        }else {
            List<Object> list = new ArrayList<>();
            return CommonResult.success(list);
        }
    }



    /**根据批次Id查询动态字段列表
     * @param headBatch    批次id
     * @param headPoints  案卷(0)/文件(1)  (points)
     * @param headType    表头展示(0)/表单录入(1)
     * @return
     */
    @ApiOperation("任务管理--根据批次Id查询动态字段列表(通用)")
    @ApiOperationSupport(order = 4)
    @GetMapping("/taskDynamicListHead")
    @ResponseBody
    public CommonResult taskDynamicListHead(String headBatch, String headPoints, String headType){
        //根据批次查询档案id
        String headId = dynamicDisplayService.queryBatchId(headBatch);
        if ("0".equals(headType)){
            return dynamicDisplayService.headDisplayList(headId,headPoints);
        }else if ("1".equals(headType)){
            return dynamicDisplayService.formEntryList(headId,headPoints);
        }else {
            List<Object> objectList = new ArrayList<>();
            return CommonResult.success(objectList);
        }
    }

    @ApiOperation("任务管理--批量添加(新增)动态字段")
    @ApiOperationSupport(order = 5)
    @GetMapping("/getsDynamicMultiple")
    @ResponseBody
    public CommonResult getsDynamicMultiple(String headBatch){
        //根据批次查询档案id
        String headId = dynamicDisplayService.queryBatchId(headBatch);
        return dynamicDisplayService.getsDynamicMultiple(headId);
    }



    /**目录著录-根据批次Id查询动态著录字段(专用)
     * @param headBatch    批次id
     * @param headPoints  案卷(0)/文件(1)  (points)
     * @return
     */
    @ApiOperation("目录著录-根据批次Id查询动态著录字段(专用)")
    @ApiOperationSupport(order = 6)
    @GetMapping("/catalogueDescriptionList")
    @ResponseBody
    public CommonResult catalogueDescriptionList(String headBatch, String headPoints){
        //根据批次查询档案id
        String headId = dynamicDisplayService.queryBatchId(headBatch);
        return dynamicDisplayService.catalogueDescriptionList(headId,headPoints);
    }



    /**抽检页面动态展示字段
     * @param headBatch    批次id
     * @param headPoints  案卷(0)/文件(1)  (points)
     * @return
     */
    @ApiOperation("抽检页面--动态展示字段")
    @ApiOperationSupport(order = 7)
    @GetMapping("/spotCheckDynamicList")
    @ResponseBody
    public CommonResult spotCheckDynamicList(String headBatch, String headPoints){
        //根据批次查询档案id
        String headId = dynamicDisplayService.queryBatchId(headBatch);
        return dynamicDisplayService.spotCheckDynamicList(headId,headPoints);
    }


}