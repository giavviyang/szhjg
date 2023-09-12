package com.fudian.szhjg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fudian.common.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 批次表
 */
@ApiModel(value="批次表 TBatch")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName(value = "t_batch")
public class TBatch extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private String id;

    /**
     * 批次号
     */
    @TableField(value = "pc_id")
    @ApiModelProperty(value="批次号")
    private String pcId;

    /**
     * 批次名称
     */
    @TableField(value = "pc_name")
    @ApiModelProperty(value="批次名称")
    private String pcName;

    /**
     * 项目id
     */
    @TableField(value = "project_id")
    @ApiModelProperty(value="项目id")
    private String projectId;

    /**
     * 项目名称
     */
    @TableField(value = "project_name")
    @ApiModelProperty(value="项目名称")
    private String projectName;

    /**
     * 档案类型
     */
    @TableField(value = "dalx")
    @ApiModelProperty(value="档案类型")
    private String dalx;

    /**
     * 卷数
     */
    @TableField(value = "juanshu")
    @ApiModelProperty(value="卷数")
    private String juanshu;

    /**
     * 件数
     */
    @TableField(value = "jianshu")
    @ApiModelProperty(value="件数")
    private String jianshu;

    /**
     * 批次描述
     */
    @TableField(value = "pc_ms")
    @ApiModelProperty(value="批次描述")
    private String pcMs;

    /**
     * 保存路径
     */
    @TableField(value = "prj_filepath")
    @ApiModelProperty(value="保存路径")
    private String prjFilepath;

    /**
     * 备份路径
     */
    @TableField(value = "bakpath")
    @ApiModelProperty(value="备份路径")
    private String bakpath;

    /**
     * 领取人
     */
    @TableField(value = "receive_by")
    @ApiModelProperty(value="领取人")
    private String receiveBy;

    /**
     * 领取时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "receive_time")
    @ApiModelProperty(value="领取时间")
    private Date receiveTime;

    /**
     * 领取数量
     */
    @TableField(value = "lqsl")
    @ApiModelProperty(value="领取数量")
    private String lqsl;

    /**
     * 归还人
     */
    @TableField(value = "return_by")
    @ApiModelProperty(value="归还人")
    private String returnBy;

    /**
     * 归还时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "return_time")
    @ApiModelProperty(value="归还时间")
    private Date returnTime;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value="创建人")
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value="修改人")
    private String updateBy;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time")
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "begindate")
    @ApiModelProperty(value="开始时间")
    private Date begindate;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "enddate")
    @ApiModelProperty(value="结束时间")
    private Date enddate;

    /**
     * 是否完成 ( 0:否  ,1:是 )
     */
    @TableField(value = "isfinished")
    @ApiModelProperty(value="是否完成 ( 0:否  ,1:是 )")
    private String isfinished;

    public static final String COL_ID = "id";

    public static final String COL_PC_ID = "pc_id";

    public static final String COL_PC_NAME = "pc_name";

    public static final String COL_PROJECT_ID = "project_id";

    public static final String COL_PROJECT_NAME = "project_name";

    public static final String COL_DALX = "dalx";

    public static final String COL_JUANSHU = "juanshu";

    public static final String COL_JIANSHU = "jianshu";

    public static final String COL_PC_MS = "pc_ms";

    public static final String COL_PRJ_FILEPATH = "prj_filepath";

    public static final String COL_BAKPATH = "bakpath";

    public static final String COL_RECEIVE_BY = "receive_by";

    public static final String COL_RECEIVE_TIME = "receive_time";

    public static final String COL_LQSL = "lqsl";

    public static final String COL_RETURN_BY = "return_by";

    public static final String COL_RETURN_TIME = "return_time";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_REMARK = "remark";

    public static final String COL_BEGINDATE = "begindate";

    public static final String COL_ENDDATE = "enddate";

    public static final String COL_ISFINISHED = "isfinished";
}