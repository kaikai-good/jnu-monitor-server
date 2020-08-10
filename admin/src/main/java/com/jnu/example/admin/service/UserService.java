package com.jnu.example.admin.service;


import com.jnu.example.db.admin.entity.User;
import com.jnu.example.db.admin.pojo.dto.UserAddRequestDTO;
import com.jnu.example.db.admin.pojo.dto.UserUpdateRequestDTO;
import com.jnu.example.core.pojo.PageData;


/**
 *  @Author: zy
 *  @Date: 2020/4/14 22:43
 *  @Description: 用户接口
 */
public interface UserService {
    User insertUser(UserAddRequestDTO userAddRequestDTO);
    Boolean deleteUser(String userId);
    User updateUser(UserUpdateRequestDTO userUpdateRequestDTO);
    PageData<User> getUserList(Long current, Long pageSize, Boolean all, String loginName);
}
