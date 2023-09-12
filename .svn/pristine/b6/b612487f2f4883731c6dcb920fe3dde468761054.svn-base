package com.fudian.szhjg.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "统计-批次产量统计VO类")
public class CountVO {

    @ApiModelProperty(value="项目id")
    private String projectId;

    @ApiModelProperty(value="项目名称")
    private String projectName;

    @ApiModelProperty(value="批次id")
    private String batchId;

    @ApiModelProperty(value="批次名称")
    private String batchName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="开始时间")
    private Date begindate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="结束时间")
    private Date enddate;

    @ApiModelProperty(value="卷数")
    private String fileCount;

    @ApiModelProperty(value="件数")
    private String pieceCount;

    @ApiModelProperty(value="页数")
    private String pageCount;

    @ApiModelProperty(value="返工率")
    private String reworkRate;

    @ApiModelProperty(value="完成卷数")
    private String completedVolume;

    @ApiModelProperty(value="完成进度")
    private String completedProgress;

}
