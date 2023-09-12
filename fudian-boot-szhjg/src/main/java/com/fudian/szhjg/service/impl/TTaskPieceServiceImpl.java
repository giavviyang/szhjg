package com.fudian.szhjg.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.fudian.szhjg.mapper.TTaskPieceMapper;
import com.fudian.szhjg.pojo.TTaskPiece;
import com.fudian.szhjg.pojo.TTaskPieceExample;
import com.fudian.szhjg.service.TTaskPieceService;
@Service
public class TTaskPieceServiceImpl extends ServiceImpl<TTaskPieceMapper, TTaskPiece> implements TTaskPieceService{

    @Override
    public long countByExample(TTaskPieceExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TTaskPieceExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TTaskPiece> selectByExampleWithBLOBs(TTaskPieceExample example) {
        return baseMapper.selectByExampleWithBLOBs(example);
    }
    @Override
    public List<TTaskPiece> selectByExample(TTaskPieceExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TTaskPiece record,TTaskPieceExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExampleWithBLOBs(TTaskPiece record,TTaskPieceExample example) {
        return baseMapper.updateByExampleWithBLOBs(record,example);
    }
    @Override
    public int updateByExample(TTaskPiece record,TTaskPieceExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
