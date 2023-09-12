package com.fudian.szhjg.busiservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.busiservice.CheckService;
import com.fudian.szhjg.mapper.*;
import com.fudian.szhjg.pojo.*;
import com.fudian.szhjg.service.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private TJuanjiMapper tJuanjiMapper;
    @Autowired
    private TJuanjiService tJuanjiService;

    @Autowired
    private TJianjiMapper tJianjiMapper;
    @Autowired
    private TJianjiService tJianjiService;


    @Autowired
    private TChoujianTaskService choujianTaskService;
    @Autowired
    private TChoujianTaskMapper choujianTaskMapper;



    //抽检查询案卷信息列表
    @Override
    public CommonGridResult queryRandomCase(TChoujianTask choujianTask) {
        CommonGridResult commonGridResult = new CommonGridResult();
        LambdaQueryWrapper<TChoujianTask> chouWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(choujianTask.getPcId())){
            chouWrapper.eq(TChoujianTask::getPcId,choujianTask.getPcId());
        }
        if (StringUtils.isNotBlank(choujianTask.getCjrNx())){
            chouWrapper.eq(TChoujianTask::getCjrNx,choujianTask.getCjrNx());
        }
        if (StringUtils.isNotBlank(choujianTask.getBh())){
            chouWrapper.like(TChoujianTask::getBh,choujianTask.getBh());
        }
        //查询状态 0--未完成;  1--已完成
        chouWrapper.eq(TChoujianTask::getTaskFlag,choujianTask.getTaskFlag());
        chouWrapper.orderByDesc(TChoujianTask::getClaimTime);
        ////当前查询出来的为用户领取的任务未完成的
        PageHelper.startPage(choujianTask.getPageNum(), choujianTask.getPageSize());
        Page<TChoujianTask> pages = (Page<TChoujianTask>) choujianTaskMapper.selectList(chouWrapper);
        List<TChoujianTask> chouList = pages.getResult();

        //过滤当前的案卷id
        List<String> aId = chouList.stream().map(TChoujianTask::getAjId).collect(Collectors.toList());
        if ( !(aId.size()>0)) {
            commonGridResult.setTotal(0L);
            commonGridResult.setRows(new ArrayList<>());
            return commonGridResult;
        }
        LambdaQueryWrapper<TJuanji> juanWrapper = new LambdaQueryWrapper<>();
        juanWrapper.in(TJuanji::getId, aId);
        juanWrapper.orderByAsc(TJuanji::getDalx);
        List<TJuanji> juanList = tJuanjiMapper.selectList(juanWrapper);

        juanList.forEach(juan -> {
            LambdaQueryWrapper<TJianji> pieceWrapper = new LambdaQueryWrapper<>();
            pieceWrapper.eq(TJianji::getAjId, juan.getId()).eq(TJianji::getSfsy, "是");
            Integer integer = tJianjiMapper.selectCount(pieceWrapper);
            juan.setFileCount(integer);
        });

        commonGridResult.setRows(juanList);
        commonGridResult.setTotal((long) pages.getTotal());
        return commonGridResult;
    }


    //完成抽检
    @Override
    public CommonResult completeSpotCheck(String id) {
        CommonResult commonResult = new CommonResult();
        LambdaQueryWrapper<TChoujianTask> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TChoujianTask::getAjId,id);
        List<TChoujianTask> list = choujianTaskService.list(wrapper);
        TChoujianTask choujianTask = new TChoujianTask();
        if ( list.size()>0 ){
            choujianTask = list.get(0);
        }
        choujianTask.setFinishTime(new Date());
        choujianTask.setTaskFlag("1");
        boolean b = choujianTaskService.updateById(choujianTask);
        if ( b ){
            commonResult.setCode(200);
            commonResult.setMsg("当前案卷抽检完成");
        }else {
            commonResult.setCode(500);
            commonResult.setMsg("系统异常，请联系管理员");
        }
        return commonResult;
    }


    //一键完成
    @Override
    public CommonResult completeClickList(String pcId) {
        CommonResult commonResult = new CommonResult();
        LambdaQueryWrapper<TChoujianTask> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TChoujianTask::getPcId,pcId).eq(TChoujianTask::getTaskFlag,"0");
        List<TChoujianTask> list = choujianTaskService.list(wrapper);
        Date date = new Date();
        for (TChoujianTask choujianTask : list){
            choujianTask.setFinishTime(date);
            choujianTask.setTaskFlag("1");
        }
        boolean b = choujianTaskService.updateBatchById(list);
        if ( b ){
            commonResult.setCode(200);
            commonResult.setMsg("案卷抽检一键完成成功");
        }else {
            commonResult.setCode(500);
            commonResult.setMsg("系统异常，请联系管理员");
        }
        return commonResult;
    }


    //历史抽检回退
    @Override
    public CommonResult spotCheckRollback(String id) {
        CommonResult commonResult = new CommonResult();
        LambdaQueryWrapper<TChoujianTask> chouWrapper = new LambdaQueryWrapper<>();
        chouWrapper.eq(TChoujianTask::getAjId,id);
        List<TChoujianTask> list = choujianTaskService.list(chouWrapper);
        TChoujianTask choujianTask = new TChoujianTask();
        if ( list.size()>0 ){
            choujianTask = list.get(0);
        }
        choujianTask.setFinishTime(new Date());
        choujianTask.setTaskFlag("0");
        boolean b = choujianTaskService.updateById(choujianTask);
        if ( b ){
            commonResult.setCode(200);
            commonResult.setMsg("回退成功");
        }else {
            commonResult.setCode(500);
            commonResult.setMsg("系统异常，请联系管理员");
        }
        return commonResult;
    }


    //抽检页面查询抽检人
    @Override
    public List<Map<String, String>> querySamplingPeople() {
        List<Map<String, String>> listMap = new ArrayList<>();
        LambdaQueryWrapper<TChoujianTask> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TChoujianTask::getTaskFlag,"0");
        List<TChoujianTask> list = choujianTaskService.list(wrapper);
        if ( list.size()>0 ){
            for (TChoujianTask task : list){
                Map<String, String> map = new HashMap<>();
                map.put("label", task.getCjrNx());
                map.put("value", task.getAjId());
                listMap.add(map);
            }
        }
        return listMap;
    }

    //抽检历史记录中查询抽检时间
    @Override
    public List<Map<String, String>> querySamplingTime() {
        List<Map<String, String>> listMap = new ArrayList<>();
        LambdaQueryWrapper<TChoujianTask> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TChoujianTask::getTaskFlag,"1");
        List<TChoujianTask> list = choujianTaskService.list(wrapper);
        if ( list.size()>0 ){
            for (TChoujianTask chouTask : list ){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeFormat1 = sdf.format(chouTask.getClaimTime());
                String timeFormat2 = sdf.format(chouTask.getFinishTime());

                Map<String, String> map = new HashMap<>();
                map.put("label1", timeFormat1);
                map.put("label2", timeFormat2);
                map.put("value" , chouTask.getAjId());
                listMap.add(map);
            }
        }
        return listMap;
    }

}
