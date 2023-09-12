package com.fudian.szhjg.busiservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.common.utils.uuid.IdUtils;
import com.fudian.szhjg.busiservice.CheckTaskService;
import com.fudian.szhjg.mapper.TChoujianTaskMapper;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.pojo.*;
import com.fudian.szhjg.pojo.vo.CheckVO;
import com.fudian.szhjg.service.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CheckTaskServiceImpl implements CheckTaskService {

    @Autowired
    private TProjectService projectService;
    @Autowired
    private TBatchService batchService;

    @Autowired
    private TJuanjiService tJuanjiService;
    @Autowired
    private TJuanjiMapper tJuanjiMapper;

    @Autowired
    private TChoujianTaskService choujianTaskService;
    @Autowired
    private TChoujianTaskMapper choujianTaskMapper;

    @Autowired
    private TGrgzltjService grgzltjService;



    //抽检项目批次查询
    @Override
    public CommonResult completeProjectBatch() {
        //创建一个集合
        List<Object> arrayList = new ArrayList<>();
        //查询已完成的项目
        String idTwo = IdUtils.fastSimpleUUID();
        Map<String,Object> mapX = new HashMap<>();
        mapX.put("benId",idTwo);
        mapX.put("projectName","已完成项目");
        LambdaQueryWrapper<TProject> projectTwo = new LambdaQueryWrapper<>();
        projectTwo.eq(TProject::getIsfinished,"1").orderByDesc(TProject::getCreateTime);
        List<TProject> listTwo = projectService.list(projectTwo);
        List<Object> listATwo = new ArrayList<>();  //存放项目的信息
        for (TProject twoProject:listTwo){
            Map<String,Object> mapY = new HashMap<>();
            mapY.put("benId",twoProject.getId());
            mapY.put("shangId",idTwo);
            mapY.put("projectName",twoProject.getProjectName());
            //查询项目下的已完成批次信息
            LambdaQueryWrapper<TBatch> batchWrapperTwo = new LambdaQueryWrapper<>();
            batchWrapperTwo.eq(TBatch::getProjectId,twoProject.getId());
            List<TBatch> batchTwo = batchService.list(batchWrapperTwo);
            List<Object> listBTwo = new ArrayList<>();
            for (TBatch twoBatch:batchTwo){
                Map<String,Object> mapZ = new HashMap<>();
                mapZ.put("benId",twoBatch.getId());
                mapZ.put("shangId",twoProject.getId());
                mapZ.put("projectName",twoBatch.getPcName());
                listBTwo.add(mapZ);
            }
            mapY.put("pcName",listBTwo);
            mapY.put("archives",twoProject.getDalx());
            listATwo.add(mapY);
        }
        mapX.put("pcName",listATwo);
        arrayList.add(mapX);

        //查询进行中的项目
        String idOne = IdUtils.fastSimpleUUID();
        Map<String,Object> mapA = new HashMap<>();
        mapA.put("benId",idOne);
        mapA.put("projectName","进行中项目");
        LambdaQueryWrapper<TProject> projectOne = new LambdaQueryWrapper<>();
        projectOne.eq(TProject::getIsfinished,"0").orderByDesc(TProject::getCreateTime);
        List<TProject> listOne = projectService.list(projectOne);
        List<Object> listAOne = new ArrayList<>();  //存放项目的信息
        for (TProject oneProject:listOne){
            Map<String,Object> mapB = new HashMap<>();
            mapB.put("benId",oneProject.getId());
            mapB.put("shangId",idOne);
            mapB.put("projectName",oneProject.getProjectName());
            //查询项目下的已完成批次信息
            LambdaQueryWrapper<TBatch> batchWrapperOne = new LambdaQueryWrapper<>();
            batchWrapperOne.eq(TBatch::getProjectId,oneProject.getId()).eq(TBatch::getIsfinished,"1");
            List<TBatch> batchOne = batchService.list(batchWrapperOne);
            List<Object> listBOne = new ArrayList<>();
            for (TBatch oneBatch:batchOne){
                Map<String,Object> mapC = new HashMap<>();
                mapC.put("benId",oneBatch.getId());
                mapC.put("shangId",oneProject.getId());
                mapC.put("projectName",oneBatch.getPcName());
                listBOne.add(mapC);
            }
            mapB.put("pcName",listBOne);
            mapB.put("archives",oneProject.getDalx());
            listAOne.add(mapB);
        }
        mapA.put("pcName",listAOne);
        arrayList.add(mapA);

        if ( arrayList.size()>0 ){
            return CommonResult.success(arrayList);
        }else {
            return CommonResult.error(500, "未查询到相关项目的批次信息!");
        }
    }
    /*@Override
    public CommonResult completeProjectBatch() {
        //创建一个集合
        List<Object> arrayList = new ArrayList<>();
        //查询项目
        LambdaQueryWrapper<TProject> projectWrapper = new LambdaQueryWrapper<>();
        projectWrapper.orderByDesc(TProject::getCreateTime);
        List<TProject> projectList = projectService.list(projectWrapper);
        for (TProject project : projectList){
            String id = IdUtils.fastSimpleUUID();
            Map<String,Object> mapP = new HashMap<>();
            mapP.put("benId",id);
            mapP.put("projectName",project.getProjectName());
            //查询批次
            LambdaQueryWrapper<TBatch> batchWrapper = new LambdaQueryWrapper<>();
            batchWrapper.eq(TBatch::getProjectId,project.getId());
            List<TBatch> batchList = batchService.list(batchWrapper);
            List<Object> list = new ArrayList<>();
            for (TBatch batch :batchList){
                Map<String,Object> mapB = new HashMap<>();
                mapB.put("benId",batch.getId());
                mapB.put("shangId",id);
                mapB.put("projectName",batch.getPcName());
                list.add(mapB);
            }
            mapP.put("pcName",list);
            if ( batchList.size()>0 ){
                mapP.put("archives",batchList.get(0).getDalx());
            }else {
                mapP.put("archives","");
            }
            arrayList.add(mapP);
        }
        if ( arrayList.size()>0 ){
            return CommonResult.success(arrayList);
        }else {
            return CommonResult.error(500, "未查询到相关项目的批次信息!");
        }
    }*/


    //页面动态展示批次名称
    @Override
    public List<Object> queryBatchName() {
        List<Object> list = new ArrayList<>();
        LambdaQueryWrapper<TBatch> batchWrapper = new LambdaQueryWrapper<>();
        batchWrapper.orderByAsc(TBatch::getCreateTime);
        List<TBatch> batchList = batchService.list(batchWrapper);
        for (TBatch batch : batchList){
            Map<String, Object> map = new HashMap<>();
            map.put("label" , batch.getPcName());
            map.put("value" , batch.getId());
            list.add(map);
        }
        return list;
    }


    //新增抽检之前查询条数
    @Override
    public CommonResult addSpotNumber(CheckVO checkVO) {
        int length = tJuanjiMapper.getLengthTask(checkVO.getPcId());
        //抽取比例
        Double scope = Double.valueOf(checkVO.getFileScope());
        //抽取数量
        int t = (int) (scope / 100 * length);
        if (t < 1) {
            t = 1;
        }
        String msg = "";
        if ( length == 0){
            msg = "本次查询总数为["+length+"], 生成抽检条数["+0+"].";
        }else {
            msg = "本次查询总数为["+length+"], 生成抽检条数["+t+"].";
        }

        return new CommonResult(200,msg);
    }

    //新增生成抽检
    @Override
    public CommonResult addSpotCheck(CheckVO checkVO) {
        CommonResult commonResult = new CommonResult();
        //获取当前的用户
        String user = SecurityUtils.getLoginUser().getUser().getNickName();
        //抽取比例
        Double scope = Double.valueOf(checkVO.getFileScope());
        //根据批次id获取其下案卷总数
        int length = tJuanjiMapper.getLengthTask(checkVO.getPcId());
        //抽取数量
        int t = (int) (scope / 100 * length);
        if (t < 1) {
            t = 1;
        }
        if (length == 0){
            t = 0;
        }
        //查询当前批次下的已经抽取出来的数据并且在随机抽取中 过滤掉
        LambdaQueryWrapper<TChoujianTask> juanWrapper = new LambdaQueryWrapper<>();
        juanWrapper.eq(TChoujianTask::getPcId,checkVO.getPcId());
        List<TChoujianTask> chouList = choujianTaskService.list(juanWrapper);
        List<String> ajIds = chouList.stream().map(TChoujianTask::getAjId).collect(Collectors.toList());
        List<TJuanji> taskList = null;
        if ( ajIds.size()>0 ) {
            //执行抽取
            taskList = tJuanjiMapper.randomExtraData(t,checkVO.getPcId(),ajIds);
        }else {
            taskList = tJuanjiMapper.randomExtraData(t,checkVO.getPcId(),ajIds);
        }
        List<TChoujianTask> chouTaskList = new ArrayList<>();
        for (TJuanji juanTask: taskList){
            TChoujianTask tChoujianTask = new TChoujianTask();
            String id =IdUtils.simpleUUID();
            tChoujianTask.setId(id);
            tChoujianTask.setPcId(juanTask.getPcId());
            tChoujianTask.setAjId(juanTask.getId());
            tChoujianTask.setBh(juanTask.getBh());
            tChoujianTask.setCjrNx(user);
            tChoujianTask.setClaimTime(new Date());
            tChoujianTask.setTaskFlag("0");
            chouTaskList.add(tChoujianTask);
        }
        boolean b = choujianTaskService.saveBatch(chouTaskList);
        if (b){
            commonResult.setCode(200);
            commonResult.setMsg("抽检任务成功");
        }else {
            commonResult.setCode(500);
            commonResult.setMsg("抽检任务失败");
        }
        return commonResult;
    }

    //编号抽检重名查询
    @Override
    public String checkNameBhCount(String bh) {
        String flag = "false";
        if (StringUtils.isNotBlank(bh)){
            LambdaQueryWrapper<TChoujianTask> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(TChoujianTask::getBh,bh);
            List<TChoujianTask> list = choujianTaskService.list(wrapper);
            if ( list.size()>0 ){
                flag = "true";
            }
        }
        return flag;
    }

    //新增编号抽检
    @Override
    public CommonResult addDhCheck(String pcId, String bh) {
        String user = SecurityUtils.getLoginUser().getUser().getNickName();
        CommonResult commonResult = new CommonResult();
        LambdaQueryWrapper<TJuanji> taskWrapper = new LambdaQueryWrapper<>();
        taskWrapper.eq(TJuanji::getPcId, pcId).eq(TJuanji::getBh, bh);
        List<TJuanji> list = tJuanjiService.list(taskWrapper);
        TJuanji taskJuan = new TJuanji();
        if (list.size()>0){
            taskJuan = list.get(0);
        }else {
            return new CommonResult(500,"未查询到相关信息");
        }
        if (!"已完成".equals(taskJuan.getRwzt())){
            return new CommonResult(500,"当前案卷任务未完成,无法进行抽检");
        }
        TChoujianTask choujianTask = new TChoujianTask();
        String id =IdUtils.simpleUUID();
        choujianTask.setId(id);
        choujianTask.setPcId(taskJuan.getPcId());
        choujianTask.setAjId(taskJuan.getId());
        choujianTask.setBh(taskJuan.getBh());
        choujianTask.setCjrNx(user);
        choujianTask.setClaimTime(new Date());
        choujianTask.setTaskFlag("0");
        int i = choujianTaskMapper.insert(choujianTask);
        if ( i>0 ){
            commonResult.setCode(200);
            commonResult.setMsg("编号抽检成功");
        }else {
            commonResult.setCode(200);
            commonResult.setMsg("编号抽检任务生成失败");
        }
        return commonResult;
    }

    //查询案卷工序记录
    @Override
    public CommonGridResult queryAJRecord(TGrgzltj tGrgzltj) {
        LambdaQueryWrapper<TGrgzltj> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TGrgzltj::getAjId,tGrgzltj.getAjId());
        wrapper.orderByDesc(TGrgzltj::getFinishTime);
        PageHelper.startPage(tGrgzltj.getPageNum(),tGrgzltj.getPageSize());
        List<TGrgzltj> list = grgzltjService.list(wrapper);
        Page page = (Page) list;
        CommonGridResult commonGridResult = new CommonGridResult(tGrgzltj.getPageNum(), tGrgzltj.getPageSize(), page.getTotal(), list);
        return commonGridResult;
    }

}
