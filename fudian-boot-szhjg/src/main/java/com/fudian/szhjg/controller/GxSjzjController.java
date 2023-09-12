package com.fudian.szhjg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.utils.SecurityUtils;
import com.fudian.szhjg.busiservice.FJService;
import com.fudian.szhjg.busiservice.TxImageService;
import com.fudian.szhjg.mapper.TJianjiMapper;
import com.fudian.szhjg.mapper.TJuanjiMapper;
import com.fudian.szhjg.mapper.TTaskJuanMapper;
import com.fudian.szhjg.mapper.TTaskPieceMapper;
import com.fudian.szhjg.pojo.TJianji;
import com.fudian.szhjg.pojo.TJuanji;
import com.fudian.szhjg.pojo.TTaskJuan;
import com.fudian.szhjg.pojo.TTaskPiece;
import com.fudian.szhjg.service.TJianjiService;
import com.fudian.szhjg.service.TJuanjiService;
import com.fudian.szhjg.service.TTaskJuanService;
import com.fudian.szhjg.service.TTaskPieceService;
import com.fudian.szhjg.templateMode.CommonTemplate;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "A37  数据加工-数据质检")
@RestController
@RequestMapping("/sjjg/sjzj")
public class GxSjzjController {

   @Autowired
   private TJuanjiMapper tJuanjiMapper;
   @Autowired
   private TJuanjiService tJuanjiService;

    @Autowired
    private TJianjiMapper tJianjiMapper;
    @Autowired
    private TJianjiService tJianjiService;

    @Autowired
    private TxImageService txImageService;



    /**数据质检-查询案卷信息(任务列表)
     * 2023-02-23
     * @param tJuanji
     * @return
     */
    @ApiOperation("数据质检-查询案卷信息(任务列表)")
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
        wrapper.eq(TJuanji::getDqgx,"8").eq(TJuanji::getLqr,userName).eq(TJuanji::getRwzt,"进行中");
        wrapper.ne(TJuanji::getCataloged,"著录中");
        wrapper.orderByAsc(TJuanji::getClaimTime);
        CommonGridResult commonGridResult = commonTemplate.list(wrapper);
        return commonGridResult;
    }


    /**查询案件信息
     * 2023-02-23
     * @param tJianji
     * @return
     */
    @ApiOperation("数据质检-查询案件信息")
    @ApiOperationSupport(order = 2)
    @GetMapping("/queryCasePiece")
    @ResponseBody
    public CommonGridResult queryCasePiece(TJianji tJianji){
        //查询每一件首页信息
        //CommonTemplate commonTemplate = new CommonTemplate(tJianji,tJianjiService,tJianjiMapper);
        //LambdaQueryWrapper<TJianji> wrapper = new LambdaQueryWrapper<>();
        //wrapper.eq(TJianji::getAjId,tJianji.getAjId()).eq(TJianji::getSfsy,"是");
        //wrapper.orderByAsc(TJianji::getYm);
        //CommonGridResult commonGridResult = commonTemplate.list2(wrapper);
        //查询每件下详细信息
        CommonGridResult commonGridResult = txImageService.searchCasePieceList(tJianji);
        return commonGridResult;
    }

}
