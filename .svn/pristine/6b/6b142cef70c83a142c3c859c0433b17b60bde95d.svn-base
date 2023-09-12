package com.fudian.szhjg.busiservice;

import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.pojo.TGrgzltj;
import com.fudian.szhjg.pojo.vo.CountVO;
import com.fudian.szhjg.pojo.vo.StatisticsVO;

import java.util.List;

public interface StatisticsCountService {

    //个人工作统计
    List<TGrgzltj> individualWorkload(StatisticsVO statisticsVO);


    //查询项目选择框(区分已完成/进行中)
    List<Object> batchYieldProject();

    //批次产量统计
    List<CountVO> batchYieldStatistics(StatisticsVO statisticsVO);


    //加工进度统计
    List<CountVO> processProgressStatistics(StatisticsVO statisticsVO);

}
