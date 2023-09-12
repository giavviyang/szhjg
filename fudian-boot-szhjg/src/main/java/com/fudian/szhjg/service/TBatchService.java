package com.fudian.szhjg.service;

import java.util.List;
import com.fudian.szhjg.pojo.TBatch;
import com.fudian.szhjg.pojo.TBatchExample;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TBatchService extends IService<TBatch>{


    long countByExample(TBatchExample example);

    int deleteByExample(TBatchExample example);

    List<TBatch> selectByExample(TBatchExample example);

    int updateByExampleSelective(TBatch record,TBatchExample example);

    int updateByExample(TBatch record,TBatchExample example);

}
