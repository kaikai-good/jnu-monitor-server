package com.jnu.example.repair.controller;

import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.db.admin.entity.HandOver;
import com.jnu.example.db.admin.entity.RepairApplication;
import com.jnu.example.repair.services.impl.RepairHandOverServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author:kaikai
 * Date:2020/08/22 15:21
 * Description:交车controller
 */
@Api(tags = "交车")
@RestController
@RequestMapping("/handover")
public class HandOverController {
    @Autowired
    private RepairHandOverServiceImpl handOverService;

    @ApiOperation(value = "完成的申请")
    @GetMapping("/getApplication")
    public CustomizedResponseEntity<List<RepairApplication>> getFinishedApplication(){
        return CustomizedResponseEntity.success(handOverService.getFinishApplication());
    }

    @ApiOperation(value = "添加交车记录")
    @PostMapping("/save")
    public CustomizedResponseEntity<HandOver> saveHandOver(@ApiParam(value = "交车记录") @RequestBody HandOver handOver){
        return CustomizedResponseEntity.success(handOverService.saveHandOver(handOver));
    }
}
