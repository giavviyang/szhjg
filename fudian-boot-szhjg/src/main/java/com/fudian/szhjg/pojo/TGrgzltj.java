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
 * 个人工作量统计表
 */
@ApiModel(value="个人工作量统计表  TGrgzltj")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_grgzltj")
public class TGrgzltj extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private String id;

    /**
     * 批次号(id)
     */
    @TableField(value = "pc_id")
    @ApiModelProperty(value="批次号(id)")
    private String pcId;

    /**
     * 案卷id
     */
    @TableField(value = "aj_id")
    @ApiModelProperty(value="案卷id")
    private String ajId;

    /**
     * 提交状态 (通过/返工)
     */
    @TableField(value = "state")
    @ApiModelProperty(value="提交状态 (通过/返工)")
    private String state;

    /**
     * 用户姓名
     */
    @TableField(value = "yhxm")
    @ApiModelProperty(value="用户姓名")
    private String yhxm;

    /**
     * 加工工序
     */
    @TableField(value = "jggx")
    @ApiModelProperty(value="加工工序")
    private String jggx;

    /**
     * 编号
     */
    @TableField(value = "bh")
    @ApiModelProperty(value="编号")
    private String bh;

    /**
     * 件数
     */
    @TableField(value = "jian_shu")
    @ApiModelProperty(value="件数")
    private Integer jianShu;

    /**
     * 页数
     */
    @TableField(value = "ys")
    @ApiModelProperty(value="页数")
    private Integer ys;

    /**
     * 领取时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "claim_time")
    @ApiModelProperty(value="领取时间")
    private Date claimTime;

    /**
     * 完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "finish_time")
    @ApiModelProperty(value="完成时间")
    private Date finishTime;

    /**
     * 修改意见(返工原因)
     */
    @TableField(value = "xgyj")
    @ApiModelProperty(value="修改意见(返工原因)")
    private String xgyj;

    /**
     * 卷数
     */
    @TableField(exist=false)
    @ApiModelProperty(value="卷数")
    private String juanShu;

    public static final String COL_ID = "id";

    public static final String COL_PC_ID = "pc_id";

    public static final String COL_AJ_ID = "aj_id";

    public static final String COL_STATE = "state";

    public static final String COL_YHXM = "yhxm";

    public static final String COL_JGGX = "jggx";

    public static final String COL_BH = "bh";

    public static final String COL_JIAN_SHU = "jian_shu";

    public static final String COL_YS = "ys";

    public static final String COL_CLAIM_TIME = "claim_time";

    public static final String COL_FINISH_TIME = "finish_time";

    public static final String COL_XGYJ = "xgyj";
}