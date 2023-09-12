package com.fudian.szhjg.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fudian.szhjg.pojo.TChoujianTaskExample;
import java.util.List;
import com.fudian.szhjg.pojo.TChoujianTask;
import com.fudian.szhjg.mapper.TChoujianTaskMapper;
import com.fudian.szhjg.service.TChoujianTaskService;
@Service
public class TChoujianTaskServiceImpl extends ServiceImpl<TChoujianTaskMapper, TChoujianTask> implements TChoujianTaskService{

    @Override
    public long countByExample(TChoujianTaskExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TChoujianTaskExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TChoujianTask> selectByExampleWithBLOBs(TChoujianTaskExample example) {
        return baseMapper.selectByExampleWithBLOBs(example);
    }
    @Override
    public List<TChoujianTask> selectByExample(TChoujianTaskExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TChoujianTask record,TChoujianTaskExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExampleWithBLOBs(TChoujianTask record,TChoujianTaskExample example) {
        return baseMapper.updateByExampleWithBLOBs(record,example);
    }
    @Override
    public int updateByExample(TChoujianTask record,TChoujianTaskExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
