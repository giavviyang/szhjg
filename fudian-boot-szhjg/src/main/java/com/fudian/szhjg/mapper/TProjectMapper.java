package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TProject;
import com.fudian.szhjg.pojo.TProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TProjectMapper extends BaseMapper<TProject> {
    long countByExample(TProjectExample example);

    int deleteByExample(TProjectExample example);

    List<TProject> selectByExample(TProjectExample example);

    int updateByExampleSelective(@Param("record") TProject record, @Param("example") TProjectExample example);

    int updateByExample(@Param("record") TProject record, @Param("example") TProjectExample example);
}