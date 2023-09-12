package com.fudian.szhjg.controller;

import com.fudian.common.pojo.CommonGridResult;
import com.fudian.szhjg.busiservice.StatisticsCountService;
import com.fudian.szhjg.pojo.TGrgzltj;
import com.fudian.szhjg.pojo.vo.CountVO;
import com.fudian.szhjg.pojo.vo.StatisticsVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "A51  统计查询")
@RestController
@RequestMapping("/dataStatisticalQuery")
public class StatisticsController {

    @Autowired
    private StatisticsCountService countService;


    @ApiOperation("个人工作统计")
    @ApiOperationSupport(order = 10)
    @GetMapping("/individualWorkload")
    @ResponseBody
    public CommonGridResult individualWorkload(StatisticsVO statisticsVO){
        PageHelper.startPage(statisticsVO.getPageNum(),statisticsVO.getPageSize());
        List<TGrgzltj> list = countService.individualWorkload(statisticsVO);
        //Page page = (Page) list;
        //CommonGridResult commonGridResult = new CommonGridResult(statisticsVO.getPageNum(), statisticsVO.getPageSize(), page.getTotal(), list);
        CommonGridResult commonGridResult = new CommonGridResult(0, 0, (long) list.size(), list);
        return  commonGridResult;
    }



    @ApiOperation("查询项目选择框(区分已完成和进行中)")
    @ApiOperationSupport(order = 31)
    @GetMapping("/batchYieldProject")
    public List<Object> batchYieldProject(){
        return countService.batchYieldProject();
    }

    @ApiOperation("批次产量统计")
    @ApiOperationSupport(order = 32)
    @GetMapping("/batchYieldStatistics")
    @ResponseBody
    public CommonGridResult batchYieldStatistics(StatisticsVO statisticsVO){
        List<CountVO> countList = countService.batchYieldStatistics(statisticsVO);
        CommonGridResult commonGridResult = new CommonGridResult(0, 0, (long) countList.size(), countList);
        return commonGridResult;
    }



    @ApiOperation("加工进度统计")
    @ApiOperationSupport(order = 41)
    @GetMapping("/processProgressStatistics")
    @ResponseBody
    public CommonGridResult processProgressStatistics(StatisticsVO statisticsVO){
        List<CountVO> countList = countService.processProgressStatistics(statisticsVO);
        CommonGridResult commonGridResult = new CommonGridResult(0, 0, (long) countList.size(), countList);
        return commonGridResult;
    }



}
