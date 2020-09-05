package com.jnu.example.repair.services;

import com.jnu.example.db.admin.entity.RepairPlan;

import java.util.List;

/**
 * Author:kaikai
 * Date:2020/08/20 15:09
 * Description:维修过程进度
 */
public interface RepairProcessService {
    Boolean startRepair(String planId);
    Boolean finishRepair(String planId);
    List<RepairPlan> listPlan();
}
