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
    * 字段元数据表
    */
@ApiModel(value="字段元数据表 TMetadata")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_metadata")
public class TMetadata extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    // @TableId(type = IdType.ASSIGN_ID)
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private String id;

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
     * 字段名称(英文)
     */
    @TableField(value = "metadata_name")
    @ApiModelProperty(value="字段名称(英文)")
    private String metadataName;

    /**
     * 字段简称
     */
    @TableField(value = "metadata_chinese")
    @ApiModelProperty(value="字段简称")
    private String metadataChinese;

    /**
     * 字段类型
     */
    @TableField(value = "metadata_type")
    @ApiModelProperty(value="字段类型")
    private String metadataType;

    /**
     * 是否是默认字段 (0是  1否)
     */
    @TableField(value = "default_field")
    @ApiModelProperty(value="是否是默认字段 (0是  1否)")
    private String defaultField;

    /**
     * 是否可以为空（0是  1否）
     */
    @TableField(value = "is_not_null")
    @ApiModelProperty(value="是否可以为空（0是  1否）")
    private String isNotNull;

    /**
     * 是否为系统内置（0系统内置无法删除，可继承引用 1用户自己创建可删除，可以、继承引用）
     */
    @TableField(value = "is_sys_built")
    @ApiModelProperty(value="是否为系统内置（0系统内置无法删除，可继承引用 1用户自己创建可删除，可以、继承引用）")
    private String isSysBuilt;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    @ApiModelProperty(value="备注")
    private String remarks;

    public static final String COL_ID = "id";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_METADATA_NAME = "metadata_name";

    public static final String COL_METADATA_CHINESE = "metadata_chinese";

    public static final String COL_METADATA_TYPE = "metadata_type";

    public static final String COL_DEFAULT_FIELD = "default_field";

    public static final String COL_IS_NOT_NULL = "is_not_null";

    public static final String COL_IS_SYS_BUILT = "is_sys_built";

    public static final String COL_REMARKS = "remarks";
}