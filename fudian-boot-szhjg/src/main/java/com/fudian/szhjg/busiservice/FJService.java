package com.fudian.szhjg.busiservice;

import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.pojo.TJianji;
import com.fudian.szhjg.pojo.TTaskPiece;
import com.fudian.szhjg.pojo.vo.TaskPieceVO;

public interface FJService {

    //查询分件列表
    CommonGridResult searchSubdivisionList(TJianji tJianji);

    //查询案卷中最后件号
    String finallyNumber(String fjId);
    //查询案卷中最大页码
    Integer queryMaxYm(String fjId);
    //新增分件
    CommonResult insertSubdivisionAdd(TaskPieceVO taskPieceVO);

    //加页
    CommonResult additionPage(String partJH, String aId);
    //减页
    CommonResult subtractedPage(String partJH, String aId);

    //拆件
    CommonResult disassemblePCS(String wId, String partJH, String aId);
    //合件
    CommonResult assemblyPCS(String partJH, String aId);

    //清空文件
    CommonResult emptyPCS(String aId);

}
