package com.jnu.example.db.admin.service.impl;

import com.jnu.example.db.admin.entity.UserRole;
import com.jnu.example.db.admin.mapper.UserRoleMapper;
import com.jnu.example.db.admin.service.IUserRoleDAO;
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
public class UserRoleDAO extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleDAO {

}
