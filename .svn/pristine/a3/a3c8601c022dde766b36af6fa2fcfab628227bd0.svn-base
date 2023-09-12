package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.core.domain.model.LoginUser;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.common.utils.StringUtils;
import com.fudian.common.utils.uuid.IdUtils;
import com.fudian.szhjg.mapper.TDalxglMapper;
import com.fudian.szhjg.pojo.TDalxgl;
import com.fudian.szhjg.service.TDalxglService;
import com.fudian.szhjg.templateMode.CommonTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Description 档案类型管理
 * @Date 2023/02/06 10:00
 **/
@Api(tags = "A41  业务管理-档案类型管理")
@RestController
@RequestMapping("/ywgl/dalxgl")
public class DalxglController {

    @Autowired
    private TDalxglService tDalxglService;
    @Autowired
    private TDalxglMapper tDalxglMapper;


    /**查询档案列表
     * 2023-02-06
     * @param tDalxgl
     * @return
     */
    @ApiOperation("查询档案列表")
    @GetMapping("/queryDalxglList")
    @ResponseBody
    public CommonGridResult queryDalxglList(TDalxgl tDalxgl){
        CommonTemplate commonTemplate = new CommonTemplate(tDalxgl,tDalxglService,tDalxglMapper);
        //查询条件
        LambdaQueryWrapper<TDalxgl> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(tDalxgl.getDamc())){
            wrapper.like(TDalxgl::getDamc,tDalxgl.getDamc());
        }
        wrapper.orderByAsc(TDalxgl::getCreateTime);

        CommonGridResult commonGridResult = commonTemplate.list(wrapper);
        return  commonGridResult;
    }

    /**新增档案类型信息
     * 2023-02-06
     * @param tDalxgl
     * @return
     */
    @ApiOperation("新增档案类型")
    @PostMapping("/addDalxglOne")
    @ResponseBody
    public CommonResult addDalxglOne(@Validated @RequestBody TDalxgl tDalxgl){
        String uuid = IdUtils.simpleUUID();  //创建uuid
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //后台赋值
        tDalxgl.setId(uuid);
        tDalxgl.setCreateBy(loginUser.getUser().getNickName());
        tDalxgl.setCreateTime(new Date());

        CommonTemplate commonTemplate = new CommonTemplate(tDalxgl,tDalxglService,tDalxglMapper);
        CommonResult commonResult = commonTemplate.insert();
        return  commonResult;
    }

    /**编辑档案类型信息
     * 2023-02-06
     * @param tDalxgl
     * @return
     */
    @ApiOperation("编辑档案类型")
    @PostMapping("/updateDalxglOne")
    @ResponseBody
    public CommonResult updateDalxglOne(@Validated @RequestBody TDalxgl tDalxgl){
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //后台赋值
        tDalxgl.setUpdateBy(loginUser.getUser().getNickName());
        tDalxgl.setUpdateTime(new Date());

        CommonTemplate commonTemplate = new CommonTemplate(tDalxgl,tDalxglService,tDalxglMapper);
        CommonResult commonResult = commonTemplate.update();
        return  commonResult;
    }

    /**删除档案类型信息
     * 2023-02-06
     * @param id
     * @return
     */
    @ApiOperation("删除档案类型")
    @DeleteMapping("/deleteDalxglId/{id}")
    @ResponseBody
    public CommonResult deleteDalxglId(@PathVariable("id") String id){
        TDalxgl tDalxgl = new TDalxgl();
        CommonTemplate commonTemplate = new CommonTemplate(tDalxgl,tDalxglService,tDalxglMapper);
        CommonResult commonResult = commonTemplate.delete(id);
        return  commonResult;
    }
    
}
