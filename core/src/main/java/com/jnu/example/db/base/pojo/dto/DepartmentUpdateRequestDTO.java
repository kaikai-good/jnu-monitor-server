package com.jnu.example.db.base.pojo.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 *  @Author: zy
 *  @Date: 2020/5/10 17:34
 *  @Description:部门更新前端要传的json格式
 */
@Data
public class DepartmentUpdateRequestDTO extends DepartmentRequestDTO {
    @NotBlank(message = "部门id不能为空")
    @ApiModelProperty(value = "用户id")
    private Integer id;

    @NotBlank(message = "部门名称不能为空")
    @ApiModelProperty(value = "部门名称")
    private String name;
}
