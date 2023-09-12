package com.fudian.szhjg.busiservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.common.utils.uuid.IdUtils;
import com.fudian.szhjg.busiservice.CommonSzhjgService;
import com.fudian.szhjg.pojo.*;
import com.fudian.szhjg.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommonSzhjgServiceImpl implements CommonSzhjgService {

    @Autowired
    private TProjectService tProjectService;
    @Autowired
    private TBatchService tBatchService;
    @Autowired
    private TGxhjglService tGxhjglService;
    @Autowired
    private TProjectGxhjService tProjectGxhjService;

    @Autowired
    private TJuanjiService tJuanjiService;
    @Autowired TJianjiService tJianjiService;

    @Autowired
    private TDalxglService tDalxglService;

    @Autowired
    private CommonSzhjgService commonSzhjgService;



    //项目批次选择框
    @Override
    public CommonResult queryProjectBatch(Integer gxId) {
        //创建一个集合
        List<Object> arrayList = null;
        if (gxId!=null){
            arrayList = projectBatchList1(gxId);
        }else {
            arrayList = projectBatchList2(gxId);
        }
        if ( arrayList.size()>0 ){
            return CommonResult.success(arrayList);
        }else {
            return CommonResult.error(500, "未查询到相关项目的批次信息!");
        }
    }
    //项目批次选择框 --查询加工工序使用
    private List<Object> projectBatchList1(Integer gxId) {
        List<Object> arrayList = new ArrayList<>();
        //查询项目是否有此工序,有删除
        List<TProject> projectList = xmProject(gxId);
        //根据软件id查询批次信息
        for (TProject tProject : projectList){
            Map<String,Object> map = new HashMap<>();
            String  uuid = IdUtils.fastSimpleUUID();
            map.put("benId",uuid);
            map.put("projectName",tProject.getProjectName());
            //查询批次
            LambdaQueryWrapper<TBatch> batchWrapper = new LambdaQueryWrapper<>();
            batchWrapper.eq(TBatch::getProjectId,tProject.getId()).eq(TBatch::getIsfinished,"0");
            List<TBatch> batchList = tBatchService.list(batchWrapper);
            List<Object> list = new ArrayList<>();
            for (TBatch tBatch : batchList){
                Map<String,Object> map2 = new HashMap<>();
                map2.put("benId",tBatch.getId());
                map2.put("shangId",uuid);
                map2.put("projectName",tBatch.getPcName());
                list.add(map2);
            }
            map.put("pcName",list);
            if ( batchList.size()>0 ){
                map.put("Archives",batchList.get(0).getDalx());
            }else {
                map.put("Archives","");
            }
            arrayList.add(map);
        }
        return arrayList;
    }
    //项目批次选择框--查询项目是否有此工序,有删除
    private List<TProject> xmProject(Integer gxId) {
        LambdaQueryWrapper<TProject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TProject::getIsfinished,0);
        wrapper.orderByDesc(TProject::getCreateTime);
        List<TProject> projectList = tProjectService.list(wrapper);
        //查看项目是否有此工序
        Iterator<TProject> iterator = projectList.iterator();
        while (iterator.hasNext()) {
            LambdaQueryWrapper<TProjectGxhj> gxWrapper = new LambdaQueryWrapper<>();
            gxWrapper.eq(TProjectGxhj::getProjectId,iterator.next().getId());
            List<TProjectGxhj> list = tProjectGxhjService.list(gxWrapper);
            int i = '0';
            for (TProjectGxhj tProjectGxhj : list){
                if (tProjectGxhj.getGxxh().equals(gxId)){
                    i = i+1;
                    break;// 跳出当前循环
                }
            }
            if ( i=='0' ){
                iterator.remove();
            }
        }
        return projectList;
    }
    //项目批次选择框 --查询加工工序之外使用
    private List<Object> projectBatchList2(Integer gxId) {
        //创建一个集合
        List<Object> arrayList = new ArrayList<>();
        //查询项目信息
        LambdaQueryWrapper<TProject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TProject::getIsfinished,0);
        wrapper.orderByDesc(TProject::getCreateTime);
        List<TProject> projectList = tProjectService.list(wrapper);
        //根据软件id查询批次信息
        for (TProject tProject : projectList){
            Map<String,Object> map = new HashMap<>();
            String  uuid = IdUtils.fastSimpleUUID();
            map.put("benId",uuid);
            map.put("projectName",tProject.getProjectName());
            //查询批次
            LambdaQueryWrapper<TBatch> batchWrapper = new LambdaQueryWrapper<>();
            batchWrapper.eq(TBatch::getProjectId,tProject.getId()).orderByAsc(TBatch::getIsfinished);
            List<TBatch> batchList = tBatchService.list(batchWrapper);
            List<Object> list = new ArrayList<>();
            for (TBatch tBatch : batchList){
                Map<String,Object> map2 = new HashMap<>();
                map2.put("benId",tBatch.getId());
                map2.put("shangId",uuid);
                //判断是否完成
                if ("0".equals(tBatch.getIsfinished())){
                    map2.put("projectName",tBatch.getPcName()+"（进行中）");
                }else if ("1".equals(tBatch.getIsfinished())){
                    map2.put("projectName",tBatch.getPcName()+"（已完成）");
                }else {
                    map2.put("projectName",tBatch.getPcName());
                }
                map2.put("batchState",tBatch.getIsfinished());
                list.add(map2);
            }
            map.put("pcName",list);
            arrayList.add(map);
        }
        return arrayList;
    }



    //页面动态展示工序名称
    @Override
    public List<Object> queryDisplayGx() {
        List<Object> listMap = new ArrayList<>();
        LambdaQueryWrapper<TGxhjgl> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(TGxhjgl::getGxxh);
        List<TGxhjgl> list = tGxhjglService.list(wrapper);
        for (TGxhjgl tGxhjgl :list){
            Map<String, Object> map = new HashMap<>();
            map.put("label" , tGxhjgl.getGxmc());
            map.put("value" , tGxhjgl.getGxxh());
            listMap.add(map);
        }
        return listMap;
    }



    /**查询档案类型名称
     * 2023-05-02
     * @return
     */
    @Override
    public List<Object> queryArchivesName (String dictType) {
        List<Object> listMap = null;
        try {
            LambdaQueryWrapper<TDalxgl> wrapper = new LambdaQueryWrapper<>();
            wrapper.orderByAsc(TDalxgl::getCreateTime);
            List<TDalxgl> list = tDalxglService.list(wrapper);
            listMap = new ArrayList<>();
            for (TDalxgl tDalxgl : list){
                Map<String, String> map = new HashMap<>();
                map.put("label", tDalxgl.getDamc());
                map.put("value", tDalxgl.getId());
                listMap.add(map);
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new ArithmeticException("查询档案类型名称失败");
        }
        return listMap;
    }



    //获取下一步工序
    @Override
    public Integer processId(String pcId, Integer gxxh) {
        //根据批次id查询批次信息
        LambdaQueryWrapper<TBatch> batchWrapper = new LambdaQueryWrapper<>();
        batchWrapper.eq(TBatch::getId,pcId);
        List<TBatch> list = tBatchService.list(batchWrapper);
        TBatch tBatch = new TBatch();
        if(list.size()>0){
            tBatch = list.get(0);
        }
        //根据批次信息中的项目id查询关联工序
        LambdaQueryWrapper<TProjectGxhj> gxhjWrapper = new LambdaQueryWrapper<>();
        gxhjWrapper.eq(TProjectGxhj::getProjectId,tBatch.getProjectId());
        gxhjWrapper.orderByAsc(TProjectGxhj::getGxxh);
        List<TProjectGxhj> gxList = tProjectGxhjService.list(gxhjWrapper);
        //存放数据列表下标
        int top = 0;
        for (int i=0;i<gxList.size();i++){
            if(gxList.get(i).getGxxh().equals(gxxh)){
                top = i;
            }
        }
        TProjectGxhj projectGxhj = new TProjectGxhj();
        //判断是否是最后一个工序
        if (top == (gxList.size() - 1)){
            projectGxhj = gxList.get(gxList.size() - 1);
            return projectGxhj.getGxxh();
        }
        //获取下一个工序信息
        if ( gxxh !=null ){
            projectGxhj = gxList.get(top+1);
        }else {
            projectGxhj = gxList.get(top);
        }
        return projectGxhj.getGxxh();
    }



    //案卷绑定当前操作人员
    @Override
    public CommonResult bindingRecipient(String nameId) {
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();  // 获取当前的用户
        LambdaQueryWrapper<TJuanji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJuanji::getId,nameId);
        List<TJuanji> list = tJuanjiService.list(wrapper);
        TJuanji taskJuan = new TJuanji();
        if ( list.size()>0 ){
            taskJuan = list.get(0);
        }
        Integer integer = commonSzhjgService.processId(taskJuan.getPcId(), taskJuan.getDqgx());
        taskJuan.setLqr(userName);
        if (integer == 2){
            taskJuan.setDqgx(integer);
        }
        taskJuan.setClaimTime(new Date());
        taskJuan.setRwzt("进行中");

        boolean b = tJuanjiService.updateById(taskJuan);
        if (b) {
            return new CommonResult(200,"用户绑定成功");
        } else {
            return new CommonResult(500,"用户绑定失败");
        }
    }



    //查询案卷下指定文件信息
    @Override
    public List<TJianji> taskPieceList(String ajId,String jh) {
        LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJianji::getAjId,ajId).eq(TJianji::getJh,jh);
        wrapper.orderByAsc(TJianji::getYm);
        return tJianjiService.list(wrapper);
    }


}
