package com.jnu.example.base.controller;

import com.jnu.example.base.service.IResourceService;
import com.jnu.example.base.service.impl.DepartmentService;
import com.jnu.example.core.pojo.CustomizedPageResponseEntity;
import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.core.pojo.PageRequestDTO;
import com.jnu.example.db.base.entity.Department;
import com.jnu.example.db.base.entity.Resources;
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
 * @author: HAIBO
 * @date: 2020-08-29 20:05
 * @description: TODO
 */
@Api(tags = "资源接口")
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    IResourceService resourceService;

    @ApiOperation(value = "新增资源信息")
    @PostMapping("/add")
    public CustomizedResponseEntity<Resources> add(@ApiParam(value = "资源信息") @Valid @RequestBody Resources resources){
        return CustomizedResponseEntity.success(resourceService.insertResources(resources));
    }

    @ApiOperation(value = "根据资源id删除资源")
    @GetMapping("/delete")
    public CustomizedResponseEntity<Boolean> delete(@ApiParam(value = "资源id",required = true) @NotBlank(message = "资源id不能为空") @RequestParam(value = "id") String id){
        return CustomizedResponseEntity.success(resourceService.deleteResources(id));
    }

    @ApiOperation(value = "更新资源信息")
    @PostMapping("/update")
    public CustomizedResponseEntity<Resources> update(@ApiParam(value = "资源信息") @Valid @RequestBody Resources resources) {
        return CustomizedResponseEntity.success(resourceService.updateResources(resources));
    }

    @ApiOperation(value = "分页获取资源信息")
    @PostMapping("/list")
    public CustomizedPageResponseEntity<Resources> getList(@ApiParam("分页查询") @Valid @RequestBody PageRequestDTO pageRequestDTO){
        return CustomizedPageResponseEntity.success(resourceService.getResources(pageRequestDTO.getPageNum(),
                pageRequestDTO.getPageSize(),pageRequestDTO.getAll(),pageRequestDTO.getConditions()));
    }
}
