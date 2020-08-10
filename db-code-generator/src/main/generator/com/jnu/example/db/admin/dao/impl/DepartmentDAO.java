package com.jnu.example.db.admin.service.impl;

import com.jnu.example.db.admin.entity.Department;
import com.jnu.example.db.admin.mapper.DepartmentMapper;
import com.jnu.example.db.admin.service.IDepartmentDAO;
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
public class DepartmentDAO extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentDAO {

}
