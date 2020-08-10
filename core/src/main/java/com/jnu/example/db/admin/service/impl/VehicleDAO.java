package com.jnu.example.db.admin.service.impl;

import com.jnu.example.db.admin.entity.Vehicle;
import com.jnu.example.db.admin.mapper.VehicleMapper;
import com.jnu.example.db.admin.service.IVehicleDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zy
 * @since 2020-08-10
 */
@Service
public class VehicleDAO extends ServiceImpl<VehicleMapper, Vehicle> implements IVehicleDAO {

}
