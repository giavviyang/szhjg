package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.busiservice.CommonApproachService;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.pojo.TGrgzltj;
import com.fudian.szhjg.pojo.TJuanji;
import com.fudian.szhjg.pojo.vo.ReworkVO;
import com.fudian.szhjg.service.TJuanjiService;
import com.fudian.szhjg.templateMode.CommonTemplate;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "A02  加工通用方法")
@RestController
@RequestMapping("/szhjgApproach")
public class CommonApproachController {

    @Autowired
    private TJuanjiMapper tJuanjiMapper;
    @Autowired
    private TJuanjiService tJuanjiService;

    @Autowired
    private CommonApproachService commonApproachService;


    @ApiOperation("领取任务-查询可以领取任务列表")
    @ApiOperationSupport(order = 11)
    @GetMapping("/queryRetrievesTaskList")
    @ResponseBody
    public CommonGridResult queryRetrievesTaskList(TJuanji tJuanji){
        CommonTemplate commonTemplate = new CommonTemplate(tJuanji,tJuanjiService,tJuanjiMapper);
        LambdaQueryWrapper<TJuanji> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(tJuanji.getPcId())){
            wrapper.eq(TJuanji::getPcId,tJuanji.getPcId());
        }
        if (StringUtils.isNotBlank(tJuanji.getBh())){
            wrapper.like(TJuanji::getBh,tJuanji.getBh());
        }
        wrapper.eq(TJuanji::getRwzt,"未进行");
        if (tJuanji.getDqgx()==6){
            wrapper.and(w ->w.eq(TJuanji::getDqgx,"4").or().eq(TJuanji::getDqgx,"5").or().eq(TJuanji::getDqgx,"6"));
            wrapper.orderByAsc(TJuanji::getDqgx).orderByAsc(TJuanji::getBh);
        }else if (tJuanji.getDqgx()==7) {
            wrapper.eq(TJuanji::getCataloged,"未著录");
            wrapper.orderByDesc(TJuanji::getDqgx).orderByAsc(TJuanji::getBh);
        }else {
            wrapper.eq(TJuanji::getDqgx,tJuanji.getDqgx());
            wrapper.orderByAsc(TJuanji::getBh);
        }
        CommonGridResult commonGridResult = commonTemplate.list(wrapper);
        return commonGridResult;
    }


    @ApiOperation("领取任务-领取选择任务Id(其他工序)")
    @ApiOperationSupport(order = 12)
    @PostMapping("/selectFetchTaskIds/{ids}")
    public CommonResult selectFetchTaskIds(@PathVariable String[] ids) {
        return commonApproachService.selectFetchTaskIds(ids);
    }

    @ApiOperation("领取任务-领取选择任务Id(目录著录专用)")
    @ApiOperationSupport(order = 13)
    @PostMapping("/selectRecordTaskIds/{ids}")
    public CommonResult selectRecordTaskIds(@PathVariable String[] ids) {
        return commonApproachService.selectRecordTaskIds(ids);
    }


    @ApiOperation("通过-查询下一个工序名称")
    @ApiOperationSupport(order = 21)
    @GetMapping("/queryNextGxName")
    public ResponseEntity queryNextGxName(String id, Integer gxName){
        String  name= commonApproachService.queryNextGxName(id,gxName);
        return ResponseEntity.ok(CommonResult.success(name));
    }

    @ApiOperation("通过-数据加工提交方法")
    @ApiOperationSupport(order = 22)
    @PostMapping("/processingSubmitPass")
    public CommonResult processingSubmitPass(String ajId ,Integer gxId){
        return commonApproachService.processingSubmitPass(ajId,gxId);
    }

    @ApiOperation("通过-目录著录任务提交方法")
    @ApiOperationSupport(order = 23)
    @PostMapping("/catalogueSubmitPass")
    public CommonResult catalogueSubmitPass(String ajId){
        return commonApproachService.catalogueSubmitPass(ajId);
    }



    @ApiOperation("返工-查询项目对应的工序")
    @ApiOperationSupport(order = 31)
    @GetMapping("/reworkQueryProject")
    public List<Object> reworkQueryProject(String ajId){
        return commonApproachService.reworkQueryProject(ajId);
    }

    @ApiOperation("返工-提交返工方法")
    @ApiOperationSupport(order = 32)
    @PostMapping("/reworkSubmitPass")
    @ResponseBody
    public CommonResult reworkSubmitPass(@Validated @RequestBody ReworkVO reworkVO){
        CommonResult commonResult = commonApproachService.reworkSubmitPass(reworkVO);
        return commonResult;
    }

    @ApiOperation("返工-目录著录任务返工方法")
    @ApiOperationSupport(order = 33)
    @PostMapping("/catalogDescriptionRework")
    @ResponseBody
    public CommonResult catalogDescriptionRework(@Validated @RequestBody ReworkVO reworkVO){
        CommonResult commonResult = commonApproachService.catalogDescriptionRework(reworkVO);
        return commonResult;
    }



    @ApiOperation("查看当前用户记录(查看记录)")
    @ApiOperationSupport(order = 41)
    @GetMapping("/viewCurrentUserRecord")
    @ResponseBody
    public CommonGridResult viewCurrentUserRecord(TGrgzltj tGrgzltj){
        return commonApproachService.viewCurrentUserRecord(tGrgzltj);
    }


    @ApiOperation("查询总页数和图片总数")
    @ApiOperationSupport(order = 42)
    @GetMapping("/queryPictureTotal")
    @ResponseBody
    public CommonResult queryPictureTotal(String ajId){
        CommonResult result = commonApproachService.queryPictureTotal(ajId);
        return result;
    }


}
