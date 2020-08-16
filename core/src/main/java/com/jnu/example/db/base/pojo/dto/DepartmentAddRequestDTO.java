package com.jnu.example.db.base.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 *  @Author: zy
 *  @Date: 2020/4/14 23:32
 *  @Description: 部门新增前端要传的json格式
 */
@Data
public class DepartmentAddRequestDTO extends DepartmentRequestDTO {
    @NotBlank(message = "部门名称不能为空")
    @ApiModelProperty(value = "部门名称")
    private String name;

    @NotBlank(message = "所属部门编号不能为空")
    @ApiModelProperty(value = "所属部门编号")
    private String parentId;
}
