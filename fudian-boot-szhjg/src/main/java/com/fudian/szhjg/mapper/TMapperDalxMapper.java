package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TMapperDalx;
import com.fudian.szhjg.pojo.TMapperDalxExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TMapperDalxMapper extends BaseMapper<TMapperDalx> {
    long countByExample(TMapperDalxExample example);

    int deleteByExample(TMapperDalxExample example);

    List<TMapperDalx> selectByExample(TMapperDalxExample example);

    int updateByExampleSelective(@Param("record") TMapperDalx record, @Param("example") TMapperDalxExample example);

    int updateByExample(@Param("record") TMapperDalx record, @Param("example") TMapperDalxExample example);
}