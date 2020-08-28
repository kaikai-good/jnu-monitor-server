package com.jnu.example.repair.controller;

import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.db.admin.entity.RepairApplication;
import com.jnu.example.repair.services.impl.RepairApplicationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "维修申请")
@RestController
@RequestMapping("/apply")
public class RepairApplicationController {

    @Autowired
    private RepairApplicationServiceImpl repairApplicationService;

    @ApiOperation(value = "新增维修申请")
    @PostMapping("/add")
    public CustomizedResponseEntity<RepairApplication> inserRepairApplication(@ApiParam(value = "维修申请",required = true) @RequestBody RepairApplication repairApplication){
        return CustomizedResponseEntity.success(repairApplicationService.insertRepairApplication(repairApplication));
    }

    @ApiOperation(value = "提交申请")
    @PostMapping("/apply")
    public CustomizedResponseEntity<RepairApplication> apply(@ApiParam(value = "申请id") @RequestBody String applyId){
        return CustomizedResponseEntity.success(repairApplicationService.applyRepairApplication(applyId));
    }

    @ApiOperation(value = "根据申请id删除申请记录")
    @PostMapping("/delete")
    public CustomizedResponseEntity<Boolean> deleteRepairApplication(@ApiParam(value = "ID",required = true) @RequestBody String id){
        return CustomizedResponseEntity.success(repairApplicationService.deleteRepairApplication(id));
    }

    @ApiOperation(value = "查询保存未提交的申请")
    @GetMapping("/getList")
    public CustomizedResponseEntity<List<RepairApplication>> getListApplication(){
        return CustomizedResponseEntity.success(repairApplicationService.getListApplication());
    }

    @ApiOperation(value = "修改申请")
    @PostMapping("/update")
    public CustomizedResponseEntity<RepairApplication> saveChange(@ApiParam(value = "保存修改") @RequestBody RepairApplication repairApplication){
        return CustomizedResponseEntity.success(repairApplicationService.saveChange(repairApplication));
    }


}
