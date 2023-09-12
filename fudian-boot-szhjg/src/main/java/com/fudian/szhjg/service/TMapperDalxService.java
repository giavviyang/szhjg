package com.fudian.szhjg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fudian.szhjg.pojo.TMapperDalx;
import com.fudian.szhjg.pojo.TMapperDalxExample;

import java.util.List;

public interface TMapperDalxService extends IService<TMapperDalx> {


    long countByExample(TMapperDalxExample example);

    int deleteByExample(TMapperDalxExample example);

    List<TMapperDalx> selectByExample(TMapperDalxExample example);

    int updateByExampleSelective(TMapperDalx record,TMapperDalxExample example);

    int updateByExample(TMapperDalx record,TMapperDalxExample example);

}
