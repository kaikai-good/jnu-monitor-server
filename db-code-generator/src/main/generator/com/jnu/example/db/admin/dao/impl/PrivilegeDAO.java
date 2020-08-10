package com.jnu.example.db.admin.service.impl;

import com.jnu.example.db.admin.entity.Privilege;
import com.jnu.example.db.admin.mapper.PrivilegeMapper;
import com.jnu.example.db.admin.service.IPrivilegeDAO;
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
public class PrivilegeDAO extends ServiceImpl<PrivilegeMapper, Privilege> implements IPrivilegeDAO {

}
