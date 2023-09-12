package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.core.domain.model.LoginUser;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.common.utils.StringUtils;
import com.fudian.common.utils.uuid.IdUtils;
import com.fudian.szhjg.mapper.TGxhjglMapper;
import com.fudian.szhjg.pojo.TGxhjgl;
import com.fudian.szhjg.service.TGxhjglService;
import com.fudian.szhjg.templateMode.CommonTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description 工序环节管理
 * @Date 2023/02/07 11:30
 **/
@Api(tags = "A42  业务管理-工序环节管理")
@RestController
@RequestMapping("/ywgl/hjgl")
public class HjglController {

    @Autowired
    private TGxhjglMapper tGxhjglMapper;
    @Autowired
    private TGxhjglService tGxhjglService;


    /**查询档案列表
     * 2023-02-07
     * @param tGxhjgl
     * @return
     */
    @ApiOperation("查询工序环节列表")
    @GetMapping("/queryGxhjList")
    @ResponseBody
    public CommonGridResult queryGxhjList(TGxhjgl tGxhjgl){
        CommonTemplate commonTemplate = new CommonTemplate(tGxhjgl,tGxhjglService,tGxhjglMapper);
        //查询条件
        LambdaQueryWrapper<TGxhjgl> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(tGxhjgl.getGxmc())){
            wrapper.like(TGxhjgl::getGxmc,tGxhjgl.getGxmc());
        }
        wrapper.orderByAsc(TGxhjgl::getGxxh);

        CommonGridResult commonGridResult = commonTemplate.list(wrapper);
        return  commonGridResult;
    }

    /**新增档案类型信息
     * 2023-02-06
     * @param tGxhjgl
     * @return
     */
    @ApiOperation("新增工序环节类型")
    @PostMapping("/addGxhjOne")
    @ResponseBody
    public CommonResult addGxhjOne(@Validated @RequestBody TGxhjgl tGxhjgl){
        String uuid = IdUtils.simpleUUID();
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //后台赋值
        tGxhjgl.setId(uuid);
        tGxhjgl.setCreateBy(loginUser.getUser().getNickName());
        tGxhjgl.setCreateTime(new Date());

        CommonTemplate commonTemplate = new CommonTemplate(tGxhjgl,tGxhjglService,tGxhjglMapper);
        CommonResult commonResult = commonTemplate.insert();
        return  commonResult;
    }

    /**编辑工序环节
     * 2023-02-07
     * @param tGxhjgl
     * @return
     */
    @ApiOperation("编辑工序环节")
    @PostMapping("/updateGxhjOne")
    @ResponseBody
    public CommonResult updateGxhjOne(@Validated @RequestBody TGxhjgl tGxhjgl){
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //后台赋值
        tGxhjgl.setUpdateBy(loginUser.getUser().getNickName());
        tGxhjgl.setUpdateTime(new Date());

        CommonTemplate commonTemplate = new CommonTemplate(tGxhjgl,tGxhjglService,tGxhjglMapper);
        CommonResult commonResult = commonTemplate.update();
        return  commonResult;
    }

    /**删除工序信息
     * 2023-02-07
     * @param id
     * @return
     */
    @ApiOperation("删除工序信息")
    @DeleteMapping("/deleteGxhjId/{id}")
    @ResponseBody
    public CommonResult deleteGxhjId(@PathVariable("id") String id){
        TGxhjgl tGxhjgl = new TGxhjgl();
        CommonTemplate commonTemplate = new CommonTemplate(tGxhjgl,tGxhjglService,tGxhjglMapper);
        CommonResult commonResult = commonTemplate.delete(id);
        return  commonResult;
    }

    @ApiOperation("查询工序序号是否存在")
    @GetMapping("/selectGxxh")
    @ResponseBody
    public ResponseEntity selectGxxh(Integer gxxh){
        String gx = "false";
        LambdaQueryWrapper<TGxhjgl> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(TGxhjgl::getGxxh,gxxh);
        List<TGxhjgl> list = tGxhjglService.list(wrapper);
        if (list.size()>0){
            gx = "true";
        }
        return ResponseEntity.ok(CommonResult.success(gx));
    }

}
