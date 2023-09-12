package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TMapper;
import com.fudian.szhjg.pojo.TMapperExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;

@Mapper
public interface TMapperMapper extends BaseMapper<TMapper> {
    long countByExample(TMapperExample example);

    int deleteByExample(TMapperExample example);

    List<TMapper> selectByExample(TMapperExample example);

    int updateByExampleSelective(@Param("record") TMapper record, @Param("example") TMapperExample example);

    int updateByExample(@Param("record") TMapper record, @Param("example") TMapperExample example);



    /** 查询所有案卷
     * @param 封装流式处理
     * @return
     */
    @MapKey(value = "id")
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 1)
    @ResultType(java.util.Map.class)
    void mybatisStreamQueryBybatch(ResultHandler<Map<String, String>> handler,@Param("batchId") String batchId);
}
