package com.jnu.example.core.annotation;

import org.mybatis.spring.annotation.MapperScan;

import java.lang.annotation.*;


/**
 *  @Author: zy
 *  @Date: 2020/4/14 22:23
 *  @Description:配置 MapperScan 注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@MapperScan(basePackages = "com.jnu.example.db.**.mapper")
public @interface CoreMapperScan {
}
