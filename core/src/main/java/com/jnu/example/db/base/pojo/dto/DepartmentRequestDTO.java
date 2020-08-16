package com.jnu.example.db.base.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 *  @Author: zy
 *  @Date: 2020/4/14 22:45
 *  @Description: 新增或者修改部门通用字段
 */
@Data
public class DepartmentRequestDTO {
    @ApiModelProperty(value = "主管领导编号")
    private String leaderId;

    @ApiModelProperty(value = "总人数")
    private Integer totalMembers;
}
