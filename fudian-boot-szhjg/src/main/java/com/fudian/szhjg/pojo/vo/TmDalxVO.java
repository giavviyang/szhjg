package com.fudian.szhjg.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fudian.szhjg.pojo.TMapperDalx;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

//字段管理中使用查询左侧树的vo类
@Data
@ApiModel(value = "关联档案类型表VO类")
public class TmDalxVO {

    @ApiModelProperty(value="档案类型id")
    private String id;

    //档案类型名称
    @ApiModelProperty(value="档案类型名称")
    private String archiveName;

    //关联档案类型表
    @ApiModelProperty(value="关联档案类型表")
    private List<TMapperDalx> dalxModelLv;

}
