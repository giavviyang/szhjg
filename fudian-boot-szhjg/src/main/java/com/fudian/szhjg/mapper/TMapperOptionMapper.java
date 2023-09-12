package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TMapperOption;
import com.fudian.szhjg.pojo.TMapperOptionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TMapperOptionMapper extends BaseMapper<TMapperOption> {
    long countByExample(TMapperOptionExample example);

    int deleteByExample(TMapperOptionExample example);

    List<TMapperOption> selectByExample(TMapperOptionExample example);

    int updateByExampleSelective(@Param("record") TMapperOption record, @Param("example") TMapperOptionExample example);

    int updateByExample(@Param("record") TMapperOption record, @Param("example") TMapperOptionExample example);
}