package com.jnu.example.repair.services;

import com.jnu.example.db.admin.entity.HandOver;
import com.jnu.example.db.admin.entity.RepairApplication;

import java.util.List;

/**
 * Author:kaikai
 * Date:2020/08/20 15:10
 * Description:维修交验
 */
public interface RepairHandOverService {
    HandOver saveHandOver(HandOver handOver);
    List<RepairApplication> getFinishApplication();
}
