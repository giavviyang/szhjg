package com.fudian.szhjg.busiservice;


import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.pojo.TGrgzltj;
import com.fudian.szhjg.pojo.vo.ReworkVO;

import java.util.List;

public interface CommonApproachService {

    //领取任务-领取选择任务Id(其他工序)
    CommonResult selectFetchTaskIds(String[] ids);
    //领取任务-领取选择任务Id(目录著录专用)
    CommonResult selectRecordTaskIds(String[] ids);


    //通过-查询下一个工序名称
    String queryNextGxName(String id, Integer gxName);
    //通过-数据加工提交方法
    CommonResult processingSubmitPass(String ajId, Integer gxId);
    //通过-目录著录任务提交方法
    CommonResult catalogueSubmitPass(String ajId);


    //返工-查询项目对应的工序
    List<Object> reworkQueryProject(String ajId);
    //返工-提交返工方法
    CommonResult reworkSubmitPass(ReworkVO reworkVO);
    //返工-目录著录任务返工方法
    CommonResult catalogDescriptionRework(ReworkVO reworkVO);


    //查看当前用户记录(查看记录)
    CommonGridResult viewCurrentUserRecord(TGrgzltj tGrgzltj);

    //查询总页数和图片总数
    CommonResult queryPictureTotal(String ajId);

}
