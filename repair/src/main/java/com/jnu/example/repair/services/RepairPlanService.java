package com.jnu.example.repair.services;

import com.jnu.example.db.admin.entity.PlanResources;
import com.jnu.example.db.admin.entity.RepairApplication;
import com.jnu.example.db.admin.entity.RepairPlan;

import java.util.List;

public interface RepairPlanService {
    RepairPlan insertRepairPlan(RepairPlan repairPlan);
    List<RepairApplication> getApplication();
    Boolean deletetRepairPlan(String planId);
    PlanResources addResource(PlanResources planResources);
    RepairPlan submitPlan(String planId);


}
