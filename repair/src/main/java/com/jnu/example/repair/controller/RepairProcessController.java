package com.jnu.example.repair.controller;

import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.db.admin.entity.RepairPlan;
import com.jnu.example.repair.services.impl.RepairProcessServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author:kaikai
 * Date:2020/08/22 15:07
 * Description:维修进度controller
 */
@Api(tags = "维修进度")
@RestController
@RequestMapping("/process")
public class RepairProcessController {
    @Autowired
    private RepairProcessServiceImpl repairProcessService;

    @ApiOperation(value = "开工")
    @PostMapping("/start")
    public CustomizedResponseEntity<Boolean> starRepair(@ApiParam(value = "j计划id") @RequestBody String planId){
        return CustomizedResponseEntity.success(repairProcessService.startRepair(planId));
    }

    @ApiOperation(value = "完工")
    @PostMapping("/finish")
    public CustomizedResponseEntity<Boolean> finishRepair(@ApiParam(value = "j计划id") @RequestBody String planId){
        return CustomizedResponseEntity.success(repairProcessService.finishRepair(planId));
    }

    @ApiOperation(value = "获取审核通过的计划")
    @GetMapping("/selectPlan")
    public CustomizedResponseEntity<List<RepairPlan>> selectPlan(){
        return CustomizedResponseEntity.success(repairProcessService.listPlan());
    }


}
