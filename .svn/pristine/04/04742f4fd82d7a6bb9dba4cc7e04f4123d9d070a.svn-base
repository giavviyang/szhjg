package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TGrgzltj;
import com.fudian.szhjg.pojo.TGrgzltjExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TGrgzltjMapper extends BaseMapper<TGrgzltj> {
    long countByExample(TGrgzltjExample example);

    int deleteByExample(TGrgzltjExample example);

    List<TGrgzltj> selectByExample(TGrgzltjExample example);

    int updateByExampleSelective(@Param("record") TGrgzltj record, @Param("example") TGrgzltjExample example);

    int updateByExample(@Param("record") TGrgzltj record, @Param("example") TGrgzltjExample example);
}