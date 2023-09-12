package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TChoujian;
import com.fudian.szhjg.pojo.TChoujianExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TChoujianMapper extends BaseMapper<TChoujian> {
    long countByExample(TChoujianExample example);

    int deleteByExample(TChoujianExample example);

    List<TChoujian> selectByExampleWithBLOBs(TChoujianExample example);

    List<TChoujian> selectByExample(TChoujianExample example);

    int updateByExampleSelective(@Param("record") TChoujian record, @Param("example") TChoujianExample example);

    int updateByExampleWithBLOBs(@Param("record") TChoujian record, @Param("example") TChoujianExample example);

    int updateByExample(@Param("record") TChoujian record, @Param("example") TChoujianExample example);
}