package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.szhjg.busiservice.CommonSzhjgService;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.pojo.TJuanji;
import com.fudian.szhjg.service.TJuanjiService;
import com.fudian.szhjg.templateMode.CommonTemplate;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@Api(tags = "A31  数据加工-添加任务")
@RestController
@RequestMapping("/sjjg/tjrw")
public class GxTjrwController {

    @Autowired
    private CommonSzhjgService commonSzhjgService;

    @Autowired
    private TJuanjiMapper tJuanjiMapper;
    @Autowired
    private TJuanjiService tJuanjiService;



    /**添加任务-查询任务列表
     * 2023-02-12
     * @param tJuanji
     * @return
     */
    @ApiOperation("添加任务-查询任务列表")
    @ApiOperationSupport(order = 1)
    @GetMapping("/queryTaskIdList")
    @ResponseBody
    public CommonGridResult queryTaskIdList(TJuanji tJuanji){
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
        tWrapper.and(wrapper ->wrapper.eq(TJuanji::getDqgx,"1").or().eq(TJuanji::getDqgx,"2"));
        tWrapper.and(wrapper ->wrapper.eq(TJuanji::getLqr,userName).or().eq(TJuanji::getLqr,"").or().isNull(TJuanji::getLqr));
        tWrapper.ne(TJuanji::getRwzt,"已完成");
        tWrapper.ne(TJuanji::getCataloged,"著录中");
        //排序
        tWrapper.orderByDesc(TJuanji::getRwzt).orderByAsc(TJuanji::getDqgx).orderByAsc(TJuanji::getBh);
        CommonGridResult commonGridResult = commonTemplate.list(tWrapper);
        return commonGridResult;
    }


}
