package com.fudian.szhjg.busiservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.szhjg.busiservice.ProjectManagementService;
import com.fudian.szhjg.mapper.TBatchMapper;
import com.fudian.szhjg.pojo.*;
import com.fudian.szhjg.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectManagementServiceImpl implements ProjectManagementService {

    @Autowired
    private TProjectService tProjectService;

    @Autowired
    private TBatchService tBatchService;
    @Autowired
    private TBatchMapper tBatchMapper;

    @Autowired
    private TGxhjglService tGxhjglService;
    @Autowired
    private TProjectGxhjService tProjectGxhjService;


    /**新增插入项目工序关联表
     * 2023-02-09
     * @param ids
     * @return
     */
    @Override
    public CommonResult insertProcedure(String[] ids, String uuid) {
        List<String> idsList = Arrays.asList(ids);
        //把工序环节管理表的数据拷贝到项目工序关联表中    TGxhjgl-->TProjectGxhj
        List<TProjectGxhj> tProjectList = new ArrayList<>();
        //for循环 进行数据查询
        for(String id : idsList){
            TProjectGxhj tProjectGxhj = new TProjectGxhj();
            TGxhjgl tGxhjgl = tGxhjglService.getById(id);
            tProjectGxhj.setGxId(tGxhjgl.getId());
            tProjectGxhj.setGxmc(tGxhjgl.getGxmc());
            tProjectGxhj.setGxxh(tGxhjgl.getGxxh());
            tProjectGxhj.setProjectId(uuid);  //项目id
            tProjectList.add(tProjectGxhj);
        }
        //新增保存
        boolean b = tProjectGxhjService.saveBatch(tProjectList);
        if ( b ) {
            return new CommonResult(200,"新增成功");
        } else {
            return new CommonResult(500,"新增失败");
        }
    }


    /**编辑项目工序关联表数据
     * 2023-02-10
     * @param ids
     * @return
     */
    @Override
    public CommonResult updateProcedure(String[] ids, String id) {
        //查询项目工序关联表数据
        LambdaQueryWrapper<TProjectGxhj> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TProjectGxhj::getProjectId,id);
        List<TProjectGxhj> list = tProjectGxhjService.list(wrapper);
        //删除项目工序
        LambdaQueryWrapper<TProjectGxhj> deleteWrapper = new LambdaQueryWrapper<>();
        deleteWrapper.eq(TProjectGxhj::getProjectId,id);
        boolean b = tProjectGxhjService.remove(deleteWrapper);
        if ( !b ){
            return new CommonResult(500,"修改失败");
        }
        //创建新集合--存放数据
        List<TProjectGxhj> projectList = new ArrayList<>();
        //遍历工序id集合
        List<String> idsList = Arrays.asList(ids);
        for (String a : idsList){
            //查询重复数据
          Iterator<TProjectGxhj> iterator = list.iterator();
            while (iterator.hasNext()) {
                TProjectGxhj tProjectGxhj = iterator.next();
                if (tProjectGxhj.getId().toString().equals(a)){
                    TProjectGxhj projectGxhj1 = new TProjectGxhj();
                    projectGxhj1.setGxId(tProjectGxhj.getGxId());
                    projectGxhj1.setGxmc(tProjectGxhj.getGxmc());
                    projectGxhj1.setGxxh(tProjectGxhj.getGxxh());
                    projectGxhj1.setProjectId(id);
                    projectList.add(projectGxhj1);
                }
            }
            //判断id长度是否是uuid
            if (a.length() > 30){
                TProjectGxhj projectGxhj2 = new TProjectGxhj();
                TGxhjgl tGxhjgl = tGxhjglService.getById(a);
                projectGxhj2.setGxId(tGxhjgl.getId());
                projectGxhj2.setGxmc(tGxhjgl.getGxmc());
                projectGxhj2.setGxxh(tGxhjgl.getGxxh());
                projectGxhj2.setProjectId(id);
                projectList.add(projectGxhj2);
            }
        }
        boolean t = tProjectGxhjService.saveBatch(projectList);
        if ( t ) {
            return new CommonResult(200,"修改成功");
        } else {
            return new CommonResult(500,"修改失败");
        }
    }


    /**项目重名查询
     * 2023-02-13
     * @param type
     * @param projectName
     * @param id
     * @return
     */
    @Override
    public String queryDuplicate(String type, String projectName, String id) {
        String flag = "false";
        if (type.equals("add")){
            LambdaQueryWrapper<TProject> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(TProject::getProjectName,projectName);
            List<TProject> list = tProjectService.list(wrapper);
            if (list.size()>0){
                flag = "true";
            }
            return flag;
        }else {
            LambdaQueryWrapper<TProject> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(TProject::getProjectName,projectName);
            List<TProject> list = tProjectService.list(wrapper);
            if (list.size()>0){
                TProject tProject = tProjectService.getById(id);
                if (tProject.getProjectName().equals(projectName)){
                    return flag;
                }
                flag = "true";
                return flag;
            }
            return flag;
        }
    }


    //查询项目下是否有批次
    @Override
    public String queryProjectData(String id) {
        String flag="false";
        LambdaQueryWrapper<TBatch> batchWrapper = new LambdaQueryWrapper<>();
        batchWrapper.eq(TBatch::getProjectId,id);
        List<TBatch> list = tBatchService.list(batchWrapper);
        if ( list.size()>0 ){
            flag = "true";
        }
        return flag;
    }


    //完成项目
    @Override
    public CommonResult completeProject(String id) {
        //查询当前项目信息
        LambdaQueryWrapper<TProject> projectWrapper = new LambdaQueryWrapper<>();
        projectWrapper.eq(TProject::getId,id);
        List<TProject> list = tProjectService.list(projectWrapper);
        TProject project = new TProject();
        if ( list.size()>0 ){
            project = list.get(0);
        }
        //查询是否存在批次
        LambdaQueryWrapper<TBatch> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TBatch::getProjectId, project.getId());
        List<TBatch> listBatch = tBatchService.list(wrapper);
        if ( listBatch.size()>0 ){
            //查询批次信息
            LambdaQueryWrapper<TBatch> batchWrapper = new LambdaQueryWrapper<>();
            batchWrapper.eq(TBatch::getProjectId,project.getId());
            batchWrapper.and(w->w.ne(TBatch::getIsfinished,"1").or().isNull(TBatch::getIsfinished));
            int i = tBatchMapper.selectCount(batchWrapper);
            if ( i>0 ){
                return new CommonResult(500,"当前项目存在未完成的批次,无法提交!");
            }
            //获取当前的用户
            String userName = SecurityUtils.getLoginUser().getUser().getNickName();
            //修改项目信息
            project.setIsfinished("1");
            project.setUpdateBy(userName);
            Date date = new Date();
            project.setUpdateTime(date);
            project.setEnddate(date);
            boolean b = tProjectService.updateById(project);
            if ( b ){
                return new CommonResult(200,"项目完成提交成功");
            }else {
                return new CommonResult(500,"项目完成提交失败");
            }
        }else {
            return new CommonResult(500,"当前项目下未创建批次,无法提交!");
        }
    }
}