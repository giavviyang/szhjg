package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.busiservice.CheckTaskService;
import com.fudian.szhjg.mapper.TChoujianTaskMapper;
import com.fudian.szhjg.pojo.TChoujianTask;
import com.fudian.szhjg.pojo.TGrgzltj;
import com.fudian.szhjg.pojo.vo.CheckVO;
import com.fudian.szhjg.service.TChoujianTaskService;
import com.fudian.szhjg.templateMode.CommonTemplate;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "A61  抽检任务生成")
@RestController
@RequestMapping("/spot/checkTask")
public class CheckTaskController {

    @Autowired
    private CheckTaskService checkTaskService;

    @Autowired
    private TChoujianTaskService choujianTaskService;
    @Autowired
    private TChoujianTaskMapper choujianTaskMapper;


    /**抽检项目批次查询
     * 2023-02-17
     * @return
     */
    @ApiOperation("抽检项目批次查询")
    @ApiOperationSupport(order = 1)
    @GetMapping("/completeProjectBatch")
    public CommonResult completeProjectBatch() {
        CommonResult commonResult = checkTaskService.completeProjectBatch();
        return commonResult;
    }

    /**抽检项目批次查询
     * 2023-03-22
     * @return
     */
    @ApiOperation("页面动态展示批次名称")
    @ApiOperationSupport(order = 2)
    @GetMapping("/queryBatchName")
    public List<Object> queryBatchName(){
        return checkTaskService.queryBatchName();
    }

    /**抽检项目批次查询
     * 2023-03-21
     * @param choujianTask
     * @return
     */
    @ApiOperation("查询抽检任务列表")
    @ApiOperationSupport(order = 3)
    @GetMapping("/querySpotCheckList")
    @ResponseBody
    public CommonGridResult querySpotCheckList(TChoujianTask choujianTask){
        CommonTemplate commonTemplate = new CommonTemplate(choujianTask,choujianTaskService,choujianTaskMapper);
        LambdaQueryWrapper<TChoujianTask> chouWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(choujianTask.getPcId())){
            chouWrapper.eq(TChoujianTask::getPcId,choujianTask.getPcId());
        }
        if (StringUtils.isNotBlank(choujianTask.getCjrNx())){
            chouWrapper.eq(TChoujianTask::getCjrNx,choujianTask.getCjrNx());
        }
        chouWrapper.eq(TChoujianTask::getTaskFlag,"0");
        chouWrapper.orderByAsc(TChoujianTask::getPcId).orderByDesc(TChoujianTask::getClaimTime);
        CommonGridResult commonGridResult = commonTemplate.list(chouWrapper);
        return commonGridResult;
    }

    @ApiOperation("新增抽检之前查询条数")
    @ApiOperationSupport(order = 11)
    @PostMapping("/addSpotNumber")
    @ResponseBody
    public CommonResult addSpotNumber(@Validated @RequestBody CheckVO checkVO){
        CommonResult commonResult = checkTaskService.addSpotNumber(checkVO);
        return commonResult;
    }

    @ApiOperation("新增生成抽检")
    @ApiOperationSupport(order = 12)
    @PostMapping("/addSpotCheck")
    @ResponseBody
    public CommonResult addSpotCheck(@Validated @RequestBody CheckVO checkVO){
        CommonResult commonResult = checkTaskService.addSpotCheck(checkVO);
        return commonResult;
    }

    @ApiOperation("编号抽检重名查询")
    @ApiOperationSupport(order = 21)
    @GetMapping("/checkNameBhCount")
    @ResponseBody
    public ResponseEntity checkNameBhCount(String bh){
        String flag = checkTaskService.checkNameBhCount(bh);
        return ResponseEntity.ok(CommonResult.success(flag));
    }

    @ApiOperation("新增编号抽检")
    @ApiOperationSupport(order = 22)
    @PostMapping("/addDhCheck")
    @ResponseBody
    public CommonResult addDhCheck(@Validated @RequestBody CheckVO checkVO){
        CommonResult commonResult = checkTaskService.addDhCheck(checkVO.getPcId(),checkVO.getBh());
        return commonResult;
    }

    @ApiOperation("查询案卷工序记录")
    @ApiOperationSupport(order = 31)
    @GetMapping("/queryAJRecord")
    public CommonGridResult queryAJRecord(TGrgzltj tGrgzltj){
        return checkTaskService.queryAJRecord(tGrgzltj);
    }

}
