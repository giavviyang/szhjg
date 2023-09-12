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
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
    * 档案_案卷表
    */
@ApiModel(value="档案-案卷表  TJuanji")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_juanji")
public class TJuanji extends BaseEntity implements Serializable {
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
     * 档案类型
     */
    @TableField(value = "dalx")
    @ApiModelProperty(value="档案类型")
    private String dalx;

    /**
     * 任务状态
     */
    @TableField(value = "rwzt")
    @ApiModelProperty(value="任务状态")
    private String rwzt;

    /**
     * 当前工序
     */
    @TableField(value = "dqgx")
    @ApiModelProperty(value="当前工序")
    private Integer dqgx;

    /**
     * 是否目录著录
     */
    @TableField(value = "cataloged")
    @ApiModelProperty(value="是否著录完成(未著录/著录中/著录完成)")
    private String cataloged;

    /**
     * 领取人
     */
    @TableField(value = "lqr")
    @ApiModelProperty(value="领取人")
    private String lqr;

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
     * 任务领取时间
     */
    @TableField(value = "claim_time")
    @ApiModelProperty(value="任务领取时间")
    private Date claimTime;

    /**
     * 任务完成时间
     */
    @TableField(value = "finish_time")
    @ApiModelProperty(value="任务完成时间")
    private Date finishTime;

    /**
     * 修改意见
     */
    @TableField(value = "xgyj")
    @ApiModelProperty(value="修改意见")
    private String xgyj;

    /**
     * 档案馆代码
     */
    @TableField(value = "dagdm")
    @ApiModelProperty(value="档案馆代码")
    private String dagdm;

    /**
     * 档案馆名称
     */
    @TableField(value = "dagmc")
    @ApiModelProperty(value="档案馆名称")
    private String dagmc;

    /**
     * 编号
     */
    @TableField(value = "bh")
    @ApiModelProperty(value="编号")
    private String bh;


    @TableField(value = "field1")
    @ApiModelProperty(value="")
    private String field1;

    @TableField(value = "field2")
    @ApiModelProperty(value="")
    private String field2;

    @TableField(value = "field3")
    @ApiModelProperty(value="")
    private String field3;

    @TableField(value = "field4")
    @ApiModelProperty(value="")
    private String field4;

    @TableField(value = "field5")
    @ApiModelProperty(value="")
    private String field5;

    @TableField(value = "field6")
    @ApiModelProperty(value="")
    private String field6;

    @TableField(value = "field7")
    @ApiModelProperty(value="")
    private String field7;

    @TableField(value = "field8")
    @ApiModelProperty(value="")
    private String field8;

    @TableField(value = "field9")
    @ApiModelProperty(value="")
    private String field9;

    @TableField(value = "field10")
    @ApiModelProperty(value="")
    private String field10;

    @TableField(value = "field11")
    @ApiModelProperty(value="")
    private String field11;

    @TableField(value = "field12")
    @ApiModelProperty(value="")
    private String field12;

    @TableField(value = "field13")
    @ApiModelProperty(value="")
    private String field13;

    @TableField(value = "field14")
    @ApiModelProperty(value="")
    private String field14;

    @TableField(value = "field15")
    @ApiModelProperty(value="")
    private String field15;

    @TableField(value = "field16")
    @ApiModelProperty(value="")
    private String field16;

    @TableField(value = "field17")
    @ApiModelProperty(value="")
    private String field17;

    @TableField(value = "field18")
    @ApiModelProperty(value="")
    private String field18;

    @TableField(value = "field19")
    @ApiModelProperty(value="")
    private String field19;

    @TableField(value = "field20")
    @ApiModelProperty(value="")
    private String field20;


    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "time1")
    @ApiModelProperty(value="")
    private Date time1;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "time2")
    @ApiModelProperty(value="")
    private Date time2;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "time3")
    @ApiModelProperty(value="")
    private Date time3;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "time4")
    @ApiModelProperty(value="")
    private Date time4;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "time5")
    @ApiModelProperty(value="")
    private Date time5;


    @TableField(value = "int_1")
    @ApiModelProperty(value="")
    private Integer int1;

    @TableField(value = "int_2")
    @ApiModelProperty(value="")
    private Integer int2;

    @TableField(value = "int_3")
    @ApiModelProperty(value="")
    private Integer int3;

    @TableField(value = "int_4")
    @ApiModelProperty(value="")
    private Integer int4;

    @TableField(value = "int_5")
    @ApiModelProperty(value="")
    private Integer int5;


    //批量添加(新增)
    @ApiModelProperty(value="起始")
    @TableField(exist = false)
    private String startNumber;
    @ApiModelProperty(value="终止")
    @TableField(exist = false)
    private String terminateNumber;

    @ApiModelProperty(value="案卷总件数")
    @TableField(exist = false)
    private Integer fileCount;



    public static final String COL_ID = "id";

    public static final String COL_PC_ID = "pc_id";

    public static final String COL_DALX = "dalx";

    public static final String COL_RWZT = "rwzt";

    public static final String COL_DQGX = "dqgx";

    public static final String COL_CATALOGED = "cataloged";

    public static final String COL_LQR = "lqr";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CLAIM_TIME = "claim_time";

    public static final String COL_FINISH_TIME = "finish_time";

    public static final String COL_XGYJ = "xgyj";

    public static final String COL_DAGDM = "dagdm";

    public static final String COL_DAGMC = "dagmc";

    public static final String COL_BH = "bh";

    public static final String COL_FIELD1 = "field1";

    public static final String COL_FIELD2 = "field2";

    public static final String COL_FIELD3 = "field3";

    public static final String COL_FIELD4 = "field4";

    public static final String COL_FIELD5 = "field5";

    public static final String COL_FIELD6 = "field6";

    public static final String COL_FIELD7 = "field7";

    public static final String COL_FIELD8 = "field8";

    public static final String COL_FIELD9 = "field9";

    public static final String COL_FIELD10 = "field10";

    public static final String COL_FIELD11 = "field11";

    public static final String COL_FIELD12 = "field12";

    public static final String COL_FIELD13 = "field13";

    public static final String COL_FIELD14 = "field14";

    public static final String COL_FIELD15 = "field15";

    public static final String COL_FIELD16 = "field16";

    public static final String COL_FIELD17 = "field17";

    public static final String COL_FIELD18 = "field18";

    public static final String COL_FIELD19 = "field19";

    public static final String COL_FIELD20 = "field20";

    public static final String COL_TIME1 = "time1";

    public static final String COL_TIME2 = "time2";

    public static final String COL_TIME3 = "time3";

    public static final String COL_TIME4 = "time4";

    public static final String COL_TIME5 = "time5";

    public static final String COL_INT_1 = "int_1";

    public static final String COL_INT_2 = "int_2";

    public static final String COL_INT_3 = "int_3";

    public static final String COL_INT_4 = "int_4";

    public static final String COL_INT_5 = "int_5";


    //根据字段名获取字段值
    public Object getFieldValue(String fieldName) {
        try {
            Field field = TJuanji.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(this);
            if (value != null && fieldName.contains("time")) {
                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                value = outputFormat.format((Date) value);
            }
            return value != null ? value.toString() : "";
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

}
