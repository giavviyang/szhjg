package com.fudian.szhjg.service;

import java.util.List;
import com.fudian.szhjg.pojo.TTaskPiece;
import com.fudian.szhjg.pojo.TTaskPieceExample;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TTaskPieceService extends IService<TTaskPiece>{


    long countByExample(TTaskPieceExample example);

    int deleteByExample(TTaskPieceExample example);

    List<TTaskPiece> selectByExampleWithBLOBs(TTaskPieceExample example);

    List<TTaskPiece> selectByExample(TTaskPieceExample example);

    int updateByExampleSelective(TTaskPiece record,TTaskPieceExample example);

    int updateByExampleWithBLOBs(TTaskPiece record,TTaskPieceExample example);

    int updateByExample(TTaskPiece record,TTaskPieceExample example);

}
