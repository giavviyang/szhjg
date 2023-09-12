package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TGxhjgl;
import com.fudian.szhjg.pojo.TGxhjglExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TGxhjglMapper extends BaseMapper<TGxhjgl> {
    long countByExample(TGxhjglExample example);

    int deleteByExample(TGxhjglExample example);

    List<TGxhjgl> selectByExample(TGxhjglExample example);

    int updateByExampleSelective(@Param("record") TGxhjgl record, @Param("example") TGxhjglExample example);

    int updateByExample(@Param("record") TGxhjgl record, @Param("example") TGxhjglExample example);
}