package com.fudian.szhjg.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fudian.szhjg.pojo.TMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@ApiModel(value = "Excel导入-VO类")
public class TMapperExcelVO extends TMapper  {


    @ApiModelProperty(value = "文件", required = true)
    @TableField(exist = false)
    private MultipartFile[] file;


    @ApiModelProperty(value = "批次id", required = true)
    @TableField(exist = false)
    private String batchId;

}
