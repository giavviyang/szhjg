package com.fudian.szhjg.busiservice;

import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.pojo.TChoujianTask;

import java.util.List;
import java.util.Map;

public interface CheckService {

    //抽检查询案卷信息列表
    CommonGridResult queryRandomCase(TChoujianTask choujianTask);

    //完成抽检
    CommonResult completeSpotCheck(String id);

    //一键完成
    CommonResult completeClickList(String pcId);

    //历史抽检回退
    CommonResult spotCheckRollback(String id);

    //抽检页面查询抽检人
    List<Map<String, String>> querySamplingPeople();
    //抽检历史记录中查询抽检时间
    List<Map<String, String>> querySamplingTime();

}
