package com.jnu.example.db.admin.service.impl;

import com.jnu.example.db.admin.entity.User;
import com.jnu.example.db.admin.mapper.UserMapper;
import com.jnu.example.db.admin.service.IUserDAO;
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
public class UserDAO extends ServiceImpl<UserMapper, User> implements IUserDAO {

}
