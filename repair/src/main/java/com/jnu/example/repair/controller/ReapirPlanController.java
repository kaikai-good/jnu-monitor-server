package com.jnu.example.repair.controller;

import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.db.admin.entity.PlanResources;
import com.jnu.example.db.admin.entity.RepairApplication;
import com.jnu.example.db.admin.entity.RepairPlan;
import com.jnu.example.repair.services.impl.RepairPlanServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:维修计划controller
 * Author:kaikai
 * Date:2020/08/20 14:50
 */
@RequestMapping("/plan")
@Api(tags = "维修计划")
@RestController
public class ReapirPlanController {
    @Autowired
    private RepairPlanServiceImpl repairPlanService;

    @ApiOperation(value = "新增维修计划")
    @PostMapping("/add")
    public CustomizedResponseEntity<RepairPlan> addRepairPlan(@ApiParam(value = "维修计划",required = true) @RequestBody RepairPlan repairPlan){
        return CustomizedResponseEntity.success(repairPlanService.insertRepairPlan(repairPlan));
    }

    @ApiOperation(value = "添加维修资源")
    @PostMapping("/addResource")
    public CustomizedResponseEntity<PlanResources> addResource(@ApiParam(value = "维修资源") @RequestBody PlanResources planResources){
        return CustomizedResponseEntity.success(repairPlanService.addResource(planResources));
    }

    @ApiOperation(value = "查询已提交的申请")
    @GetMapping("/getApply")
    public CustomizedResponseEntity<List<RepairApplication>> getApply(){
        return CustomizedResponseEntity.success(repairPlanService.getApplication());
    }

    @ApiOperation(value = "删除计划")
    @PostMapping("/delete")
    public CustomizedResponseEntity<Boolean> deletePlan(@ApiParam(value = "Id") @RequestBody String planId){
        return CustomizedResponseEntity.success(repairPlanService.deletetRepairPlan(planId));
    }

    @ApiOperation(value = "提交计划")
    @PostMapping("/submit")
    public CustomizedResponseEntity<RepairPlan> submitPlan(@ApiParam(value = "计划id") @RequestBody String planId){
        return CustomizedResponseEntity.success(repairPlanService.submitPlan(planId));
    }
}
