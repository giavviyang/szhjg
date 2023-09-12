package com.fudian.szhjg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fudian.szhjg.pojo.TMapperOption;
import com.fudian.szhjg.pojo.TMapperOptionExample;

import java.util.List;

public interface TMapperOptionService extends IService<TMapperOption> {


    long countByExample(TMapperOptionExample example);

    int deleteByExample(TMapperOptionExample example);

    List<TMapperOption> selectByExample(TMapperOptionExample example);

    int updateByExampleSelective(TMapperOption record,TMapperOptionExample example);

    int updateByExample(TMapperOption record,TMapperOptionExample example);

}
