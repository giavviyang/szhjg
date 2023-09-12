package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TTaskJuan;
import com.fudian.szhjg.pojo.TTaskJuanExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TTaskJuanMapper extends BaseMapper<TTaskJuan> {
    long countByExample(TTaskJuanExample example);

    int deleteByExample(TTaskJuanExample example);

    List<TTaskJuan> selectByExampleWithBLOBs(TTaskJuanExample example);

    List<TTaskJuan> selectByExample(TTaskJuanExample example);

    int updateByExampleSelective(@Param("record") TTaskJuan record, @Param("example") TTaskJuanExample example);

    int updateByExampleWithBLOBs(@Param("record") TTaskJuan record, @Param("example") TTaskJuanExample example);

    int updateByExample(@Param("record") TTaskJuan record, @Param("example") TTaskJuanExample example);


    //根据批次id获取其下案卷总数
    int getLengthTask(@Param("pcId") String pcId, @Param("qzh") String qzh, @Param("mlh") String mlh,
                      @Param("ajh2") String ajh2, @Param("ajh3") String ajh3);

    //抽检-随机抽取案卷
    List<TTaskJuan> randomExtraData(@Param("num") int num, @Param("pcId") String pcId, @Param("qzh") String qzh,
                                    @Param("mlh") String mlh, @Param("ajh2") String ajh2, @Param("ajh3") String ajh3,
                                    @Param("ajIds") List<String> ajIds);

}