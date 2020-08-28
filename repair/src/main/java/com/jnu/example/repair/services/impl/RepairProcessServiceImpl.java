package com.jnu.example.repair.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnu.example.db.admin.entity.RepairApplication;
import com.jnu.example.db.admin.entity.RepairPlan;
import com.jnu.example.db.admin.entity.Vehicle;
import com.jnu.example.db.admin.service.IRepairApplicationDAO;
import com.jnu.example.db.admin.service.IRepairPlanDAO;
import com.jnu.example.db.admin.service.IVehicleDAO;
import com.jnu.example.repair.services.RepairProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:kaikai
 * Date:2020/08/20 20:18
 * Description:维修过程进度实现
 */
@Service
public class RepairProcessServiceImpl implements RepairProcessService {

    @Autowired
    private IRepairPlanDAO repairPlanDAO;

    @Autowired
    private IVehicleDAO vehicleDAO;

    @Autowired
    private IRepairApplicationDAO repairApplicationDAO;

    /**
     * 登记开工：1代表开工
     * @param planId 开工计划id
     * @return true
     */
    @Override
    public Boolean startRepair(String planId) {
        RepairPlan repairPlan = new RepairPlan();
        repairPlan.setId(planId);
        repairPlan.setProcessStatus("1");
        repairPlanDAO.updateById(repairPlan);
        //更改车辆状态:2代表维修中
        String vehicleId = vehicleDAO.getById(repairApplicationDAO.getById(repairPlanDAO.getById(planId).getApplicationId())).getId();
        if(vehicleDAO.getById(vehicleId).getStatus().equals("1")){
            Vehicle vehicle = new Vehicle();
            vehicle.setId(vehicleId);
            vehicle.setStatus("2");
            return vehicleDAO.updateById(vehicle);
        }else{
            return true;
        }
    }

    /**
     * 登记完工：2代表完工
     * @param planId 完工计划id
     * @return true
     */
    @Override
    public Boolean finishRepair(String planId) {
        RepairPlan repairPlan = new RepairPlan();
        repairPlan.setId(planId);
        repairPlan.setProcessStatus("2");
        repairPlanDAO.updateById(repairPlan);
        String applicationId = repairPlanDAO.getById(planId).getApplicationId();
        QueryWrapper<RepairPlan> queryWrapper = new QueryWrapper<RepairPlan>()
                .eq("application_id",applicationId)
                .ne("process_status","2");

        List<RepairPlan> list = repairPlanDAO.list(queryWrapper);
        if(list.isEmpty()){//空的表示一辆车的申请下的所有计划都已经完工
            //更改车辆状态：3代表维修完成
            Vehicle vehicle = new Vehicle();
            vehicle.setId(vehicleDAO.getById(repairApplicationDAO.getById(repairPlanDAO.getById(planId)).getVehicleId()).getId());
            vehicle.setStatus("3");
            vehicleDAO.updateById(vehicle);
            //该车的此次申请完成：2表示完成
            RepairApplication repairApplication = new RepairApplication();
            repairApplication.setId(applicationId);
            repairApplication.setIsExpired(1);
            return repairApplicationDAO.updateById(repairApplication);
        }else{
             list.clear();
             return true;
        }

    }
}
