package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TChoujianTask;
import com.fudian.szhjg.pojo.TChoujianTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TChoujianTaskMapper extends BaseMapper<TChoujianTask> {
    long countByExample(TChoujianTaskExample example);

    int deleteByExample(TChoujianTaskExample example);

    List<TChoujianTask> selectByExampleWithBLOBs(TChoujianTaskExample example);

    List<TChoujianTask> selectByExample(TChoujianTaskExample example);

    int updateByExampleSelective(@Param("record") TChoujianTask record, @Param("example") TChoujianTaskExample example);

    int updateByExampleWithBLOBs(@Param("record") TChoujianTask record, @Param("example") TChoujianTaskExample example);

    int updateByExample(@Param("record") TChoujianTask record, @Param("example") TChoujianTaskExample example);
}