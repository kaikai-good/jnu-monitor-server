package com.jnu.example.baseinfo.controller;


import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.db.admin.entity.Privilege;
import com.jnu.example.db.admin.entity.Vehicle;
import com.jnu.example.db.admin.service.IPrivilegeDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author: HAIBO
 * @date: 2020-08-22 16:28
 * @description: TODO
 */

@Api(tags = "权限信息")
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    IPrivilegeDAO privilegeDAO;

    @ApiOperation(value = "增加")
    @PostMapping("/add")
    public void add(Privilege privilege){
        privilegeDAO.save(privilege);
    }

    @ApiOperation(value = "删除")
    @PostMapping("/del")
    public void del(String privilegeId){
        privilegeDAO.removeById(privilegeId);
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public void update(Privilege privilege){
        privilegeDAO.updateById(privilege);
    }

    @ApiOperation(value = "根据ID查询")
    @PostMapping("/get")
    public CustomizedResponseEntity<Privilege> get(String privilegeId){
        return CustomizedResponseEntity.success(privilegeDAO.getById(privilegeId));
    }
}

