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
import java.util.ArrayList;
import java.util.List;

/**
    * 存放字段对应档案类型
    */
@ApiModel(value="存放档案类型下有字段的类型 TMapperDalx")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_mapper_dalx")
public class TMapperDalx extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private String id;

    /**
     * 档案类型表id
     */
    @TableField(value = "da_id")
    @ApiModelProperty(value="档案类型表id")
    private String daId;

    /**
     * 案卷(0)/文件(1)
     */
    @TableField(value = "points")
    @ApiModelProperty(value="案卷(0)/文件(1)")
    private String points;

    /**
     * 上一级id
     */
    @TableField(value = "pid")
    @ApiModelProperty(value="上一级id")
    private String pid;

    //案卷/文件级
    @TableField(exist = false)
    private String archiveName;


    public static final String COL_ID = "id";

    public static final String COL_DA_ID = "da_id";

    public static final String COL_POINTS = "points";

    public static final String COL_PID = "pid";
}