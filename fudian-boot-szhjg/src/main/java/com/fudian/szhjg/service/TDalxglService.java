package com.fudian.szhjg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fudian.szhjg.pojo.TDalxgl;
import com.fudian.szhjg.pojo.TDalxglExample;

import java.util.List;

public interface TDalxglService extends IService<TDalxgl> {


    long countByExample(TDalxglExample example);

    int deleteByExample(TDalxglExample example);

    List<TDalxgl> selectByExample(TDalxglExample example);

    int updateByExampleSelective(TDalxgl record,TDalxglExample example);

    int updateByExample(TDalxgl record,TDalxglExample example);

}
