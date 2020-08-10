package com.jnu.example.db.admin.service.impl;

import com.jnu.example.db.admin.entity.Role;
import com.jnu.example.db.admin.mapper.RoleMapper;
import com.jnu.example.db.admin.service.IRoleDAO;
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
public class RoleDAO extends ServiceImpl<RoleMapper, Role> implements IRoleDAO {

}
