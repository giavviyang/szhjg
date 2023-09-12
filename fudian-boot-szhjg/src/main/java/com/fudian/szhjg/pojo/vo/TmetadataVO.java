package com.fudian.szhjg.pojo.vo;

import com.fudian.szhjg.pojo.TMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

//字段对应中传值档案类型, 级别, 对应字段列表
@Data
@ApiModel(value = "字段对应传值VO类")
public class TmetadataVO {

    @ApiModelProperty(value="档案类型id")
    private String daId;

    @ApiModelProperty(value="案卷(0)/文件(1)")
    private String points;

    @ApiModelProperty(value = "数据字段映射集合")
    private List<TMapper> mappingList;

    //数据字段管理设置编号时使用
    @ApiModelProperty(value="编号主字段Id")
    private String numberName;
    @ApiModelProperty(value = "编号组成集合")
    private List<TmaBerVO> numberList;

    //数据字段管理设置编号--批量添加
    @ApiModelProperty(value="是否允许批量添加")
    private String  appendPermit;
    @ApiModelProperty(value="批量添加对应字段")
    private String appendField;

}
