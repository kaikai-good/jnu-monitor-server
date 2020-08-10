package com.jnu.example.core.config.security.entity;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jnu.example.db.admin.constant.ResourceType;
import com.jnu.example.db.admin.entity.Privilege;
import com.jnu.example.db.admin.entity.RolePrivilege;
import com.jnu.example.db.admin.entity.User;
import com.jnu.example.db.admin.entity.UserRole;
import com.jnu.example.db.admin.service.IPrivilegeDAO;
import com.jnu.example.db.admin.service.IRolePrivilegeDAO;
import com.jnu.example.db.admin.service.IUserRoleDAO;
import com.jnu.example.core.util.JnuSpringContextUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: zy
 * Description: 定义满足Spirng Security规则的用户实体类
 * Date: 2020/4/15
 */
public class JwtUserDetails extends User implements UserDetails {

    private static IUserRoleDAO userRoleService;

    private static IPrivilegeDAO privilegeService;

    private static IRolePrivilegeDAO rolePrivilegeService;

    static{
        userRoleService = JnuSpringContextUtil.getBean(IUserRoleDAO.class);
        privilegeService = JnuSpringContextUtil.getBean(IPrivilegeDAO.class);
        rolePrivilegeService = JnuSpringContextUtil.getBean(IRolePrivilegeDAO.class);
    }

    public JwtUserDetails(User user){
        BeanUtil.copyProperties(user,this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //获取用户权限
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        List<Privilege> privileges = getPrivilegesByUserId(this.getId());
        if(CollUtil.isEmpty(privileges)) {
            return grantedAuthorities;
        }

        //声明用户授权
        privileges.forEach(privilege -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(privilege.getCode());
            grantedAuthorities.add(grantedAuthority);
        });
        return grantedAuthorities;
    }

    /**
     * @Author: zy
     * @Description: 根据用户id获取用户接口权限
     * @Date: 2020/8/10 15:20
     * @param userId
     * @Return List<Privilege>:
     * @Exception :
     */
    private List<Privilege> getPrivilegesByUserId(String userId){
        //获取用户关联角色
        Set<String> roleIds = userRoleService.list(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId,userId)).stream().map(UserRole::getRoleId)
                .collect(Collectors.toSet());
        if(CollUtil.isEmpty(roleIds)){
            return new ArrayList<>();
        }

        //获取角色关联权限
        Set<String> privilegeIds = rolePrivilegeService.list(Wrappers.<RolePrivilege>lambdaQuery().in(RolePrivilege::getRoleId,roleIds)).stream().map(RolePrivilege::getPrivilegeId)
                .collect(Collectors.toSet());
        if(CollUtil.isEmpty(privilegeIds)){
            return new ArrayList<>();
        }

        //获取接口权限
        return privilegeService.list(Wrappers.<Privilege>lambdaQuery().in(Privilege::getId,privilegeIds).eq(Privilege::getType, ResourceType.INTERFACE) );
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return this.getLoginName();
    }
}
