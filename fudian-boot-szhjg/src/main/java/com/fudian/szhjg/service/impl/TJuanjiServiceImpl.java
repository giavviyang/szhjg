package com.fudian.szhjg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.pojo.TJuanji;
import com.fudian.szhjg.pojo.TJuanjiExample;
import com.fudian.szhjg.service.TJuanjiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TJuanjiServiceImpl extends ServiceImpl<TJuanjiMapper, TJuanji> implements TJuanjiService {

    @Override
    public long countByExample(TJuanjiExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TJuanjiExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TJuanji> selectByExample(TJuanjiExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TJuanji record,TJuanjiExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExample(TJuanji record,TJuanjiExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
