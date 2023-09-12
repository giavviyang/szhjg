package com.fudian.szhjg.pojo.vo;

import com.fudian.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "案卷下文件信息导入VO类")
public class PieceImportVO {

    @Excel(name = "案卷档号")
    @ApiModelProperty(value="案卷档号")
    private String ajdh;

    @Excel(name = "全宗号")
    @ApiModelProperty(value="全宗号")
    private String qzh;

    @Excel(name = "目录号")
    @ApiModelProperty(value="目录号")
    private String mlh;

    @Excel(name = "年度")
    @ApiModelProperty(value="年度")
    private String nd;

    @Excel(name = "案卷号")
    @ApiModelProperty(value="案卷号")
    private String ajh;

    @Excel(name = "档号")
    @ApiModelProperty(value="档号")
    private String dh;

    @Excel(name = "件号")
    @ApiModelProperty(value="件号")
    private String jh;

    @Excel(name = "责任者")
    @ApiModelProperty(value="责任者")
    private String zrz;

    @Excel(name = "题名")
    @ApiModelProperty(value="题名")
    private String tm;

    @Excel(name = "附件题名")
    @ApiModelProperty(value="附件题名")
    private String fjtm;

    @Excel(name = "文件编号")
    @ApiModelProperty(value="文件编号")
    private String wjbh;

    //文件时间 == 形成时间
    @Excel(name = "文件时间")
    @ApiModelProperty(value="文件时间")
    private String xcsj;

    //人名 == 关键词
    @Excel(name = "关键词")
    @ApiModelProperty(value="关键词")
    private String gjc;

    @Excel(name = "页码")
    @ApiModelProperty(value = "页码")
    private Integer ym;

    @Excel(name = "页数")
    @ApiModelProperty(value="页数")
    private String ys;

    @Excel(name = "保管期限")
    @ApiModelProperty(value="保管期限")
    private String bgqx;

}
