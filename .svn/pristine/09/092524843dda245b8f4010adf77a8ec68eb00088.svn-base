package com.fudian.szhjg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fudian.szhjg.mapper.TDalxglMapper;
import com.fudian.szhjg.pojo.TDalxgl;
import com.fudian.szhjg.pojo.TDalxglExample;
import com.fudian.szhjg.service.TDalxglService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDalxglServiceImpl extends ServiceImpl<TDalxglMapper, TDalxgl> implements TDalxglService {

    @Override
    public long countByExample(TDalxglExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TDalxglExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TDalxgl> selectByExample(TDalxglExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TDalxgl record,TDalxglExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExample(TDalxgl record,TDalxglExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
