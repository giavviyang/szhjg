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
    * 工序环节表
    */
@ApiModel(value="工序环节管理表  TGxhjgl")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_gxhjgl")
public class TGxhjgl extends BaseEntity implements Serializable{
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private String id;

    /**
     * 工序名称
     */
    @TableField(value = "gxmc")
    @ApiModelProperty(value="工序名称")
    private String gxmc;

    /**
     * 工序编号
     */
    @TableField(value = "gxxh")
    @ApiModelProperty(value="工序编号")
    private Integer gxxh;

    /**
     * 工序描述
     */
    @TableField(value = "gxms")
    @ApiModelProperty(value="工序描述")
    private String gxms;

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
     * 状态 ( 0:启用  1:停用)
     */
    @TableField(value = "state")
    @ApiModelProperty(value="状态 ( 0:启用  1:停用)")
    private String state;

    public static final String COL_ID = "id";

    public static final String COL_GXMC = "gxmc";

    public static final String COL_GXXH = "gxxh";

    public static final String COL_GXMS = "gxms";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_STATE = "state";

}