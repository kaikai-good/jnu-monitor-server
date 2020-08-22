package com.jnu.example.baseinfo.controller;


import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.db.admin.entity.Resources;
import com.jnu.example.db.admin.entity.Vehicle;
import com.jnu.example.db.admin.service.IResourcesDAO;
import com.jnu.example.db.admin.service.IVehicleDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: HAIBO
 * @date: 2020-08-22 16:27
 * @description: TODO
 */

@Api(tags = "车辆信息")
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    IVehicleDAO vehicleDAO;

    @ApiOperation(value = "增加")
    @PostMapping("/add")
    public void add(Vehicle vehicle){
        vehicleDAO.save(vehicle);
    }

    @ApiOperation(value = "删除")
    @PostMapping("/del")
    public void del(String vehicleId){
        vehicleDAO.removeById(vehicleId);
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public void update(Vehicle vehicle){
        vehicleDAO.updateById(vehicle);
    }

    @ApiOperation(value = "根据ID查询")
    @PostMapping("/get")
    public CustomizedResponseEntity<Vehicle> get(@RequestBody String vehicleId){
        return CustomizedResponseEntity.success(vehicleDAO.getById(vehicleId));
    }
}

