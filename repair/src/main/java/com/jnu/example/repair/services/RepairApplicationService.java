package com.jnu.example.repair.services;

import com.jnu.example.db.admin.entity.RepairApplication;

import java.util.List;

public interface RepairApplicationService {
    RepairApplication insertRepairApplication(RepairApplication repairApplication);
    Boolean deleteRepairApplication(String repairApplicationId);
    RepairApplication applyRepairApplication(String applyId);
    List<RepairApplication> getListApplication();
    RepairApplication saveChange(RepairApplication repairApplication);
}
