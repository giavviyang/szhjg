package com.fudian.szhjg.service;

import java.util.List;
import com.fudian.szhjg.pojo.TTaskJuanExample;
import com.fudian.szhjg.pojo.TTaskJuan;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TTaskJuanService extends IService<TTaskJuan>{


    long countByExample(TTaskJuanExample example);

    int deleteByExample(TTaskJuanExample example);

    List<TTaskJuan> selectByExampleWithBLOBs(TTaskJuanExample example);

    List<TTaskJuan> selectByExample(TTaskJuanExample example);

    int updateByExampleSelective(TTaskJuan record,TTaskJuanExample example);

    int updateByExampleWithBLOBs(TTaskJuan record,TTaskJuanExample example);

    int updateByExample(TTaskJuan record,TTaskJuanExample example);

}
