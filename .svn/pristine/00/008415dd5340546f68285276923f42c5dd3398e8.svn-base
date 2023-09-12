package com.fudian.szhjg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fudian.szhjg.mapper.TJianjiMapper;
import com.fudian.szhjg.pojo.TJianji;
import com.fudian.szhjg.pojo.TJianjiExample;
import com.fudian.szhjg.service.TJianjiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TJianjiServiceImpl extends ServiceImpl<TJianjiMapper, TJianji> implements TJianjiService {

    @Override
    public long countByExample(TJianjiExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TJianjiExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TJianji> selectByExample(TJianjiExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TJianji record,TJianjiExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExample(TJianji record,TJianjiExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
