package com.jnu.example.base.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jnu.example.base.service.IDepartmentService;
import com.jnu.example.core.constant.enums.ResponseCode;
import com.jnu.example.core.exception.BusinessException;
import com.jnu.example.core.pojo.AdvanceQueryConditionRemoteDTO;
import com.jnu.example.core.pojo.PageData;
import com.jnu.example.core.util.JnuMybatisPlusPageUtil;
import com.jnu.example.core.util.JnuWrappersUtil;
import com.jnu.example.db.base.entity.Department;
import com.jnu.example.db.base.pojo.dto.DepartmentAddRequestDTO;
import com.jnu.example.db.base.pojo.dto.DepartmentUpdateRequestDTO;
import com.jnu.example.db.base.service.IDepartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  @Author: zy
 *  @Date: 2020/8/16 15:48
 *  @Description: 部门接口
 */
@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentDAO departmentDAO;

    /**
     * @Author: zy
     * @Description: 新增部门信息
     * @Date: 2020/8/16 17:07
     * @param addRequestDTO: 待新增的部门信息
     * @Return Department:
     * @Exception :
     */
    @Override
    public Department insertDepartment(DepartmentAddRequestDTO addRequestDTO) {
        //判断部门名是否存在
        if(departmentDAO.count(Wrappers.<Department>lambdaQuery().eq(Department::getName,addRequestDTO.getName()))>0){
            throw new BusinessException(ResponseCode.DEPARTMENT_ALREADY_EXIST);
        }

        //创建插入实体
        Department department = new Department();
        BeanUtil.copyProperties(addRequestDTO, department);

        //新增部门
        departmentDAO.save(department);
        return department;
    }

    /**
     * @Author: zy
     * @Description: 根据id删除部门信息
     * @Date: 2020/8/16 17:08
     * @param id: 部门id
     * @Return Boolean:
     * @Exception :
     */
    @Override
    public Boolean deleteDepartment(String id) {
        return departmentDAO.removeById(id);
    }

    /**
     * @Author: zy
     * @Description: 更新部门信息
     * @Date: 2020/8/16 17:08
     * @param updateRequestDTO: 待更新的部门信息
     * @Return Department:
     * @Exception :
     */
    @Override
    public Department updateDepartment(DepartmentUpdateRequestDTO updateRequestDTO) {
        //创建插入实体
        Department department = new Department();
        BeanUtil.copyProperties(updateRequestDTO, department);

        //更新部门
        departmentDAO.updateById(department);
        return department;
    }

    /**
     * @author: zy
     * @description: 分页查询  获取部门列表
     * @date: 2020/4/15 0:30
     * @param current: 页码
     * @param pageSize: 每页记录数
     * @param all: 查询所有？ 默认查询全部 如果为true，pageNum和pageSize参数无效
     * @param advanceQueryConditionDTOs: 查询条件
     * @return PageData<Department>:
     */
    @Override
    public PageData<Department> getDepartment(Long current, Long pageSize, Boolean all, List<AdvanceQueryConditionRemoteDTO> advanceQueryConditionDTOs) {
        //构建查询条件
        LambdaQueryWrapper<Department> wrapper = JnuWrappersUtil.<Department>lambdaQuery(advanceQueryConditionDTOs,Department.class);

        //生成分页参数
        Page<Department> page = JnuMybatisPlusPageUtil.getPage(current, pageSize, all);

        //查询
        IPage<Department> departmentPage = departmentDAO.page(page, wrapper);

        //如果为空
        if(CollUtil.isEmpty(departmentPage.getRecords())){
            return new PageData<>(departmentPage);
        }

        return new PageData<>(departmentPage);
    }
}
