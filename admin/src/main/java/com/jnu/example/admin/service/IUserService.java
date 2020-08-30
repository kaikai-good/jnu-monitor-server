package com.jnu.example.admin.service;


import com.jnu.example.core.pojo.AdvanceQueryConditionRemoteDTO;
import com.jnu.example.db.admin.entity.User;
import com.jnu.example.db.admin.pojo.dto.UserAddRequestDTO;
import com.jnu.example.db.admin.pojo.dto.UserUpdateRequestDTO;
import com.jnu.example.core.pojo.PageData;

import java.util.List;


/**
 *  @Author: zy
 *  @Date: 2020/4/14 22:43
 *  @Description: 用户接口
 */
public interface IUserService {
    User insertUser(UserAddRequestDTO addRequestDTO);
    Boolean deleteUser(String id);
    User updateUser(UserUpdateRequestDTO updateRequestDTO);
    PageData<User> getUser(Long current, Long pageSize, Boolean all, List<AdvanceQueryConditionRemoteDTO> advanceQueryConditionDTOs);
}
