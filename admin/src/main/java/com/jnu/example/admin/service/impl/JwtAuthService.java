package com.jnu.example.admin.service.impl;


import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
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
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


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
    private IUserDAO userDAO;
    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;

    @Override
    public LoginVO login(String loginName, String password) {


        //获取用户信息
        User user = userDAO.getOne(Wrappers.<User>lambdaQuery().eq(User::getLoginName,loginName));

        if(user == null){
            throw new BusinessException(ResponseCode.USER_ACCOUNT_NOT_EXIST);
        }

        String count = strRedisTemplate.opsForValue().get(user.getLoginName());
        int countI = 0;
        if (StrUtil.isNotBlank(count)){
            try{
            countI = Integer.parseInt(count);}
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
            if (countI >= 3){
                throw new BusinessException((ResponseCode.USER_ACCOUNT_LOCKED));
            }
        }

        //密码校验
        if(!user.getPassword().equals(JnuEncryptUtil.encryptToBase64(password))){
            strRedisTemplate.opsForValue().set(user.getLoginName(), String.valueOf(countI+1),20, TimeUnit.SECONDS);
            throw new BusinessException(ResponseCode.USER_CREDENTIALS_ERROR);
        }

        //清空密码
        user.setPassword(null);

        // 创建token
        String token = JwtTokenUtil.generateToken(user.getId(), user.getLoginName());

        //创建返回实体
        LoginVO loginVO = new LoginVO();
        BeanUtils.copyProperties(user,loginVO);
        loginVO.setToken(token);
        return loginVO;
    }
}
