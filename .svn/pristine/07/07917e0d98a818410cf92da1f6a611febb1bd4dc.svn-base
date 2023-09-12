package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TMetadata;
import com.fudian.szhjg.pojo.TMetadataExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TMetadataMapper extends BaseMapper<TMetadata> {
    long countByExample(TMetadataExample example);

    int deleteByExample(TMetadataExample example);

    List<TMetadata> selectByExample(TMetadataExample example);

    int updateByExampleSelective(@Param("record") TMetadata record, @Param("example") TMetadataExample example);

    int updateByExample(@Param("record") TMetadata record, @Param("example") TMetadataExample example);
}