package com.fudian.szhjg.busiservice;

import com.fudian.common.pojo.CommonResult;

import java.util.List;

public interface ProjectManagementService {

    //新增插入项目工序关联表
    CommonResult insertProcedure(String[] ids, String uuid);

    //编辑项目工序关联表数据
    CommonResult updateProcedure(String[] ids, String id);

    //项目重名查询
    String queryDuplicate(String type, String projectName, String id);


    //查询项目下是否有批次
    String queryProjectData(String id);

    //完成项目
    CommonResult completeProject(String id);

}
