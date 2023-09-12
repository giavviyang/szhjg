package com.fudian.szhjg.busiservice;


import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.pojo.TBatch;
import com.fudian.szhjg.pojo.TJianji;
import com.fudian.szhjg.pojo.TTaskPiece;

import java.util.List;

public interface CommonSzhjgService {

    //项目批次选择框
    CommonResult queryProjectBatch(Integer gxId);

    //页面动态展示工序名称
    List<Object> queryDisplayGx();

    //查询档案类型名称
    List<Object> queryArchivesName(String dictType);

    //获取下一步工序
    Integer processId(String pcId,Integer gxxh);

    //案卷绑定当前操作人员
    CommonResult bindingRecipient(String nameId);


    //查询案卷下指定文件信息
    List<TJianji> taskPieceList(String ajId, String jh);

}
