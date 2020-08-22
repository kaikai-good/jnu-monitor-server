package com.jnu.example.baseinfo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.db.admin.entity.Department;
import com.jnu.example.db.admin.entity.Resources;
import com.jnu.example.db.admin.service.IDepartmentDAO;
import com.jnu.example.db.admin.service.IResourcesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zy
 * @since 2020-08-10
 */
@RestController
@RequestMapping("/resources")
public class ResourcesController {
    @Autowired
    IResourcesDAO resourcesDAO;


    @PostMapping("/add")
    public void add(Resources resources){
        resourcesDAO.save(resources);
    }

    @PostMapping("/del")
    public void del(String resourcesId){
        resourcesDAO.removeById(resourcesId);
    }

    @PostMapping("/update")
    public void update(Resources resources){
        resourcesDAO.updateById(resources);
    }

    @PostMapping("/get")
    public CustomizedResponseEntity<Resources> get(String resourcesId){
        QueryWrapper<Resources> queryWrapper = new QueryWrapper<Resources>();
        List<Resources> list = resourcesDAO.list(queryWrapper);
        return CustomizedResponseEntity.success(resourcesDAO.getById(resourcesId));
    }
}

