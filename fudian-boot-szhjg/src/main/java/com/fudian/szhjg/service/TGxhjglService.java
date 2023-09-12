package com.fudian.szhjg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fudian.szhjg.pojo.TGxhjgl;
import com.fudian.szhjg.pojo.TGxhjglExample;

import java.util.List;

public interface TGxhjglService extends IService<TGxhjgl> {


    long countByExample(TGxhjglExample example);

    int deleteByExample(TGxhjglExample example);

    List<TGxhjgl> selectByExample(TGxhjglExample example);

    int updateByExampleSelective(TGxhjgl record,TGxhjglExample example);

    int updateByExample(TGxhjgl record,TGxhjglExample example);

}
