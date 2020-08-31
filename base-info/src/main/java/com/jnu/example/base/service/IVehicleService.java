package com.jnu.example.base.service;

import com.jnu.example.core.pojo.AdvanceQueryConditionRemoteDTO;
import com.jnu.example.core.pojo.PageData;
import com.jnu.example.db.base.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    Vehicle insertVehicle(Vehicle vehicle);
    Boolean deleteVehicle(String id);
    Vehicle updateVehicle(Vehicle vehicle);
    PageData<Vehicle> getVehicle(Long current, Long pageSize, Boolean all, List<AdvanceQueryConditionRemoteDTO> advanceQueryConditionDTOs);
}
