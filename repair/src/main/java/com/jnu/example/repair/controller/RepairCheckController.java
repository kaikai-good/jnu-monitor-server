package com.jnu.example.repair.controller;

import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.db.admin.entity.RepairPlan;
import com.jnu.example.repair.services.impl.RepairCheckServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author:kaikai
 * Date:2020/08/21 15:38
 * Description:维修审核controller
 */
@Api(tags = "维修审核")
@RequestMapping("/check")
@RestController
public class RepairCheckController {
    @Autowired
    private RepairCheckServiceImpl repairCheckService;

    @ApiOperation(value = "查询提交的计划")
    @GetMapping("/getPlan")
    public CustomizedResponseEntity<List<RepairPlan>> getPlans(){
        return CustomizedResponseEntity.success(repairCheckService.getAllPlans());
    }

    @ApiOperation(value = "审核通过")
    @PostMapping("/pass")
    public CustomizedResponseEntity<RepairPlan> getPass(@ApiParam(value = "计划id") @RequestBody String planId){
        return CustomizedResponseEntity.success(repairCheckService.checkPass(planId));
    }

    @ApiOperation(value = "审核驳回")
    @PostMapping("/reject")
    public CustomizedResponseEntity<RepairPlan> getReject(@ApiParam(value = "计划id") @RequestBody String planId){
        return CustomizedResponseEntity.success(repairCheckService.checkReject(planId));
    }
}
