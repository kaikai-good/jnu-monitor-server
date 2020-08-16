package com.jnu.example.admin.controller;

import com.jnu.example.core.pojo.PageRequestDTO;
import com.jnu.example.db.admin.entity.User;
import com.jnu.example.admin.service.impl.UserService;
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
    private UserService userService;

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
    @PostMapping("/list")
    public CustomizedPageResponseEntity<User> getUserList(@ApiParam("分页查询") @Valid @RequestBody PageRequestDTO pageRequestDTO){
        return CustomizedPageResponseEntity.success(userService.getUser(pageRequestDTO.getPageNum(),
                pageRequestDTO.getPageSize(),pageRequestDTO.getAll(),pageRequestDTO.getConditions()));
    }
}
