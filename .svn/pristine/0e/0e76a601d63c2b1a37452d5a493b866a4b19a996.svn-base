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
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
    * 元数据字段存放下拉框表
    */
@ApiModel(value="元数据字段存放下拉框表 TMapperOption")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_mapper_option")
public class TMapperOption extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private String id;

    /**
     * 创建者
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
     * 更新者
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value="更新人")
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
     * 元数据名
     */
    @TableField(value = "metadata_name")
    @ApiModelProperty(value="元数据名")
    private String metadataName;

    /**
     * 类型（M-父节点，C-子节点）
     */
    @TableField(value = "type")
    @ApiModelProperty(value="类型（M-父节点，C-子节点）")
    private String type;

    /**
     * 排序
     */
    @TableField(value = "dict_sort")
    @ApiModelProperty(value="排序")
    private Integer dictSort;

    /**
     * 代码类型
     */
    @TableField(value = "dict_label")
    @ApiModelProperty(value="代码类型")
    private String dictLabel;

    /**
     * 代码
     */
    @TableField(value = "dict_value")
    @ApiModelProperty(value="代码")
    private String dictValue;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value="备注")
    private String remark;


    @TableField(exist = false)
    @ApiModelProperty(value = "字段下拉框数据集合")
    private List<TMapperOption> mappingOptionList;


    public static final String COL_ID = "id";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_METADATA_NAME = "metadata_name";

    public static final String COL_TYPE = "type";

    public static final String COL_DICT_SORT = "dict_sort";

    public static final String COL_DICT_LABEL = "dict_label";

    public static final String COL_DICT_VALUE = "dict_value";

    public static final String COL_REMARK = "remark";
}