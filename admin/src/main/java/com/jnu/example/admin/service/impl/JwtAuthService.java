package com.jnu.example.admin.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jnu.example.db.admin.service.IUserDAO;
import com.jnu.example.db.admin.entity.User;
import com.jnu.example.db.admin.pojo.vo.LoginVO;
import com.jnu.example.admin.service.IJwtAuthService;
import com.jnu.example.core.config.security.JwtTokenUtil;
import com.jnu.example.core.constant.enums.ResponseCode;
import com.jnu.example.core.exception.BusinessException;
import com.jnu.example.core.util.JnuEncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Author: zy
 * Description: 登录业务逻辑
 * Date: 2020/4/17
 */
@Service
@Slf4j
public class JwtAuthService implements IJwtAuthService {
    //获取用户信息
    @Autowired
    private IUserDAO userService;

    @Override
    public LoginVO login(String loginName, String password) {
        //获取用户信息
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getLoginName,loginName));
        if(user == null){
            throw new BusinessException(ResponseCode.USER_ACCOUNT_NOT_EXIST);
        }

        //密码校验
        if(!user.getPassword().equals(JnuEncryptUtil.encryptToBase64(password))){
            throw new BusinessException(ResponseCode.USER_CREDENTIALS_ERROR);
        }

        //清空密码
        user.setPassword(null);

        // 创建token
        String token = JwtTokenUtil.generateToken(user.getId(), user.getName());

        //创建返回实体
        LoginVO loginVO = new LoginVO();
        BeanUtils.copyProperties(user,loginVO);
        loginVO.setToken(token);
        return loginVO;
    }

}
