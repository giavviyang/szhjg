package com.fudian.szhjg.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "统计查询VO类")
public class StatisticsVO {

    @ApiModelProperty(value="用户姓名")
    private String userName;

    @ApiModelProperty(value="工序序号")
    private Integer gxXh;

    @ApiModelProperty(value="项目名称(id)")
    private String projectId;

    @ApiModelProperty(value="批次名称(id)")
    private String pcId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="起始时间")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="结束时间")
    private Date endDate;

    @ApiModelProperty(value="页容量")
    private Integer pageSize;

    @ApiModelProperty(value="当前页")
    private Integer pageNum;

}
