package com.jnu.example.base.controller;

import com.jnu.example.base.service.IVehicleService;
import com.jnu.example.core.pojo.CustomizedPageResponseEntity;
import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.core.pojo.PageRequestDTO;
import com.jnu.example.db.base.entity.Vehicle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author: HAIBO
 * @date: 2020-08-29 19:54
 * @description:
 */
@Api(tags = "车辆接口")
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    IVehicleService vehicleService;

    @ApiOperation(value = "新增车辆信息")
    @PostMapping("/add")
    public CustomizedResponseEntity<Vehicle> add(@ApiParam(value = "车辆信息") @Valid @RequestBody Vehicle vehicle){
        return CustomizedResponseEntity.success(vehicleService.insertVehicle(vehicle));
    }

    @ApiOperation(value = "根据id删除车辆")
    @GetMapping("/delete")
    public CustomizedResponseEntity<Boolean> deleteVehicle(@ApiParam(value = "车辆id",required = true) @NotBlank(message = "车辆id不能为空") @RequestParam(value = "id") String id){
        return CustomizedResponseEntity.success(vehicleService.deleteVehicle(id));
    }

    @ApiOperation(value = "更新车辆信息")
    @PostMapping("/update")
    public CustomizedResponseEntity<Vehicle> insertVehicle(@ApiParam(value = "车辆信息") @Valid @RequestBody Vehicle vehicle) {
        return CustomizedResponseEntity.success(vehicleService.updateVehicle(vehicle));
    }

    @ApiOperation(value = "分页获取车辆信息")
    @PostMapping("/list")
    public CustomizedPageResponseEntity<Vehicle> getVehicleList(@ApiParam("分页查询") @Valid @RequestBody PageRequestDTO pageRequestDTO){
        return CustomizedPageResponseEntity.success(vehicleService.getVehicle(pageRequestDTO.getPageNum(),
                pageRequestDTO.getPageSize(),pageRequestDTO.getAll(),pageRequestDTO.getConditions()));
    }
}
