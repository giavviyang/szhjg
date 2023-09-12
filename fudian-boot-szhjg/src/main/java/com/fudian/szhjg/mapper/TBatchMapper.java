package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TBatch;
import com.fudian.szhjg.pojo.TBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TBatchMapper extends BaseMapper<TBatch> {
    long countByExample(TBatchExample example);

    int deleteByExample(TBatchExample example);

    List<TBatch> selectByExample(TBatchExample example);

    int updateByExampleSelective(@Param("record") TBatch record, @Param("example") TBatchExample example);

    int updateByExample(@Param("record") TBatch record, @Param("example") TBatchExample example);
}