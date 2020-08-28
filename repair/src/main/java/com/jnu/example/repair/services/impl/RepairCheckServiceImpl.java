package com.jnu.example.repair.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnu.example.db.admin.entity.RepairPlan;
import com.jnu.example.db.admin.service.IRepairPlanDAO;
import com.jnu.example.repair.services.RepairCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:kaikai
 * Date:2020/08/20 15:26
 * Description:维修审核实现
 */
@Service
public class RepairCheckServiceImpl implements RepairCheckService {

    @Autowired
    private IRepairPlanDAO repairPlanDAO;

    /**
     * 审核通过，1代表通过
     * @param planId 待审核的维修id
     * @return 审核后的记录
     */
    @Override
    public RepairPlan checkPass(String planId) {
        RepairPlan repairPlan = new RepairPlan();
        repairPlan.setId(planId);
        repairPlan.setCheckStatus(1);
        repairPlanDAO.updateById(repairPlan);
        return repairPlanDAO.getById(planId);
    }

    /**
     * 审核驳回，2代表驳回
     * @param planId 待审核的维修id
     * @return 审核后的记录
     */
    @Override
    public RepairPlan checkReject(String planId) {
        RepairPlan repairPlan = new RepairPlan();
        repairPlan.setId(planId);
        repairPlan.setCheckStatus(2);
        repairPlanDAO.updateById(repairPlan);
        return repairPlanDAO.getById(planId);
    }

    /**
     * 获取提交的维修计划
     * @return 计划列表
     */
    @Override
    public List<RepairPlan> getAllPlans() {
        List<RepairPlan> list = repairPlanDAO.getBaseMapper().selectList(new QueryWrapper<RepairPlan>().eq("is_submitted",1));
        return list;
    }
}
