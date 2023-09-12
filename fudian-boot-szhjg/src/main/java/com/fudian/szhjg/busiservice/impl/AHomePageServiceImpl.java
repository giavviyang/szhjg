package com.fudian.szhjg.busiservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.szhjg.busiservice.AHomePageService;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.pojo.TJuanji;
import com.fudian.szhjg.pojo.TTaskJuan;
import com.fudian.szhjg.service.TJuanjiService;
import com.fudian.szhjg.service.TTaskJuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AHomePageServiceImpl implements AHomePageService {

    @Autowired
    private TJuanjiMapper tJuanjiMapper;
    @Autowired
    private TJuanjiService tJuanjiService;


    //首页查询任务信息
    @Override
    public CommonResult queryProcessingTask() {
        //创建存放任务信息map
        HashMap<String,Object> map = new HashMap<>();

        //1.查询----全部任务
        LambdaQueryWrapper<TJuanji> wrapper1 = new LambdaQueryWrapper<>();
        int count1 = tJuanjiMapper.selectCount(wrapper1);
        //int count1 = tJuanjiService.count(wrapper1);
        map.put("Tasks",count1);

        //2.查询----全部已完成任务
        LambdaQueryWrapper<TJuanji> wrapper2 = new LambdaQueryWrapper<>();
        wrapper2.eq(TJuanji::getRwzt,"已完成");
        int count2 = tJuanjiMapper.selectCount(wrapper2);
        //int count2 = tJuanjiService.count(wrapper2);
        map.put("complete",count2);

        //3.查询----进行中任务
        //获取当前的用户
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();
        LambdaQueryWrapper<TJuanji> wrapper3 = new LambdaQueryWrapper<>();
        wrapper3.eq(TJuanji::getRwzt,"进行中").eq(TJuanji::getLqr,userName);
        int count3 = tJuanjiMapper.selectCount(wrapper3);
        //int count2 = tJuanjiService.count(wrapper2);
        map.put("carryOn",count3);

        return CommonResult.success(map);
    }
}
