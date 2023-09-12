package com.fudian.szhjg.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fudian.szhjg.mapper.TTaskJuanMapper;
import java.util.List;
import com.fudian.szhjg.pojo.TTaskJuanExample;
import com.fudian.szhjg.pojo.TTaskJuan;
import com.fudian.szhjg.service.TTaskJuanService;
@Service
public class TTaskJuanServiceImpl extends ServiceImpl<TTaskJuanMapper, TTaskJuan> implements TTaskJuanService{

    @Override
    public long countByExample(TTaskJuanExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TTaskJuanExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TTaskJuan> selectByExampleWithBLOBs(TTaskJuanExample example) {
        return baseMapper.selectByExampleWithBLOBs(example);
    }
    @Override
    public List<TTaskJuan> selectByExample(TTaskJuanExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TTaskJuan record,TTaskJuanExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExampleWithBLOBs(TTaskJuan record,TTaskJuanExample example) {
        return baseMapper.updateByExampleWithBLOBs(record,example);
    }
    @Override
    public int updateByExample(TTaskJuan record,TTaskJuanExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
