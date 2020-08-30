package com.jnu.example.admin.service;

import com.jnu.example.db.admin.pojo.vo.LoginVO;


/**
 * Author: zy
 * Description: 登录接口
 * Date: 2020/4/17
 */
public interface IJwtAuthService {
    LoginVO login(String loginName, String password);
}
