package com.fudian.szhjg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fudian.common.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
    * 项目工序关联表
    */
@ApiModel(value="项目工序关联表 TProjectGxhj")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_project_gxhj")
public class TProjectGxhj extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 工序id
     */
    @TableField(value = "gx_id")
    @ApiModelProperty(value="工序id")
    private String gxId;

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
     * 项目id
     */
    @TableField(value = "project_id")
    @ApiModelProperty(value="项目id")
    private String projectId;

    public static final String COL_ID = "id";

    public static final String COL_GX_ID = "gx_id";

    public static final String COL_GXMC = "gxmc";

    public static final String COL_GXXH = "gxxh";

    public static final String COL_PROJECT_ID = "project_id";
}