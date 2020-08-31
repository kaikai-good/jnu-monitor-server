package com.jnu.example.base.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jnu.example.base.service.IResourceService;
import com.jnu.example.core.pojo.AdvanceQueryConditionRemoteDTO;
import com.jnu.example.core.pojo.PageData;
import com.jnu.example.core.util.JnuMybatisPlusPageUtil;
import com.jnu.example.core.util.JnuWrappersUtil;
import com.jnu.example.db.base.entity.Resources;
import com.jnu.example.db.base.service.impl.ResourcesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: HAIBO
 * @date: 2020-08-29 19:57
 * @description: TODO
 */
@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    ResourcesDAO resourcesDAO;

    @Override
    public Resources insertResources(Resources resources) {
        resourcesDAO.save(resources);
        return resources;
    }

    @Override
    public Boolean deleteResources(String id) {
        return resourcesDAO.removeById(id);
    }

    @Override
    public Resources updateResources(Resources resources) {
        resourcesDAO.updateById(resources);
        return resources;
    }

    @Override
    public PageData<Resources> getResources(Long current, Long pageSize, Boolean all, List<AdvanceQueryConditionRemoteDTO> advanceQueryConditionDTOs) {
        //构建查询条件
        LambdaQueryWrapper<Resources> wrapper = JnuWrappersUtil.<Resources>lambdaQuery(advanceQueryConditionDTOs,Resources.class);

        //生成分页参数
        Page<Resources> page = JnuMybatisPlusPageUtil.getPage(current, pageSize, all);

        //查询
        IPage<Resources> resourcesPage = resourcesDAO.page(page, wrapper);

        //如果为空
        if(CollUtil.isEmpty(resourcesPage.getRecords())){
            return new PageData<>(resourcesPage);
        }

        return new PageData<>(resourcesPage);
    }
}
