package com.jnu.example.base;

import com.jnu.example.core.annotation.CoreMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 *  @Author: zy
 *  @Date: 2020/4/14 22:40
 *  @Description: Spring Boot程序入口
 */
@SpringBootApplication(scanBasePackages={"com.jnu.example"})
@CoreMapperScan
@EnableDiscoveryClient
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
