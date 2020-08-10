package com.jnu.example.db.admin.service.impl;

import com.jnu.example.db.admin.entity.RepairPlan;
import com.jnu.example.db.admin.mapper.RepairPlanMapper;
import com.jnu.example.db.admin.service.IRepairPlanDAO;
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
public class RepairPlanDAO extends ServiceImpl<RepairPlanMapper, RepairPlan> implements IRepairPlanDAO {

}
