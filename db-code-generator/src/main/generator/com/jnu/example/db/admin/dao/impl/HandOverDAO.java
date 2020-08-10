package com.jnu.example.db.admin.service.impl;

import com.jnu.example.db.admin.entity.HandOver;
import com.jnu.example.db.admin.mapper.HandOverMapper;
import com.jnu.example.db.admin.service.IHandOverDAO;
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
public class HandOverDAO extends ServiceImpl<HandOverMapper, HandOver> implements IHandOverDAO {

}
