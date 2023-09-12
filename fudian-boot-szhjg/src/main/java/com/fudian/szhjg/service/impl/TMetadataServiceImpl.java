package com.fudian.szhjg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fudian.szhjg.mapper.TMetadataMapper;
import com.fudian.szhjg.pojo.TMetadata;
import com.fudian.szhjg.pojo.TMetadataExample;
import com.fudian.szhjg.service.TMetadataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TMetadataServiceImpl extends ServiceImpl<TMetadataMapper, TMetadata> implements TMetadataService {

    @Override
    public long countByExample(TMetadataExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TMetadataExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TMetadata> selectByExample(TMetadataExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TMetadata record,TMetadataExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExample(TMetadata record,TMetadataExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
