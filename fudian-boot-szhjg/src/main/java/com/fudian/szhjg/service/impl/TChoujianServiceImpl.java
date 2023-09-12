package com.fudian.szhjg.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.fudian.szhjg.pojo.TChoujianExample;
import com.fudian.szhjg.mapper.TChoujianMapper;
import com.fudian.szhjg.pojo.TChoujian;
import com.fudian.szhjg.service.TChoujianService;
@Service
public class TChoujianServiceImpl extends ServiceImpl<TChoujianMapper, TChoujian> implements TChoujianService{

    @Override
    public long countByExample(TChoujianExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TChoujianExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TChoujian> selectByExampleWithBLOBs(TChoujianExample example) {
        return baseMapper.selectByExampleWithBLOBs(example);
    }
    @Override
    public List<TChoujian> selectByExample(TChoujianExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TChoujian record,TChoujianExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExampleWithBLOBs(TChoujian record,TChoujianExample example) {
        return baseMapper.updateByExampleWithBLOBs(record,example);
    }
    @Override
    public int updateByExample(TChoujian record,TChoujianExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
