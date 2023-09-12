package com.fudian.szhjg.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "任务_件级表VO类")
public class TaskPieceVO {

    @ApiModelProperty(value="案卷id")
    private String fjId;

    @ApiModelProperty(value="档号")
    private String bh;

    @ApiModelProperty(value="件号")
    private String jh;

    @ApiModelProperty(value="分件方式")
    private String fjfs;

    @ApiModelProperty(value="输入内容")
    private Integer countPage;

    @ApiModelProperty(value="上一件号")
    private String onPiece;
    @ApiModelProperty(value="最后页号")
    private String pageNumber;



}
