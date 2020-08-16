package com.jnu.example.admin.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jnu.example.admin.service.UserService;
import com.jnu.example.core.pojo.AdvanceQueryConditionRemoteDTO;
import com.jnu.example.core.util.JnuWrappersUtil;
import com.jnu.example.db.admin.entity.User;
import com.jnu.example.db.admin.pojo.dto.UserAddRequestDTO;
import com.jnu.example.db.admin.pojo.dto.UserUpdateRequestDTO;
import com.jnu.example.db.admin.service.IUserDAO;
import com.jnu.example.core.constant.enums.ResponseCode;
import com.jnu.example.core.exception.BusinessException;
import com.jnu.example.core.pojo.PageData;
import com.jnu.example.core.util.JnuEncryptUtil;
import com.jnu.example.core.util.JnuMybatisPlusPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *  @Author: zy
 *  @Date: 2020/4/14 22:43
 *  @Description: 用户业务逻辑
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDAO userService;

    /**
     * @author: zy
     * @description: 新增用户信息
     * @date: 2020/4/14 23:38
     * @param userAddRequestDTO: 待新增的用户信息
     * @return BlogUser:
     */
    @Override
    public User insertUser(UserAddRequestDTO userAddRequestDTO) {
        //判断用户名是否存在
        if(userService.count(Wrappers.<User>lambdaQuery().eq(User::getLoginName,userAddRequestDTO.getLoginName()))>0){
            throw new BusinessException(ResponseCode.USER_ACCOUNT_ALREADY_EXIST);
        }

        //创建插入实体
        User user = new User();
        BeanUtil.copyProperties(userAddRequestDTO, user);

        String rawPassword = user.getPassword();
        user.setPassword(JnuEncryptUtil.encryptToBase64(rawPassword));

        //新增用户
        userService.save(user);
        user.setPassword(null);
        return user;
    }

    /**
     * @Description: 根据用户id删除用户
     * @Author: zy
     * @Date: 2020/5/10 18:17
     * @param userId: 用户id
     * @Return Boolean:
     * @Exception :
     */
    @Override
    public Boolean deleteUser(String userId) {
        return userService.removeById(userId);
    }

    /**
     * @Description: 更新用户信息
     * @Author: zy
     * @Date: 2020/5/10 17:47
     * @param userUpdateRequestDTO:待更新信息
     * @Return BlogUser:
     * @Exception :
     */
    @Override
    public User updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        //创建插入实体
        User user = new User();
        BeanUtil.copyProperties(userUpdateRequestDTO, user);

        String rawPassword = user.getPassword();
        if(StrUtil.isNotBlank(rawPassword)) {
            user.setPassword(JnuEncryptUtil.encryptToBase64(rawPassword));
        }

        //更新用户
        userService.updateById(user);
        user.setPassword(null);
        return user;
    }

    /**
     * @author: zy
     * @description: 分页查询  获取用户列表
     * @date: 2020/4/15 0:30
     * @param current: 页码
     * @param pageSize: 每页记录数
     * @param all: 查询所有？ 默认查询全部 如果为true，pageNum和pageSize参数无效
     * @param advanceQueryConditionDTOs: 查询条件
     * @return PageData<BlogUser>:
     */
    @Override
    public PageData<User> getUser(Long current, Long pageSize, Boolean all, List<AdvanceQueryConditionRemoteDTO> advanceQueryConditionDTOs) {
        //构建查询条件
        LambdaQueryWrapper<User> wrapper = JnuWrappersUtil.<User>lambdaQuery(advanceQueryConditionDTOs,User.class);

        //生成分页参数
        Page<User> page = JnuMybatisPlusPageUtil.getPage(current, pageSize, all);

        //查询
        IPage<User> userPage = userService.page(page, wrapper);

        //如果为空
        if(CollUtil.isEmpty(userPage.getRecords())){
            return new PageData<>(userPage);
        }

        //密码设置为NULL
        for(User user:userPage.getRecords()){
            user.setPassword(null);
        }

        return new PageData<>(userPage);
    }

}
