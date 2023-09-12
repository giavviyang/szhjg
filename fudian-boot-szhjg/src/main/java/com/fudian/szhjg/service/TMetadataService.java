package com.fudian.szhjg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fudian.szhjg.pojo.TMetadata;
import com.fudian.szhjg.pojo.TMetadataExample;

import java.util.List;

public interface TMetadataService extends IService<TMetadata> {


    long countByExample(TMetadataExample example);

    int deleteByExample(TMetadataExample example);

    List<TMetadata> selectByExample(TMetadataExample example);

    int updateByExampleSelective(TMetadata record,TMetadataExample example);

    int updateByExample(TMetadata record,TMetadataExample example);

}
