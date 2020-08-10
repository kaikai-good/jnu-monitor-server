package com.jnu.example.db.admin.pojo.vo;


import com.jnu.example.db.admin.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *  @Author: zy
 *  @Date: 2020/4/19 17:32
 *  @Description: 用户登录 返回用户信息
 */
@Data
public class LoginVO extends User {
    @ApiModelProperty("token")
    private String token;
}
