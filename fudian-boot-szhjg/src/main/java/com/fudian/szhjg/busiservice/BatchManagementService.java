package com.fudian.szhjg.busiservice;

import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.pojo.TBatch;
import com.fudian.szhjg.pojo.TProject;
import com.fudian.szhjg.pojo.TTaskJuan;

import java.util.List;

public interface BatchManagementService {

    //查询进行中项目名称
    List<Object> queryProjectName();

    //查询进行中项目id
    List<String> ProjectLists();

    //查询批次下是否有案卷
    String queryBatchData(String id);

    //完成批次
    CommonResult completeBatch(String id);

    //根据id查询项目信息
    String getProjectOne(String projectId);


    //导出完成数据包
    CommonResult<?> exportCompletedInformation(TBatch batch);

    CommonResult getzipInformation(String id);

}
