package com.fudian.szhjg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    * 档案类型表
    */
@ApiModel(value="档案类型表  TDalxgl")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_dalxgl")
public class TDalxgl extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private String id;

    /**
     * 档案编号
     */
    @TableField(value = "dabh")
    @ApiModelProperty(value="档案编号")
    private String dabh;

    /**
     * 档案名称
     */
    @TableField(value = "damc")
    @ApiModelProperty(value="档案名称")
    private String damc;

    /**
     * 档案描述
     */
    @TableField(value = "dams")
    @ApiModelProperty(value="档案描述")
    private String dams;

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

    public static final String COL_ID = "id";

    public static final String COL_DABH = "dabh";

    public static final String COL_DAMC = "damc";

    public static final String COL_DAMS = "dams";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_REMARK = "remark";
}