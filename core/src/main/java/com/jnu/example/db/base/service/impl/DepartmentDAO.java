package com.jnu.example.db.base.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnu.example.db.base.entity.Department;
import com.jnu.example.db.base.mapper.DepartmentMapper;
import com.jnu.example.db.base.service.IDepartmentDAO;
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
