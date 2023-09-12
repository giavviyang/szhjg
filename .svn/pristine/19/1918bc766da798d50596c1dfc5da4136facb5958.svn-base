package com.fudian.szhjg.busiservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.szhjg.busiservice.RwglService;
import com.fudian.szhjg.mapper.TChoujianTaskMapper;
import com.fudian.szhjg.mapper.TJianjiMapper;
import com.fudian.szhjg.pojo.*;
import com.fudian.szhjg.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RwglServiceImpl implements RwglService {

    @Autowired
    private TBatchService tBatchService;
    @Autowired
    private TProjectGxhjService tProjectGxhjService;

    @Autowired
    private TJuanjiService tJuanjiService;

    @Autowired
    private TJianjiService tJianjiService;
    @Autowired
    private TJianjiMapper tJianjiMapper;

    @Autowired
    private TChoujianTaskService choujianTaskService;
    @Autowired
    private TChoujianTaskMapper choujianTaskMapper;


    //查询项目中的工序
    @Override
    public List<Object> queryWorking(String cxId, String type) {
        List<Object> listMap = new ArrayList<>();
        //存放项目id
        String xmId = "";
        //判断类型是批次id(P),还是案卷id(A)
        if ("P".equals(type)){
            xmId = Pxm(cxId);
        }
        if ("A".equals(type)){
            xmId = Axm(cxId);
        }
        LambdaQueryWrapper<TProjectGxhj> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TProjectGxhj::getProjectId,xmId);
        wrapper.orderByAsc(TProjectGxhj::getGxxh);
        List<TProjectGxhj> list = tProjectGxhjService.list(wrapper);
        for (TProjectGxhj t :list){
            Map<String, Object> map = new HashMap<>();
            map.put("label" , t.getGxmc());
            map.put("value" , t.getGxxh());
            listMap.add(map);
        }
        return listMap;
    }
    //获取批次的项目id
    private String Pxm(String cxId) {
        LambdaQueryWrapper<TBatch> wrapper= new LambdaQueryWrapper<>();
        wrapper.eq(TBatch::getId,cxId);
        List<TBatch> list = tBatchService.list(wrapper);
        TBatch tBatch = new TBatch();
        if (list.size()>0){
            tBatch = list.get(0);
        }
        return tBatch.getProjectId();
    }
    //获取案卷的项目id
    private String Axm(String cxId) {
        LambdaQueryWrapper<TJuanji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJuanji::getId,cxId);
        List<TJuanji> list = tJuanjiService.list(wrapper);
        TJuanji taskJuan= new TJuanji();
        if (list.size()>0){
            taskJuan = list.get(0);
        }
        LambdaQueryWrapper<TBatch> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(TBatch::getId,taskJuan.getPcId());
        List<TBatch> list1 = tBatchService.list(wrapper1);
        TBatch tBatch = new TBatch();
        if (list1.size()>0){
            tBatch = list1.get(0);
        }
        return tBatch.getProjectId();
    }


    //释放当前案卷绑定用户(领取人)
    @Override
    public CommonResult releaseRecipient(String nameId) {
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();  // 获取当前的用户
        LambdaQueryWrapper<TJuanji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJuanji::getId,nameId);
        List<TJuanji> list = tJuanjiService.list(wrapper);
        TJuanji taskJuan = new TJuanji();
        if ( list.size()>0 ){
            taskJuan = list.get(0);
        }
        taskJuan.setLqr("");
        taskJuan.setRwzt("未进行");
        if ("著录中".equals(taskJuan.getCataloged())){
            taskJuan.setCataloged("未著录");
        }
        boolean b = tJuanjiService.updateById(taskJuan);
        if (b) {
            return new CommonResult(200,"用户绑定成功");
        } else {
            return new CommonResult(500,"用户绑定失败");
        }
    }


    //删除案卷关联表信息
    @Override
    public CommonResult deleteCorrelationTable(String id) {
        //抽检任务生成表
        LambdaQueryWrapper<TChoujianTask> chouWrapper = new LambdaQueryWrapper<>();
        chouWrapper.eq(TChoujianTask::getAjId,id);
        Integer a1 = choujianTaskMapper.selectCount(chouWrapper);
        if ( a1>0 ){
            int a2 = choujianTaskMapper.delete(chouWrapper);
            if ( a2<=0 ){
                return new CommonResult(500,"删除失败");
            }
        }
        //案件表
        LambdaQueryWrapper<TJianji> pieceWrapper = new LambdaQueryWrapper<>();
        pieceWrapper.eq(TJianji::getAjId,id);
        Integer b1 = tJianjiMapper.selectCount(pieceWrapper);
        if ( b1>0 ){
            //删除图像
            List<TJianji> list = tJianjiService.list(pieceWrapper);
            //从list集合中，取出图片地址
            List<String> tpList = list.stream().map(p -> p.getTpdz()).collect(Collectors.toList());
            for (String tp :tpList){
                if (StringUtils.isNotBlank(tp)){
                    File fileOriginal = new File(tp);   //创建文件对象
                    //判断图片是否存在
                    if ( fileOriginal.exists() ) {
                        Boolean flag = fileOriginal.delete();  //删除文件
                        if( !flag ){
                            return CommonResult.error("图片删除失败");
                        }
                    }
                }
            }
            //删除案件信息
            int b2 = tJianjiMapper.delete(pieceWrapper);
            if ( b2<=0 ){
                return new CommonResult(500,"删除失败");
            }

        }
        return new CommonResult(666,"关联表删除成功");
    }


    //默认删除数据(后台方法[开发测试专用])
    @Override
    public CommonResult defaultDeleteData() {
        //查询批次
        List<TBatch> batchList = tBatchService.list();
        //过滤当前的批次id
        List<String> batchId = batchList.stream().map(TBatch::getId).collect(Collectors.toList());
        //查询案卷信息
        LambdaQueryWrapper<TJuanji> wrapperJu = new LambdaQueryWrapper<>();
        wrapperJu.notIn(TJuanji::getPcId, batchId);
        List<TJuanji> juList = tJuanjiService.list(wrapperJu);
        //过滤当前的批次id
        List<String> juId = juList.stream().map(TJuanji::getId).collect(Collectors.toList());
        //查询案件信息
        List<TJianji> jiList = new ArrayList<>();
        if (juId.size()>0){
            LambdaQueryWrapper<TJianji> jiWrapper = new LambdaQueryWrapper<>();
            jiWrapper.in(TJianji::getAjId, juId);
            jiList = tJianjiService.list(jiWrapper);
        }
        //返回信息
        Map<Object,Object> map = new HashMap<>();
        String str = "删除批次剩余案卷数量:"+ juList.size() + "; 删除案卷剩余案件数量:" + jiList.size();
        map.put("数量: ",str);
        map.put("案卷数据id: ",juId);
        return  CommonResult.success(map);
    }

}
