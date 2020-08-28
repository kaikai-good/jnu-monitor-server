package com.jnu.example.repair.services;

/**
 * Author:kaikai
 * Date:2020/08/20 15:09
 * Description:维修过程进度
 */
public interface RepairProcessService {
    Boolean startRepair(String planId);
    Boolean finishRepair(String planId);
}
