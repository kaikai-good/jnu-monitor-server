package com.jnu.example.base.controller;
import com.jnu.example.base.service.impl.DepartmentService;
import com.jnu.example.core.pojo.CustomizedPageResponseEntity;
import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.core.pojo.PageRequestDTO;
import com.jnu.example.db.base.entity.Department;
import com.jnu.example.db.base.pojo.dto.DepartmentAddRequestDTO;
import com.jnu.example.db.base.pojo.dto.DepartmentUpdateRequestDTO;
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
 *  @Date: 2020/8/16 16:57
 *  @Description: 部门接口
 */
@Api(tags = "部门接口")
@RestController
@RequestMapping("/department")
@Validated
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "新增部门信息")
    @PostMapping("/add")
    public CustomizedResponseEntity<Department> insertDepartment(@ApiParam(value = "部门信息",required = true) @Valid @RequestBody DepartmentAddRequestDTO departmentAddRequestDTO){
        return CustomizedResponseEntity.success(departmentService.insertDepartment(departmentAddRequestDTO));
    }

    @ApiOperation(value = "根据部门id删除部门")
    @GetMapping("/delete")
    public CustomizedResponseEntity<Boolean> deleteDepartment(@ApiParam(value = "部门id",required = true) @NotBlank(message = "部门id不能为空") @RequestParam(value = "id") String id){
        return CustomizedResponseEntity.success(departmentService.deleteDepartment(id));
    }

    @ApiOperation(value = "更新部门信息")
    @PostMapping("/update")
    public CustomizedResponseEntity<Department> insertDepartment(@ApiParam(value = "部门信息",required = true) @Valid @RequestBody DepartmentUpdateRequestDTO departmentUpdateRequestDTO) {
        return CustomizedResponseEntity.success(departmentService.updateDepartment(departmentUpdateRequestDTO));
    }

    @ApiOperation(value = "分页获取部门信息")
    @PostMapping("/list")
    public CustomizedPageResponseEntity<Department> getDepartmentList(@ApiParam("分页查询") @Valid @RequestBody PageRequestDTO pageRequestDTO){
        return CustomizedPageResponseEntity.success(departmentService.getDepartment(pageRequestDTO.getPageNum(),
                pageRequestDTO.getPageSize(),pageRequestDTO.getAll(),pageRequestDTO.getConditions()));
    }
}
