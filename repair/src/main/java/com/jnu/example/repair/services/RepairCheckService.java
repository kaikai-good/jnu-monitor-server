package com.jnu.example.repair.services;

import com.jnu.example.db.admin.entity.RepairPlan;

import java.util.List;

/**
 * Author:kaikai
 * Date:2020/08/20 15:05
 * Description:维修计划的审核
 */
public interface RepairCheckService {
    RepairPlan checkPass(String planId);
    RepairPlan checkReject(String planId);
    List<RepairPlan> getAllPlans();
}
