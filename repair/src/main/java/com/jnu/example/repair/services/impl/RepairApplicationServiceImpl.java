package com.jnu.example.repair.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnu.example.db.admin.entity.RepairApplication;
import com.jnu.example.db.admin.entity.Vehicle;
import com.jnu.example.db.admin.service.IRepairApplicationDAO;
import com.jnu.example.db.admin.service.IVehicleDAO;
import com.jnu.example.repair.services.RepairApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class RepairApplicationServiceImpl implements RepairApplicationService {

    @Autowired
    private IRepairApplicationDAO repairApplicationDAO;

    @Autowired
    private IVehicleDAO vehicleDAO;

    /**
     * 保存修改
     * @param repairApplication 待保存
     * @return 保存
     */
    @Override
    public RepairApplication saveChange(RepairApplication repairApplication) {
        repairApplication.setUpdateTime(LocalDateTime.now());
        repairApplicationDAO.updateById(repairApplication);
        return repairApplication;
    }

    /**
     * 新增维修申请
     * @param repairApplication 申请实体
     * @return 实体
     */
    @Override
    public RepairApplication insertRepairApplication(RepairApplication repairApplication) {
        repairApplication.setId(UUID.randomUUID().toString().replaceAll("-",""));
        repairApplication.setCreateTime(LocalDateTime.now());
        repairApplication.setIsSubmitted(0);
        repairApplication.setIsExpired(0);
        repairApplicationDAO.save(repairApplication);
        return repairApplication;
    }

    /**
     * 删除维修申请记录
     * @param repairApplicationId 记录id
     * @return true or false
     */
    @Override
    public Boolean deleteRepairApplication(String repairApplicationId) {
        return repairApplicationDAO.removeById(repairApplicationId);
    }


    /**
     * 提交申请
     * @param applyId 待提交的id
     * @return 提交
     */
    @Override
    public RepairApplication applyRepairApplication(String applyId) {
        RepairApplication repairApplication = new RepairApplication();
        repairApplication.setIsSubmitted(1);
        repairApplication.setId(applyId);
        repairApplicationDAO.updateById(repairApplication);
        //更改车辆状态:1表示申请提交
        String vehicleId = repairApplicationDAO.getById(applyId).getVehicleId();
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleId);
        vehicle.setStatus("1");
        vehicleDAO.updateById(vehicle);
        return repairApplicationDAO.getById(applyId);
    }

    /**
     * 查询保存未提交的申请
     * @return 结果
     */
    @Override
    public List<RepairApplication> getListApplication() {
        QueryWrapper<RepairApplication> queryWrapper = new QueryWrapper<RepairApplication>().eq("is_submitted",0);
        List<RepairApplication> list = repairApplicationDAO.list(queryWrapper);
        return list;
    }
}
