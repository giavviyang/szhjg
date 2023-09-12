package com.fudian.szhjg.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "字段规则设置编号组成VO类")
public class TmaBerVO {

    @ApiModelProperty(value="主键")
    private String id;

    @ApiModelProperty(value="元数据字段id")
    private String metadataId;

    @ApiModelProperty(value="元数据名")
    private String metadataName;

    @ApiModelProperty(value="字段名称")
    private String sourceName;

    @ApiModelProperty(value="排序")
    private Integer fieldOrder;

}
