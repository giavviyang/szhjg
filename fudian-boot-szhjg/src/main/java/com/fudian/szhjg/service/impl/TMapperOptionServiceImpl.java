package com.fudian.szhjg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fudian.szhjg.mapper.TMapperOptionMapper;
import com.fudian.szhjg.pojo.TMapperOption;
import com.fudian.szhjg.pojo.TMapperOptionExample;
import com.fudian.szhjg.service.TMapperOptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TMapperOptionServiceImpl extends ServiceImpl<TMapperOptionMapper, TMapperOption> implements TMapperOptionService {

    @Override
    public long countByExample(TMapperOptionExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TMapperOptionExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TMapperOption> selectByExample(TMapperOptionExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TMapperOption record,TMapperOptionExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExample(TMapperOption record,TMapperOptionExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
