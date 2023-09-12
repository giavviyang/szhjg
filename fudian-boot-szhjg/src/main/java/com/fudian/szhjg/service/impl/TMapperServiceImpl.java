package com.fudian.szhjg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fudian.szhjg.mapper.TMapperMapper;
import com.fudian.szhjg.pojo.TMapper;
import com.fudian.szhjg.pojo.TMapperExample;
import com.fudian.szhjg.service.TMapperService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TMapperServiceImpl extends ServiceImpl<TMapperMapper, TMapper> implements TMapperService {

    @Override
    public long countByExample(TMapperExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TMapperExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TMapper> selectByExample(TMapperExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TMapper record,TMapperExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExample(TMapper record,TMapperExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
