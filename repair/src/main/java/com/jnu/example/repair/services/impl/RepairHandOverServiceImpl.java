package com.jnu.example.repair.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnu.example.db.admin.entity.HandOver;
import com.jnu.example.db.admin.entity.RepairApplication;
import com.jnu.example.db.admin.entity.Vehicle;
import com.jnu.example.db.admin.service.IHandOverDAO;
import com.jnu.example.db.admin.service.IRepairApplicationDAO;
import com.jnu.example.db.admin.service.IVehicleDAO;
import com.jnu.example.repair.services.RepairHandOverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Author:kaikai
 * Date:2020/08/20 20:38
 * Description:交车实现
 */
@Service
public class RepairHandOverServiceImpl implements RepairHandOverService {

    @Autowired
    private IHandOverDAO handOverDAO;
    @Autowired
    private IRepairApplicationDAO repairApplicationDAO;
    @Autowired
    private IVehicleDAO vehicleDAO;

    /**
     * 保存交车记录，并且修改车辆状态
     * @param handOver
     * @return
     */
    @Override
    public HandOver saveHandOver(HandOver handOver) {
        handOver.setId(UUID.randomUUID().toString().replaceAll("-",""));
        handOver.setCreateTime(LocalDateTime.now());
        handOverDAO.save(handOver);
        //更改车辆状态
        String applicationId = handOver.getApplicationId();
        Vehicle vehicle = new Vehicle();
        vehicle.setId(repairApplicationDAO.getById(applicationId).getVehicleId());
        vehicle.setStatus("0");
        vehicleDAO.updateById(vehicle);
        //设置车辆的此次申请过期
        RepairApplication repairApplication = new RepairApplication();
        repairApplication.setId(applicationId);
        repairApplication.setIsExpired(2);
        repairApplicationDAO.updateById(repairApplication);
        return handOver;
    }

    @Override
    public List<RepairApplication> getFinishApplication() {
        QueryWrapper<RepairApplication> queryWrapper = new QueryWrapper<RepairApplication>().eq("is_expired",1);
        List<RepairApplication> list = repairApplicationDAO.list(queryWrapper);
        return list;
    }
}
