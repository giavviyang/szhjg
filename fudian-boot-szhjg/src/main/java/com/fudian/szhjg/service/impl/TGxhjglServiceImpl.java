package com.fudian.szhjg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fudian.szhjg.mapper.TGxhjglMapper;
import com.fudian.szhjg.pojo.TGxhjgl;
import com.fudian.szhjg.pojo.TGxhjglExample;
import com.fudian.szhjg.service.TGxhjglService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TGxhjglServiceImpl extends ServiceImpl<TGxhjglMapper, TGxhjgl> implements TGxhjglService {

    @Override
    public long countByExample(TGxhjglExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TGxhjglExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TGxhjgl> selectByExample(TGxhjglExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TGxhjgl record,TGxhjglExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExample(TGxhjgl record,TGxhjglExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
