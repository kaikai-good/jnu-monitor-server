package com.jnu.example.db.admin.service.impl;

import com.jnu.example.db.admin.entity.RepairApplication;
import com.jnu.example.db.admin.mapper.RepairApplicationMapper;
import com.jnu.example.db.admin.service.IRepairApplicationDAO;
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
public class RepairApplicationDAO extends ServiceImpl<RepairApplicationMapper, RepairApplication> implements IRepairApplicationDAO {

}
