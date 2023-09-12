package com.fudian.szhjg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fudian.szhjg.pojo.TMapper;
import com.fudian.szhjg.pojo.TMapperExample;

import java.util.List;

public interface TMapperService extends IService<TMapper> {


    long countByExample(TMapperExample example);

    int deleteByExample(TMapperExample example);

    List<TMapper> selectByExample(TMapperExample example);

    int updateByExampleSelective(TMapper record,TMapperExample example);

    int updateByExample(TMapper record,TMapperExample example);

}
