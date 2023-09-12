package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.core.controller.BaseController;
import com.fudian.common.core.domain.model.LoginUser;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.common.utils.uuid.IdUtils;
import com.fudian.szhjg.busiservice.ProjectManagementService;
import com.fudian.szhjg.mapper.TGxhjglMapper;
import com.fudian.szhjg.mapper.TProjectGxhjMapper;
import com.fudian.szhjg.mapper.TProjectMapper;
import com.fudian.szhjg.pojo.TGxhjgl;
import com.fudian.szhjg.pojo.TProject;
import com.fudian.szhjg.pojo.TProjectGxhj;
import com.fudian.szhjg.service.TGxhjglService;
import com.fudian.szhjg.service.TProjectGxhjService;
import com.fudian.szhjg.service.TProjectService;
import com.fudian.szhjg.templateMode.CommonTemplate;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Api(tags = "A11  项目批次管理-项目管理")
@RestController
@RequestMapping("/xmgl")
public class ProjectManagementController extends BaseController {

    @Autowired
    private TProjectService tProjectService;
    @Autowired
    private TProjectMapper tProjectMapper;

    @Autowired
    private TGxhjglService tGxhjglService;
    @Autowired
    private TGxhjglMapper tGxhjglMapper;

    @Autowired
    private TProjectGxhjService tProjectGxhjService;
    @Autowired
    private TProjectGxhjMapper tProjectGxhjMapper;

    @Autowired
    private ProjectManagementService projectManagementService;


    @ApiOperation("查询项目列表")
    @ApiOperationSupport(order = 1)
    @GetMapping("/queryProjectList")
    @ResponseBody
    public CommonGridResult queryProjectList(TProject tProject){
        CommonTemplate commonTemplate = new CommonTemplate(tProject,tProjectService,tProjectMapper);
        LambdaQueryWrapper<TProject> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.and(wrapper ->wrapper.eq(TProject::getIsfinished,tProject.getIsfinished()));
        if (StringUtils.isNotBlank(tProject.getProjectName())){
            lambdaQueryWrapper.like(TProject::getProjectName,tProject.getProjectName());
        }
//        lambdaQueryWrapper.orderByDesc((SFunction<TProject, ?>) tProject.getCreateTime());
        lambdaQueryWrapper.orderByDesc(TProject::getCreateTime);

//        CommonGridResult commonGridResult = commonTemplate.querySql("where project_name like '%"+tProject.getProjectName()+"%' order by create_time desc");
        CommonGridResult commonGridResult = commonTemplate.list(lambdaQueryWrapper);
        return  commonGridResult;
    }

    @ApiOperation("新增项目")
    @ApiOperationSupport(order = 2)
    @PostMapping("/addProject")
    @ResponseBody
    public CommonResult addProject(@Validated @RequestBody TProject tProject){
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //获取uuid
        String uuid = IdUtils.simpleUUID();
        tProject.setId(uuid);
        tProject.setIsfinished("0");
        tProject.setCreateBy(loginUser.getUser().getNickName());
        Date date = new Date();
        tProject.setCreateTime(date);
        tProject.setBegindate(date);
        CommonTemplate commonTemplate = new CommonTemplate(tProject,tProjectService,tProjectMapper);
        CommonResult commonResult = commonTemplate.insert();
        if (commonResult.getCode()==200){
            CommonResult common = projectManagementService.insertProcedure(tProject.getIds(),uuid);
            return common;
        }else {
            return  commonResult;
        }
    }

    @ApiOperation("编辑项目")
    @ApiOperationSupport(order = 3)
    @PostMapping("/updateProject")
    @ResponseBody
    public CommonResult updateProject(@Validated @RequestBody TProject tProject){
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        tProject.setUpdateBy(loginUser.getUser().getNickName());
        tProject.setUpdateTime(new Date());
        CommonTemplate commonTemplate = new CommonTemplate(tProject,tProjectService,tProjectMapper);
        CommonResult commonResult = commonTemplate.update();
        if (commonResult.getCode() == 200){
            CommonResult  result = projectManagementService.updateProcedure(tProject.getIds(),tProject.getId());
            return result;
        }
        return  commonResult;
    }

    @ApiOperation("删除项目")
    @ApiOperationSupport(order = 4)
    @DeleteMapping("/deleteProject/{id}")
    @ResponseBody
    public CommonResult deleteProject(@PathVariable("id") String id){
        //查询项目下是否有批次
        String exist = projectManagementService.queryProjectData(id);
        if ("true".equals(exist)){
            return new CommonResult(500,"该项目存在关联批次信息,无法删除项目!");
        }
        TProject tProject = new TProject();
        CommonTemplate commonTemplate = new CommonTemplate(tProject,tProjectService,tProjectMapper);
        CommonResult commonResult = commonTemplate.delete(id);
        return  commonResult;
    }



    @ApiOperation("查询工序环节数据")
    @ApiOperationSupport(order = 4)
    @GetMapping("/queryTGxhjglList")
    @ResponseBody
    public CommonGridResult queryTGxhjglList(TGxhjgl tGxhjgl){
        CommonTemplate commonTemplate = new CommonTemplate(tGxhjgl,tGxhjglService,tGxhjglMapper);
        LambdaQueryWrapper<TGxhjgl> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(TGxhjgl::getGxxh);
        CommonGridResult commonGridResult = commonTemplate.list(wrapper);
        return  commonGridResult;
    }

    @ApiOperation("查询本项目的工序")
    @ApiOperationSupport(order = 5)
    @GetMapping("/queryProjectGxhjList")
    @ResponseBody
    public CommonGridResult queryProjectGxhjList(TProjectGxhj tProjectGxhj){
        CommonTemplate commonTemplate = new CommonTemplate(tProjectGxhj,tProjectGxhjService,tProjectGxhjMapper);
        LambdaQueryWrapper<TProjectGxhj> tPGWrapper = new LambdaQueryWrapper<>();
        tPGWrapper.eq(TProjectGxhj::getProjectId,tProjectGxhj.getProjectId());
        tPGWrapper.orderByAsc(TProjectGxhj::getGxxh);
        CommonGridResult commonGridResult = commonTemplate.list2(tPGWrapper);
        return commonGridResult;
    }

    @ApiOperation("项目重名查询")
    @ApiOperationSupport(order = 6)
    @GetMapping("/queryDuplicate")
    public ResponseEntity queryDuplicate(String type , String projectName , String id){
        String t =  projectManagementService.queryDuplicate(type,projectName,id);
        return ResponseEntity.ok(CommonResult.success(t));
    }

    @ApiOperation("完成项目")
    @ApiOperationSupport(order = 7)
    @GetMapping("/completeProject")
    public CommonResult completeProject(String id){
        return projectManagementService.completeProject(id);
    }

}
