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
    * 档案类型对应元数据字段设置表
    */
@ApiModel(value="档案类型对应元数据字段设置表 TMapper")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_mapper")
public class TMapper extends BaseEntity implements Serializable {
    /**
     * 主键
     */
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
     * 档案类型id
     */
    @TableField(value = "da_id")
    @ApiModelProperty(value="档案类型id")
    private String daId;

    /**
     * 案卷(0)/文件(1)
     */
    @TableField(value = "points")
    @ApiModelProperty(value="案卷(0)/文件(1)")
    private String points;

    /**
     * 字段名称
     */
    @TableField(value = "source_name")
    @ApiModelProperty(value="字段名称")
    private String sourceName;

    /**
     * 元数据字段id
     */
    @TableField(value = "metadata_id")
    @ApiModelProperty(value="元数据字段id")
    private String metadataId;

    /**
     * 元数据名
     */
    @TableField(value = "metadata_name")
    @ApiModelProperty(value="元数据名")
    private String metadataName;

    /**
     * 字段类型
     */
    @TableField(value = "metadata_type")
    @ApiModelProperty(value="字段类型")
    private String metadataType;

    /**
     * 录入方式
     */
    @TableField(value = "metadata_mode")
    @ApiModelProperty(value="录入方式")
    private String metadataMode;

    /**
     * 字段长度
     */
    @TableField(value = "metadata_length")
    @ApiModelProperty(value="字段长度")
    private String metadataLength;

    /**
     * 正则验证
     */
    @TableField(value = "metadata_regular")
    @ApiModelProperty(value="正则验证")
    private String metadataRegular;

    /**
     * 是否为空
     */
    @TableField(value = "is_not_null")
    @ApiModelProperty(value="是否为空")
    private String isNotNull;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 展示设置
     */
    @TableField(value = "display_set")
    @ApiModelProperty(value="展示设置")
    private String displaySet;

    /**
     * 展示排序
     */
    @TableField(value = "display_sort")
    @ApiModelProperty(value="展示排序")
    private Integer displaySort;

    /**
     * 页面展示宽度
     */
    @TableField(value = "display_width")
    @ApiModelProperty(value="页面展示宽度")
    private Integer displayWidth;


    /**
     * 录入设置
     */
    @TableField(value = "enter_set")
    @ApiModelProperty(value="录入设置")
    private String enterSet;

    /**
     * 录入排序
     */
    @TableField(value = "enter_sort")
    @ApiModelProperty(value="录入排序")
    private Integer enterSort;

    /**
     * 著录设置
     */
    @TableField(value = "description_set")
    @ApiModelProperty(value="著录设置")
    private String descriptionSet;

    /**
     * 著录排序
     */
    @TableField(value = "description_sort")
    @ApiModelProperty(value="著录排序")
    private Integer descriptionSort;

    /**
     * 编号设置(0:默认值 ,1:编号主体 ,2:编号组成 )
     */
    @TableField(value = "ber_set")
    @ApiModelProperty(value="编号设置(0:默认值 ,1:编号主体 ,2:编号组成 )")
    private String berSet;

    /**
     * 编号排序
     */
    @TableField(value = "ber_sort")
    @ApiModelProperty(value="编号排序")
    private Integer berSort;

    /**
     * 是否允许批量添加任务(是/否)
     */
    @TableField(value = "bulk_add")
    @ApiModelProperty(value="是否允许批量添加任务(是/否)")
    private String bulkAdd;

    /**
     * 批量添加字段
     */
    @TableField(value = "bulk_field")
    @ApiModelProperty(value="批量添加字段")
    private String bulkField;



    public TMapper(String metadataName,String sourceName) {
        this.metadataName = metadataName;
        this.sourceName = sourceName;
    }

    public static final String COL_ID = "id";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_DA_ID = "da_id";

    public static final String COL_POINTS = "points";

    public static final String COL_SOURCE_NAME = "source_name";

    public static final String COL_METADATA_ID = "metadata_id";

    public static final String COL_METADATA_NAME = "metadata_name";

    public static final String COL_METADATA_TYPE = "metadata_type";

    public static final String COL_METADATA_MODE = "metadata_mode";

    public static final String COL_METADATA_LENGTH = "metadata_length";

    public static final String COL_IS_NOT_NULL = "is_not_null";

    public static final String COL_SORT = "sort";

    public static final String COL_DISPLAY_SET = "display_set";

    public static final String COL_DISPLAY_SORT = "display_sort";

    public static final String COL_DISPLAY_WIDTH = "display_width";

    public static final String COL_ENTER_SET = "enter_set";

    public static final String COL_ENTER_SORT = "enter_sort";

    public static final String COL_DESCRIPTION_SET = "description_set";

    public static final String COL_DESCRIPTION_SORT = "description_sort";

    public static final String COL_BER_SET = "ber_set";

    public static final String COL_BER_SORT = "ber_sort";
}
