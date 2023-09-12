package com.fudian.szhjg.busiservice;

import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.pojo.TMapperOption;
import com.fudian.szhjg.pojo.vo.TmapperVO;
import com.fudian.szhjg.pojo.vo.TmetadataVO;

import java.util.List;

public interface MetadataMapperService {

    //元数据和字段管理--查询元数据字段类型
    List<Object> queryMetadataType();

    //数据字段管理--查询正则表达式列表
    List<Object> queryRegularExpressionList();



    //元数据管理--元数据重名查询
    String queryDoubleName(String type, String name, String id);



    //字段管理--查询左侧树信息
    CommonResult queryFilesTreeList();

    //字段管理--查询档案类型名称
    CommonResult queryFilesType();

    //字段管理--档案类型和级别重名查询和新增
    CommonResult queryFileAndLevelSame(String daId, String points);
    //字段管理--删除档案类型和级别
    CommonResult deleteFileAndLevelSame(String id);

    //字段管理--查询实体类字段
    CommonGridResult queryEntityClass(String type);

    //字段管理--查询元数据字段
    CommonGridResult queryMetadataFields();

    //字段管理--新增档案级别对应元数据
    CommonResult addMetadataFileLevel(TmetadataVO tmetadataVO);


    //字段管理--规则设置保存展示字段
    CommonResult saveOrDisplayField(List<TmapperVO> list);
    //字段管理--规则设置保存任务录入字段
    CommonResult saveOrInputField(List<TmapperVO> list);
    //字段管理--规则设置保存著录录入字段
    CommonResult descOrInputField(List<TmapperVO> list);

    //字段管理--规则设置字段无值设置
    CommonResult queryNoFixField(String daId, String points, String king);

    //字段管理--查询编号字段是否存在
    CommonResult queryNumberOne(String daId, String points);
    //字段管理--查询编号组成字段
    CommonGridResult queryNumberFieldList(String daId, String points, String nameId);
    //字段管理--查询编号组成字段是否存在
    CommonGridResult queryExampleFieldExists(String daId, String points);
    //字段管理--新增编号数据
    CommonResult addNumberingField(TmetadataVO tmetadataVO);


    //字段下拉框管理--查询全部元数据名称
    List<Object> queryChooseFields1();
    //字段下拉框管理--查询指定元数据名称
    List<Object> queryChooseFields2();

    // 字段下拉框管理--保存添加下拉框数据
    CommonResult addChooseFields(TMapperOption tMapperOption);

    //字段下拉框管理--批量删除数据
    CommonResult deleteChooseFields(String[] ids);

}
