package com.fudian.szhjg.busiservice;

import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.pojo.TJuanji;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

//任务方法
public interface TaskService {

    //获取批次档案类型
    String getOneTask(String pcId);

    //查询编号组成字段信息
    CommonResult queryNumberedComposition(String batchNameId);

    //excel案卷(任务)导入
    CommonResult excelFileImport(MultipartFile[] multipartFiles, String batchId,Integer gxxh);
    //excel案件(文件)导入
    CommonResult importDataPiece(MultipartFile[] multipartFiles, String batchId,Integer gxxh);

    //批量添加(新增)任务
    CommonResult insertBatchAdd(TJuanji tJuanji);

    //下载-导入模板-查询字段列表
    List<String> headerNameList(String batchId, String pointsId);





    /*//查询人事档案分类
    List<Object> queryDictType();
    //著录--案件著录查询人事档案分类类号
    String casePersonnelClass(String ajId, String clfl);*/

}
