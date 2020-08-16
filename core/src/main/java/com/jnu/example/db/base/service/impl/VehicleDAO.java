package com.jnu.example.db.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnu.example.db.base.entity.Vehicle;
import com.jnu.example.db.base.mapper.VehicleMapper;
import com.jnu.example.db.base.service.IVehicleDAO;
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
