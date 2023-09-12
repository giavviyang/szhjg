package com.fudian.szhjg.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.fudian.szhjg.pojo.TProjectExample;
import com.fudian.szhjg.pojo.TProject;
import com.fudian.szhjg.mapper.TProjectMapper;
import com.fudian.szhjg.service.TProjectService;
@Service
public class TProjectServiceImpl extends ServiceImpl<TProjectMapper, TProject> implements TProjectService{

    @Override
    public long countByExample(TProjectExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(TProjectExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<TProject> selectByExample(TProjectExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(TProject record,TProjectExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExample(TProject record,TProjectExample example) {
        return baseMapper.updateByExample(record,example);
    }
}
