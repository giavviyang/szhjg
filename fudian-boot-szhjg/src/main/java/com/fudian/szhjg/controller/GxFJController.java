package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.szhjg.busiservice.FJService;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.pojo.TJianji;
import com.fudian.szhjg.pojo.TJuanji;
import com.fudian.szhjg.pojo.TTaskJuan;
import com.fudian.szhjg.pojo.TTaskPiece;
import com.fudian.szhjg.pojo.vo.TaskPieceVO;
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

@Api(tags = "A32  数据加工-分件")
@RestController
@RequestMapping("/sjjg/fj")
public class GxFJController {

    @Autowired
    private TJuanjiMapper tJuanjiMapper;
    @Autowired
    private TJuanjiService tJuanjiService;

    @Autowired
    private FJService fjService;


    /**分件-查询任务列表
     * 2023-03-20
     * @param tJuanji
     * @return
     */
    @ApiOperation("分件-查询任务列表")
    @ApiOperationSupport(order = 1)
    @GetMapping("/queryFJTaskList")
    @ResponseBody
    public CommonGridResult queryFJTaskList(TJuanji tJuanji){
        //获取当前的用户
        String userName = SecurityUtils.getLoginUser().getUser().getNickName();
        CommonTemplate commonTemplate = new CommonTemplate(tJuanji,tJuanjiService,tJuanjiMapper);
        LambdaQueryWrapper<TJuanji> tWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(tJuanji.getPcId())){
            tWrapper.eq(TJuanji::getPcId,tJuanji.getPcId());
        }
        if (StringUtils.isNotBlank(tJuanji.getBh())){
            tWrapper.like(TJuanji::getBh,tJuanji.getBh());
        }
        tWrapper.eq(TJuanji::getDqgx,"2");
        tWrapper.and(wrapper ->wrapper.eq(TJuanji::getLqr,userName).or().eq(TJuanji::getLqr,"").or().isNull(TJuanji::getLqr));
        tWrapper.ne(TJuanji::getRwzt,"已完成");
        tWrapper.ne(TJuanji::getCataloged,"著录中");
        tWrapper.orderByDesc(TJuanji::getRwzt).orderByAsc(TJuanji::getBh);
        CommonGridResult commonGridResult = commonTemplate.list(tWrapper);
        return commonGridResult;
    }



    @ApiOperation("查询分件列表")
    @ApiOperationSupport(order = 2)
    @GetMapping("/searchSubdivisionList")
    @ResponseBody
    public CommonGridResult searchSubdivisionList(TJianji tJianji){
        CommonGridResult commonGridResult = fjService.searchSubdivisionList(tJianji);
        return commonGridResult;
    }



    @ApiOperation("查询案卷中最后件号")
    @ApiOperationSupport(order = 11)
    @GetMapping("/finallyNumber")
    @ResponseBody
    public ResponseEntity finallyNumber(String fjId) {
        String o = fjService.finallyNumber(fjId);
        return ResponseEntity.ok(CommonResult.success(o));
    }

    @ApiOperation("查询案卷中最大页码")
    @ApiOperationSupport(order = 12)
    @GetMapping("/queryMaxYm")
    @ResponseBody
    public ResponseEntity queryMaxYm(String fjId){
        Integer i = fjService.queryMaxYm(fjId);
        return ResponseEntity.ok(CommonResult.success(i));
    }

    @ApiOperation("新增分件")
    @ApiOperationSupport(order = 21)
    @PostMapping("/insertSubdivisionAdd")
    @ResponseBody
    public CommonResult insertSubdivisionAdd(@Validated @RequestBody TaskPieceVO taskPieceVO){
        CommonResult commonResult = fjService.insertSubdivisionAdd(taskPieceVO);
        return commonResult;
    }

    @ApiOperation("加页")
    @ApiOperationSupport(order = 22)
    @GetMapping("/additionPage")
    @ResponseBody
    public CommonResult additionPage(String partJH, String aId) {
        return fjService.additionPage(partJH,aId);
    }
    @ApiOperation("减页")
    @ApiOperationSupport(order = 23)
    @GetMapping("/subtractedPage")
    @ResponseBody
    public CommonResult subtractedPage(String partJH, String aId) {
        return fjService.subtractedPage(partJH,aId);
    }

    @ApiOperation("拆件")
    @ApiOperationSupport(order = 24)
    @GetMapping("/disassemblePCS")
    @ResponseBody
    public CommonResult disassemblePCS(String wId, String partJH, String aId) {
        return fjService.disassemblePCS(wId,partJH,aId);
    }
    @ApiOperation("合件")
    @ApiOperationSupport(order = 25)
    @GetMapping("/assemblyPCS")
    @ResponseBody
    public CommonResult assemblyPCS(String partJH, String aId) {
        return fjService.assemblyPCS(partJH,aId);
    }

    @ApiOperation("清空文件")
    @ApiOperationSupport(order = 26)
    @GetMapping("/emptyPCS")
    @ResponseBody
    public CommonResult emptyPCS(String aId) {
        return fjService.emptyPCS(aId);
    }

}
