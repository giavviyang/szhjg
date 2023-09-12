package com.fudian.szhjg.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "数据加工返工原因存放VO类")
public class ReworkVO {

    @ApiModelProperty(value="任务id(案卷id)")
    private String anJuanId;

    @ApiModelProperty(value="返工id(返工工序)")
    private Integer reworkId;

    @ApiModelProperty(value="返工原因")
    private String reworkCause;

}
