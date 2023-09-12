package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.szhjg.busiservice.TaskService;
import com.fudian.szhjg.busiservice.TxImageService;
import com.fudian.szhjg.mapper.TJianjiMapper;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.pojo.TJianji;
import com.fudian.szhjg.pojo.TJuanji;
import com.fudian.szhjg.service.TJianjiService;
import com.fudian.szhjg.service.TJuanjiService;
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


@Api(tags = "A36  数据加工-目录著录")
@RestController
@RequestMapping("/sjjg/mlzl")
public class GxMlzlController {

    @Autowired
    private TJuanjiMapper tJuanjiMapper;
    @Autowired
    private TJuanjiService tJuanjiService;

    @Autowired
    private TJianjiMapper tJianjiMapper;
    @Autowired
    private TJianjiService tJianjiService;

    @Autowired
    private TaskService taskService;
    @Autowired
    private TxImageService txImageService;



    /**查询案卷信息
     * 2023-02-21
     * @param tJuanji
     * @return
     */
    @ApiOperation("目录著录-查询案卷信息(任务列表)")
    @ApiOperationSupport(order = 1)
    @GetMapping("/queryDirectory")
    @ResponseBody
    public CommonGridResult queryDirectory(TJuanji tJuanji){
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();
        CommonTemplate commonTemplate = new CommonTemplate(tJuanji,tJuanjiService,tJuanjiMapper);
        LambdaQueryWrapper<TJuanji> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(tJuanji.getPcId())){
            wrapper.eq(TJuanji::getPcId,tJuanji.getPcId());
        }
        if (StringUtils.isNotBlank(tJuanji.getBh())){
            wrapper.like(TJuanji::getBh,tJuanji.getBh());
        }
        wrapper.eq(TJuanji::getCataloged,"著录中").eq(TJuanji::getLqr,userName);
        wrapper.orderByAsc(TJuanji::getDqgx).orderByAsc(TJuanji::getClaimTime);
        CommonGridResult commonGridResult = commonTemplate.list(wrapper);
        return commonGridResult;
    }


    /**查询案件信息
     * 2023-02-21
     * @param tJianji
     * @return
     */
    @ApiOperation("目录著录-查询案件信息")
    @ApiOperationSupport(order = 2)
    @GetMapping("/queryCasePiece")
    @ResponseBody
    public CommonGridResult queryCasePiece(TJianji tJianji){
        CommonTemplate commonTemplate = new CommonTemplate(tJianji,tJianjiService,tJianjiMapper);
        LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TJianji::getAjId,tJianji.getAjId()).eq(TJianji::getSfsy,"是");
        wrapper.orderByAsc(TJianji::getYm);
        CommonGridResult commonGridResult = commonTemplate.list(wrapper);
        return commonGridResult;
    }


    @ApiOperation("目录著录-文件查询图片列表方法")
    @ApiOperationSupport(order = 3)
    @GetMapping("/queryPicturePiece")
    @ResponseBody
    public CommonGridResult queryPicturePiece(TJianji tJianji){
        CommonGridResult commonGridResult = txImageService.queryPicturePiece(tJianji);
        return commonGridResult;
    }


    @ApiOperation("著录--案卷著录")
    @ApiOperationSupport(order = 11)
    @PostMapping("/insertCaseFile")
    @ResponseBody
    public CommonResult insertCaseFile(@Validated @RequestBody TJuanji tJuanji){
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();  //获取当前的用户
        tJuanji.setUpdateBy(userName);
        tJuanji.setUpdateTime(new Date());
        CommonTemplate commonTemplate = new CommonTemplate(tJuanji,tJuanjiService,tJuanjiMapper);
        CommonResult commonResult = commonTemplate.update();
        return commonResult;
    }


    @ApiOperation("著录--案件著录")
    @ApiOperationSupport(order = 12)
    @PostMapping("/insertCasePiece")
    @ResponseBody
    public CommonResult insertCasePiece(@Validated @RequestBody TJianji tJianji){
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();  //获取当前的用户
        tJianji.setUpdateBy(userName);
        tJianji.setUpdateTime(new Date());
        CommonTemplate commonTemplate = new CommonTemplate(tJianji,tJianjiService,tJianjiMapper);
        CommonResult commonResult = commonTemplate.update();
        return commonResult;
    }






    /*@ApiOperation("查询人事档案分类")
    @GetMapping("/queryDictType")
    public List<Object> queryDictType(){
     return taskService.queryDictType();
    }

    @ApiOperation("著录--案件著录查询人事档案分类类号")
    @GetMapping("/casePersonnelClass")
    public ResponseEntity casePersonnelClass(String ajId, String clfl){
        String flag = taskService.casePersonnelClass(ajId,clfl);
        return ResponseEntity.ok(CommonResult.success(flag));
    }*/

}
