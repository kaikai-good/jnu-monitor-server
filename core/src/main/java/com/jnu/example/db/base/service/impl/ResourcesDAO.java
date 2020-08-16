package com.jnu.example.db.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnu.example.db.base.entity.Resources;
import com.jnu.example.db.base.mapper.ResourcesMapper;
import com.jnu.example.db.base.service.IResourcesDAO;
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
