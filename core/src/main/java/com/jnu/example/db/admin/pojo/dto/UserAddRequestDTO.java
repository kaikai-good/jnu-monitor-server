package com.jnu.example.db.admin.pojo.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 *  @Author: zy
 *  @Date: 2020/4/14 23:32
 *  @Description: 用户新增前端要传的json格式
 */
@Data
public class UserAddRequestDTO extends UserRequestDTO{
    @NotBlank(message = "用户登录名称不能为空")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_-]{5,17}$",
            message = "账号校验错误，允许6~18个字符，只能以字母开头，包含字母、数字和下划线")
    @ApiModelProperty(value = "用户登录名称")
    private String loginName;

    @NotBlank(message="用户登录密码不能为空")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[1-9])(?=.*[\\W]).{8,50}$",
            message = "密码长度为8-50位字符,用大写字母、小写字母、数字、符号四种中至少包含三种且必须包含数字和符号，不能与用户名重复")
    @ApiModelProperty(value = "用户登陆密码")
    private String password;
}
