package com.jnu.example.core.config.security.handler.authorization;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 *  @Author: zy
 *  @Date: 2020/4/15 23:09
 *  @Description: 权限资源管理器，获取请求的url需要的权限 为权限决策管理器提供支持
 *  1、获取当前的请求，并根据请求路径从spring security配置类中获取当前资源路径需要哪些权限
 *  2、然后将查出的需要的权限列表交给AccessDecisionManager去处理后续逻辑
 */
@Configuration
@Data
public class JwtFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    /*
     * 保存url和权限配置信息  如{"/login":"permitAll",...}
     */
    private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;

    /*
     * 获取当前请求路径在spring security配置类中配置的权限
     */
    public Collection<ConfigAttribute> getSpringSecurityConfigAttributes(HttpServletRequest request) {
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
                .entrySet()) {
            if (entry.getKey().matches(request)) {
                //如果存在"permitAll" 放行
                Collection<ConfigAttribute> attributes = entry.getValue();
                for(ConfigAttribute attribute:attributes){
                    if("permitAll".equals(attribute.toString())){
                        return new ArrayList<>();
                    }
                }
                //设置该url 需要的权限为接口权限 /url路径
                return SecurityConfig.createList(request.getRequestURI());
            }
        }
        return new ArrayList<>();
    }

    /*
     * 获取当前路径url，并根据请求路径从spring security配置类中获取当前资源路径需要哪些权限
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o)  {
        HttpServletRequest request = o instanceof FilterInvocation ? ((FilterInvocation) o).getRequest() : (HttpServletRequest)o;

        //获取当前请求路径在spring security配置类中配置的权限
        return getSpringSecurityConfigAttributes(request);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<>();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
