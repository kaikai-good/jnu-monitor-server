package com.jnu.example.admin.controller;

import com.jnu.example.db.admin.entity.User;
import com.jnu.example.admin.service.impl.UserServiceImpl;
import com.jnu.example.db.admin.pojo.dto.UserAddRequestDTO;
import com.jnu.example.db.admin.pojo.dto.UserUpdateRequestDTO;
import com.jnu.example.core.pojo.CustomizedPageResponseEntity;
import com.jnu.example.core.pojo.CustomizedResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 *  @Author: zy
 *  @Date: 2020/4/14 23:37
 *  @Description:用户控制器
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    @ApiOperation(value = "新增用户信息")
    @PostMapping("/add")
    public CustomizedResponseEntity<User> insertUser(@ApiParam(value = "用户信息",required = true) @Valid @RequestBody UserAddRequestDTO userAddRequestDTO){
        return CustomizedResponseEntity.success(userService.insertUser(userAddRequestDTO));
    }

    @ApiOperation(value = "根据用户id删除用户")
    @GetMapping("/delete")
    public CustomizedResponseEntity<Boolean> deleteUser(@ApiParam(value = "用户id",required = true) @NotBlank(message = "用户id不能为空") @RequestParam(value = "id") String id){
        return CustomizedResponseEntity.success(userService.deleteUser(id));
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("/update")
    public CustomizedResponseEntity<User> insertUser(@ApiParam(value = "用户信息",required = true) @Valid @RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
        return CustomizedResponseEntity.success(userService.updateUser(userUpdateRequestDTO));
    }

    @ApiOperation(value = "分页获取用户信息")
    @GetMapping("/list")
    public CustomizedPageResponseEntity<User> getUserList(@ApiParam(value = "当前页") @Positive(message = "pageNum必须是正整数") @RequestParam(value = "current",defaultValue = "1") Long current,
                                                              @ApiParam(value = "页大小") @Positive(message = "pageSize必须是正整数") @RequestParam(value = "pageSize",defaultValue = "10") Long pageSize,
                                                              @ApiParam(value = "查询全部",required = true) @RequestParam(value = "all") Boolean all,
                                                              @ApiParam(value = "登录账号") @RequestParam(value = "loginName",required = false) String loginName
                                                             ){
        return CustomizedPageResponseEntity.success(userService.getUserList(current,pageSize,all,loginName));
    }
}
