package com.fudian.szhjg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fudian.szhjg.pojo.TTaskPiece;
import com.fudian.szhjg.pojo.TTaskPieceExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TTaskPieceMapper extends BaseMapper<TTaskPiece> {
    long countByExample(TTaskPieceExample example);

    int deleteByExample(TTaskPieceExample example);

    List<TTaskPiece> selectByExampleWithBLOBs(TTaskPieceExample example);

    List<TTaskPiece> selectByExample(TTaskPieceExample example);

    int updateByExampleSelective(@Param("record") TTaskPiece record, @Param("example") TTaskPieceExample example);

    int updateByExampleWithBLOBs(@Param("record") TTaskPiece record, @Param("example") TTaskPieceExample example);

    int updateByExample(@Param("record") TTaskPiece record, @Param("example") TTaskPieceExample example);

    //批量插入
    int insertPiece(@Param("list")List<TTaskPiece> list);
}