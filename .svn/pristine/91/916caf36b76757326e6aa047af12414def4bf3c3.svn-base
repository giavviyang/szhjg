package com.fudian.szhjg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fudian.szhjg.mapper.TMapperDalxMapper;
import com.fudian.szhjg.pojo.TMapperDalx;
import com.fudian.szhjg.pojo.TMapperDalxExample;
import com.fudian.szhjg.service.TMapperDalxService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TMapperDalxServiceImpl extends ServiceImpl<TMapperDalxMapper, TMapperDalx> implements TMapperDalxService {

    @Override
    public long countByExample(TMapperDalxExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TMapperDalxExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TMapperDalx> selectByExample(TMapperDalxExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TMapperDalx record,TMapperDalxExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExample(TMapperDalx record,TMapperDalxExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
