package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TProjectGxhj;
import com.fudian.szhjg.pojo.TProjectGxhjExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TProjectGxhjMapper extends BaseMapper<TProjectGxhj> {
    long countByExample(TProjectGxhjExample example);

    int deleteByExample(TProjectGxhjExample example);

    List<TProjectGxhj> selectByExample(TProjectGxhjExample example);

    int updateByExampleSelective(@Param("record") TProjectGxhj record, @Param("example") TProjectGxhjExample example);

    int updateByExample(@Param("record") TProjectGxhj record, @Param("example") TProjectGxhjExample example);
}