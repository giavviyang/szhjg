package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TJianji;
import com.fudian.szhjg.pojo.TJianjiExample;
import com.fudian.szhjg.pojo.vo.JuanjiVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TJianjiMapper extends BaseMapper<TJianji> {
    long countByExample(TJianjiExample example);

    int deleteByExample(TJianjiExample example);

    List<TJianji> selectByExample(TJianjiExample example);

    int updateByExampleSelective(@Param("record") TJianji record, @Param("example") TJianjiExample example);

    int updateByExample(@Param("record") TJianji record, @Param("example") TJianjiExample example);

    //批量插入
    int insertPiece(List<TJianji> listJi);

    //自定义修改合件信息
    boolean updateCustomize(String id);

    int bulkAdditions(JuanjiVO juanjiVO);
}
