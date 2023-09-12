package com.fudian.szhjg.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.fudian.szhjg.mapper.TBatchMapper;
import com.fudian.szhjg.pojo.TBatch;
import com.fudian.szhjg.pojo.TBatchExample;
import com.fudian.szhjg.service.TBatchService;
@Service
public class TBatchServiceImpl extends ServiceImpl<TBatchMapper, TBatch> implements TBatchService{

    @Override
    public long countByExample(TBatchExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TBatchExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TBatch> selectByExample(TBatchExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TBatch record,TBatchExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExample(TBatch record,TBatchExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
