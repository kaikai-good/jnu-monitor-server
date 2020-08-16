package com.jnu.example.remote;


import com.jnu.example.core.pojo.CustomizedResponseEntity;
import com.jnu.example.db.base.entity.Department;
import com.jnu.example.db.base.pojo.dto.DepartmentAddRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  @Author: zy
 *  @Date: 2020/8/16 17:18
 *  @Description: 部门远程服务接口
 */
@FeignClient(name = "base")
@RequestMapping("/department")
public interface DeparmentService {
    @PostMapping("/add")
    CustomizedResponseEntity<Department> insertDepartment(@RequestBody DepartmentAddRequestDTO addRequestDTO);
}
