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
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
    * 档案_件级表
    */
@ApiModel(value="档案-件级表  TJianji")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_jianji")
public class TJianji extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private String id;

    /**
     * 案卷表(id)
     */
    @TableField(value = "aj_id")
    @ApiModelProperty(value="案卷表(id)")
    private String ajId;

    /**
     * 件号
     */
    @TableField(value = "jh")
    @ApiModelProperty(value="件号")
    private String jh;

    /**
     * 开始页数
     */
    @TableField(value = "ksys")
    @ApiModelProperty(value="开始页数")
    private Integer ksys;

    /**
     * 终止页数
     */
    @TableField(value = "zzys")
    @ApiModelProperty(value="终止页数")
    private Integer zzys;

    /**
     * 页码
     */
    @TableField(value = "ym")
    @ApiModelProperty(value="页码")
    private Integer ym;

    /**
     * 页数
     */
    @TableField(value = "ys")
    @ApiModelProperty(value="页数")
    private Integer ys;

    /**
     * 是否首页
     */
    @TableField(value = "sfsy")
    @ApiModelProperty(value="是否首页")
    private String sfsy;

    /**
     * 图片地址
     */
    @TableField(value = "tpdz")
    @ApiModelProperty(value="图片地址")
    private String tpdz;

    /**
     * 修改意见
     */
    @TableField(value = "xgyj")
    @ApiModelProperty(value="修改意见")
    private String xgyj;

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

    @TableField(value = "field21")
    @ApiModelProperty(value="")
    private String field21;

    @TableField(value = "field22")
    @ApiModelProperty(value="")
    private String field22;

    @TableField(value = "field23")
    @ApiModelProperty(value="")
    private String field23;

    @TableField(value = "field24")
    @ApiModelProperty(value="")
    private String field24;

    @TableField(value = "field25")
    @ApiModelProperty(value="")
    private String field25;

    @TableField(value = "field26")
    @ApiModelProperty(value="")
    private String field26;

    @TableField(value = "field27")
    @ApiModelProperty(value="")
    private String field27;

    @TableField(value = "field28")
    @ApiModelProperty(value="")
    private String field28;

    @TableField(value = "field29")
    @ApiModelProperty(value="")
    private String field29;

    @TableField(value = "field30")
    @ApiModelProperty(value="")
    private String field30;

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


    //代码中需要,数据库不需要
    @TableField(exist = false)
    private List<TJianji> children;

    public TJianji(String id,String ajId, String jh, Integer ksys, Integer zzys, Integer ym, Integer ys, String sfsy, String bh) {
        this.id = id;
        this.ajId = ajId;
        this.jh = jh;
        this.ksys = ksys;
        this.zzys = zzys;
        this.ym = ym;
        this.ys = ys;
        this.sfsy = sfsy;
        this.bh = bh;
    }
    public static final String COL_ID = "id";

    public static final String COL_AJ_ID = "aj_id";

    public static final String COL_JH = "jh";

    public static final String COL_KSYS = "ksys";

    public static final String COL_ZZYS = "zzys";

    public static final String COL_YM = "ym";

    public static final String COL_YS = "ys";

    public static final String COL_SFSY = "sfsy";

    public static final String COL_TPDZ = "tpdz";

    public static final String COL_XGYJ = "xgyj";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

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

    public static final String COL_FIELD21 = "field21";

    public static final String COL_FIELD22 = "field22";

    public static final String COL_FIELD23 = "field23";

    public static final String COL_FIELD24 = "field24";

    public static final String COL_FIELD25 = "field25";

    public static final String COL_FIELD26 = "field26";

    public static final String COL_FIELD27 = "field27";

    public static final String COL_FIELD28 = "field28";

    public static final String COL_FIELD29 = "field29";

    public static final String COL_FIELD30 = "field30";

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
            Field field = TJianji.class.getDeclaredField(fieldName);
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
