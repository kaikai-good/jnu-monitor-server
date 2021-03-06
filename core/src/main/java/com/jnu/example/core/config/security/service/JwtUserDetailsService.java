package com.jnu.example.core.config.security.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jnu.example.db.admin.entity.User;
import com.jnu.example.db.admin.service.IUserDAO;
import com.jnu.example.core.config.security.entity.JwtUserDetails;
import com.jnu.example.core.constant.enums.ResponseCode;
import com.jnu.example.core.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


/**
 * Author: zy
 * Description: 自定义用户登录认证逻辑
 * Date: 2020/4/15
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    IUserDAO userService;

    /**
     * @author: zy
     * @description: 根据用户名查询数据库获取用户信息
     * @date: 2020/4/15 15:20
     * @param username:登录用户名
     * @return UserDetails:
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        //参数校验
        if(username == null || StringUtils.isBlank(username)){
            throw new BusinessException(ResponseCode.USER_ACCOUNT_NOT_EXIST);
        }

        //根据用户名查询用户
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getLoginName,username));
        if(user == null){
            throw new BusinessException(ResponseCode.USER_ACCOUNT_NOT_EXIST);
        }

        JwtUserDetails jwtUserDetails = new JwtUserDetails(user);

        return new org.springframework.security.core.userdetails.User(
                jwtUserDetails.getUsername(),
                jwtUserDetails.getPassword(),
                jwtUserDetails.isEnabled(),
                jwtUserDetails.isAccountNonExpired(),
                jwtUserDetails.isCredentialsNonExpired(),
                jwtUserDetails.isAccountNonLocked(),
                jwtUserDetails.getAuthorities()
        );
    }
}
