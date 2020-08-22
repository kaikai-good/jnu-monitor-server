package com.jnu.example.baseinfo.controller;

import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.db.admin.entity.Department;
import com.jnu.example.db.admin.service.IDepartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: HAIBO
 * @date: 2020-08-21 19:10
 * @description: TODO
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    IDepartmentDAO departmentService;


    @PostMapping("/add")
    public void add(Department department){
        departmentService.save(department);
    }

    @PostMapping("/del")
    public void del(String departmentId){
        departmentService.removeById(departmentId);
    }

    @PostMapping("/update")
    public void update(Department department){
        departmentService.updateById(department);
    }

    @PostMapping("/get")
    public CustomizedResponseEntity<Department> get(String departmentId){
        return CustomizedResponseEntity.success(departmentService.getById(departmentId));
    }

  /*@ApiOperation(value = "获取所有部门信息")
    @GetMapping("/list")
    public CustomizedPageResponseEntity<List<Department>> list(){
        return CustomizedPageResponseEntity.success(departmentService.list());
    }*/

}

