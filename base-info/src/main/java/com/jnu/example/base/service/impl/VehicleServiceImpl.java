package com.jnu.example.base.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jnu.example.base.service.IVehicleService;
import com.jnu.example.core.pojo.AdvanceQueryConditionRemoteDTO;
import com.jnu.example.core.pojo.PageData;
import com.jnu.example.core.util.JnuMybatisPlusPageUtil;
import com.jnu.example.core.util.JnuWrappersUtil;
import com.jnu.example.db.base.entity.Vehicle;
import com.jnu.example.db.base.service.impl.VehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: HAIBO
 * @date: 2020-08-29 20:13
 * @description:
 */
@Service
public class VehicleServiceImpl implements IVehicleService {
    @Autowired
    VehicleDAO vehicleDAO;


    @Override
    public Vehicle insertVehicle(Vehicle vehicle) {
        vehicleDAO.save(vehicle);
        return vehicle;
    }

    @Override
    public Boolean deleteVehicle(String id) {

        return vehicleDAO.removeById(id);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        vehicleDAO.updateById(vehicle);
        return vehicle;
    }

    @Override
    public PageData<Vehicle> getVehicle(Long current, Long pageSize, Boolean all, List<AdvanceQueryConditionRemoteDTO> advanceQueryConditionDTOs) {
        //构建查询条件
        LambdaQueryWrapper<Vehicle> wrapper = JnuWrappersUtil.<Vehicle>lambdaQuery(advanceQueryConditionDTOs,Vehicle.class);

        //生成分页参数
        Page<Vehicle> page = JnuMybatisPlusPageUtil.getPage(current, pageSize, all);

        //查询
        IPage<Vehicle> vehiclePage = vehicleDAO.page(page, wrapper);

        //如果为空
        if(CollUtil.isEmpty(vehiclePage.getRecords())){
            return new PageData<>(vehiclePage);
        }

        return new PageData<>(vehiclePage);
    }
}
