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
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 项目表
 */
@ApiModel(value="项目表 TProject")
@Data
//@Accessors(chain = true)//开始链式
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName(value = "t_project")
public class TProject extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private String id;

    /**
     * 项目名称
     */
    @TableField(value = "project_name")
    @ApiModelProperty(value="项目名称")
    private String projectName;

    /**
     * 项目描述
     */
    @TableField(value = "project_xmms")
    @ApiModelProperty(value="项目描述")
    private String projectXmms;

    /**
     * 当前工序
     */
    @TableField(value = "dqgx")
    @ApiModelProperty(value="当前工序")
    private String dqgx;

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

    /**字段数据不存放进数据库表
     * 存放环节工序id集合
     */
    @TableField(exist = false)
    @ApiModelProperty(value = "存放环节工序id集合")
    private String[] ids;

    public static final String COL_ID = "id";

    public static final String COL_PROJECT_NAME = "project_name";

    public static final String COL_PROJECT_XMMS = "project_xmms";

    public static final String COL_DQGX = "dqgx";

    public static final String COL_DALX = "dalx";

    public static final String COL_JUANSHU = "juanshu";

    public static final String COL_JIANSHU = "jianshu";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_REMARK = "remark";

    public static final String COL_BEGINDATE = "begindate";

    public static final String COL_ENDDATE = "enddate";

    public static final String COL_ISFINISHED = "isfinished";
}