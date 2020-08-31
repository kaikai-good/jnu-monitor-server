package com.jnu.example.base.service;

import com.jnu.example.core.pojo.AdvanceQueryConditionRemoteDTO;
import com.jnu.example.core.pojo.PageData;
import com.jnu.example.db.base.entity.Resources;

import java.util.List;

/**
 * @author: HAIBO
 * @date: 2020-08-29 19:56
 * @description: TODO
 */
public interface IResourceService {
    Resources insertResources(Resources resources);
    Boolean deleteResources(String id);
    Resources updateResources(Resources resources);
    PageData<Resources> getResources(Long current, Long pageSize, Boolean all, List<AdvanceQueryConditionRemoteDTO> advanceQueryConditionDTOs);
}
