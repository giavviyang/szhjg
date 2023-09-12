package com.fudian.szhjg.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fudian.common.annotation.Excel;
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
 * 任务_卷级表
 */
@ApiModel(value="任务_卷级表  TTaskJuan")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_task_juan")
public class TTaskJuan extends BaseEntity implements Serializable {
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
     * 项目id
     */
    @TableField(value = "project_id")
    @ApiModelProperty(value="项目id")
    private String projectId;

    /**
     * 档案类型
     */
    @TableField(value = "dalx")
    @ApiModelProperty(value="档案类型")
    private String dalx;

    /**
     * 全宗号
     */
    @Excel(name = "全宗号")
    @TableField(value = "qzh")
    @ApiModelProperty(value="全宗号")
    private String qzh;

    /**
     * 目录号
     */
    @Excel(name = "目录号")
    @TableField(value = "mlh")
    @ApiModelProperty(value="目录号")
    private String mlh;

    /**
     * 案卷号
     */
    @Excel(name = "案卷号")
    @TableField(value = "ajh")
    @ApiModelProperty(value="案卷号")
    private String ajh;

    /**
     * 档号
     */
    @Excel(name = "档号")
    @TableField(value = "dh")
    @ApiModelProperty(value="档号")
    private String dh;

    /**
     * 档号区间
     */
    @TableField(value = "dhqj")
    @ApiModelProperty(value="档号区间")
    private String dhqj;

    /**
     * 年度
     */
    @TableField(value = "nd")
    @ApiModelProperty(value="年度")
    private String nd;

    /**
     * 保管期限
     */
    @Excel(name = "保管期限")
    @TableField(value = "bgqx")
    @ApiModelProperty(value="保管期限")
    private String bgqx;

    /**
     * 原案卷号
     */
    @TableField(value = "oajh")
    @ApiModelProperty(value="原案卷号")
    private String oajh;

    /**
     * 姓名
     */
    @TableField(value = "xm")
    @ApiModelProperty(value="姓名")
    private String xm;

    /**
     * 性别
     */
    @TableField(value = "xb")
    @ApiModelProperty(value="性别")
    private String xb;

    /**
     * 民族
     */
    @TableField(value = "mz")
    @ApiModelProperty(value="民族")
    private String mz;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "csrq")
    @ApiModelProperty(value="出生日期")
    private Date csrq;

    /**
     * 证件类型
     */
    @TableField(value = "zjlx")
    @ApiModelProperty(value="证件类型")
    private String zjlx;

    /**
     * 证件号码
     */
    @TableField(value = "zjhm")
    @ApiModelProperty(value="证件号码")
    private String zjhm;

    /**
     * 参加组织时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "cjzzsj")
    @ApiModelProperty(value="参加组织时间")
    private Date cjzzsj;

    /**
     * 参加工作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "cjgzsj")
    @ApiModelProperty(value="参加工作时间")
    private Date cjgzsj;

    /**
     * 部门
     */
    @TableField(value = "bm")
    @ApiModelProperty(value="部门")
    private String bm;

    /**
     * 干部状态
     */
    @TableField(value = "gbzt")
    @ApiModelProperty(value="干部状态")
    private String gbzt;

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
     * 领取人
     */
    @TableField(value = "lqr")
    @ApiModelProperty(value="领取人")
    private String lqr;

    /**
     * 全宗名称
     */
    @Excel(name = "全宗名称")
    @TableField(value = "qzmc")
    @ApiModelProperty(value="全宗名称")
    private String qzmc;

    /**
     * 案卷题名
     */
    @Excel(name = "案卷题名")
    @TableField(value = "ajtm")
    @ApiModelProperty(value="案卷题名")
    private String ajtm;

    /**
     * 附注
     */
    @TableField(value = "fz")
    @ApiModelProperty(value="附注")
    private String fz;

    /**
     * 备考表说明
     */
    @TableField(value = "bkbsm")
    @ApiModelProperty(value="备考表说明")
    private String bkbsm;

    /**
     * 起始时间
     */
    @TableField(value = "qssj")
    @ApiModelProperty(value="起始时间")
    private String qssj;

    /**
     * 终止时间
     */
    @TableField(value = "zzsj")
    @ApiModelProperty(value="终止时间")
    private String zzsj;

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
     * 页数
     */
    @TableField(value = "ys")
    @ApiModelProperty(value="页数")
    private Integer ys;

    /**
     * 修改意见
     */
    @TableField(value = "xgyj")
    @ApiModelProperty(value="修改意见")
    private String xgyj;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value="备注")
    private String remark;

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


    @ApiModelProperty(value="起止年月")
    @TableField(exist = false)
    private String startEndDate;
    @ApiModelProperty(value="案卷总件数")
    @TableField(exist = false)
    private Integer fileCount;


    public static final String COL_ID = "id";

    public static final String COL_PC_ID = "pc_id";

    public static final String COL_PROJECT_ID = "project_id";

    public static final String COL_DALX = "dalx";

    public static final String COL_QZH = "qzh";

    public static final String COL_MLH = "mlh";

    public static final String COL_AJH = "ajh";

    public static final String COL_DH = "dh";

    public static final String COL_DHQJ = "dhqj";

    public static final String COL_ND = "nd";

    public static final String COL_BGQX = "bgqx";

    public static final String COL_OAJH = "oajh";

    public static final String COL_XM = "xm";

    public static final String COL_XB = "xb";

    public static final String COL_MZ = "mz";

    public static final String COL_CSRQ = "csrq";

    public static final String COL_ZJLX = "zjlx";

    public static final String COL_ZJHM = "zjhm";

    public static final String COL_CJZZSJ = "cjzzsj";

    public static final String COL_CJGZSJ = "cjgzsj";

    public static final String COL_BM = "bm";

    public static final String COL_GBZT = "gbzt";

    public static final String COL_RWZT = "rwzt";

    public static final String COL_DQGX = "dqgx";

    public static final String COL_LQR = "lqr";

    public static final String COL_QZMC = "qzmc";

    public static final String COL_AJTM = "ajtm";

    public static final String COL_FZ = "fz";

    public static final String COL_BKBSM = "bkbsm";

    public static final String COL_QSSJ = "qssj";

    public static final String COL_ZZSJ = "zzsj";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_DAGDM = "dagdm";

    public static final String COL_DAGMC = "dagmc";

    public static final String COL_YS = "ys";

    public static final String COL_XGYJ = "xgyj";

    public static final String COL_REMARK = "remark";

    public static final String COL_CLAIM_TIME = "claim_time";

    public static final String COL_FINISH_TIME = "finish_time";
}