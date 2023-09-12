package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TDalxgl;
import com.fudian.szhjg.pojo.TDalxglExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TDalxglMapper extends BaseMapper<TDalxgl> {
    long countByExample(TDalxglExample example);

    int deleteByExample(TDalxglExample example);

    List<TDalxgl> selectByExample(TDalxglExample example);

    int updateByExampleSelective(@Param("record") TDalxgl record, @Param("example") TDalxglExample example);

    int updateByExample(@Param("record") TDalxgl record, @Param("example") TDalxglExample example);
}