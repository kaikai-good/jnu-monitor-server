package com.jnu.example.db.admin.service.impl;

import com.jnu.example.db.admin.entity.Resources;
import com.jnu.example.db.admin.mapper.ResourcesMapper;
import com.jnu.example.db.admin.service.IResourcesDAO;
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
public class ResourcesDAO extends ServiceImpl<ResourcesMapper, Resources> implements IResourcesDAO {

}
