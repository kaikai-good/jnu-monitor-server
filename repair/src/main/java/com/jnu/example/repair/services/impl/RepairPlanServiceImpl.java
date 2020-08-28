package com.jnu.example.repair.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnu.example.db.admin.entity.PlanResources;
import com.jnu.example.db.admin.entity.RepairApplication;
import com.jnu.example.db.admin.entity.RepairPlan;
import com.jnu.example.db.admin.service.IPlanResourcesDAO;
import com.jnu.example.db.admin.service.IRepairApplicationDAO;
import com.jnu.example.db.admin.service.IRepairPlanDAO;
import com.jnu.example.repair.services.RepairPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Author:kaikai
 * Date:2020/08/20 15:19
 * Description:维修计划实现
 */
@Service
public class RepairPlanServiceImpl implements RepairPlanService {

    @Autowired
    private IRepairPlanDAO repairPlanDAO;

    @Autowired
    private IRepairApplicationDAO repairApplicationDAO;

    @Autowired
    private IPlanResourcesDAO resourcesDAO;

    /**
     * 新增计划
     * @param repairPlan 计划
     * @return 计划
     */
    @Override
    public RepairPlan insertRepairPlan(RepairPlan repairPlan) {
        repairPlan.setId(UUID.randomUUID().toString().replaceAll("-",""));
        repairPlan.setCreatTime(LocalDateTime.now());
        repairPlan.setIsSubmitted(0);
        repairPlan.setCheckStatus(0);
        repairPlan.setProcessStatus("0");
        repairPlanDAO.save(repairPlan);
        return repairPlan;
    }

    /**
     * 获取提交的申请
     * @return 申请
     */
    @Override
    public List<RepairApplication> getApplication() {
        QueryWrapper<RepairApplication> queryWrapper = new QueryWrapper<RepairApplication>().eq("is_submitted",1);
        List<RepairApplication> list = repairApplicationDAO.list(queryWrapper);
        return list;
    }

    /**
     * 删除计划
     * @param planId id
     * @return true
     */
    @Override
    public Boolean deletetRepairPlan(String planId) {
        return repairPlanDAO.removeById(planId);
    }

    /**
     * 为计划添加资源
     * @param planResources 资源
     * @return 资源
     */
    @Override
    public PlanResources addResource(PlanResources planResources) {
        planResources.setId(UUID.randomUUID().toString().replaceAll("-",""));
        resourcesDAO.save(planResources);
        return planResources;
    }

    /**
     * 提交计划:1表示已经提交
     * @param planId id
     * @return 计划
     */
    @Override
    public RepairPlan submitPlan(String planId) {
        RepairPlan repairPlan = new RepairPlan();
        repairPlan.setId(planId);
        repairPlan.setIsSubmitted(1);
        repairPlanDAO.updateById(repairPlan);
        return repairPlanDAO.getById(planId);
    }
}
