package com.jnu.example.base.service;


import com.jnu.example.core.pojo.AdvanceQueryConditionRemoteDTO;
import com.jnu.example.core.pojo.PageData;
import com.jnu.example.db.base.entity.Department;
import com.jnu.example.db.base.pojo.dto.DepartmentAddRequestDTO;
import com.jnu.example.db.base.pojo.dto.DepartmentUpdateRequestDTO;

import java.util.List;

/**
 *  @Author: zy
 *  @Date: 2020/8/16 15:48
 *  @Description: 部门接口
 */
public interface IDepartmentService {
    Department insertDepartment(DepartmentAddRequestDTO addRequestDTO);
    Boolean deleteDepartment(String id);
    Department updateDepartment(DepartmentUpdateRequestDTO updateRequestDTO);
    PageData<Department> getDepartment(Long current, Long pageSize, Boolean all, List<AdvanceQueryConditionRemoteDTO> advanceQueryConditionDTOs);
}
