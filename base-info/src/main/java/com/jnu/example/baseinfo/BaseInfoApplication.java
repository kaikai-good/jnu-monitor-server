package com.jnu.example.baseinfo;

import com.jnu.example.core.annotation.CoreMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: HIBO
 * @date: 2020-08-21 16:51
 * @description:
 */
@SpringBootApplication(scanBasePackages={"com.jnu.example"})
@CoreMapperScan
@EnableDiscoveryClient
public class BaseInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseInfoApplication.class, args);
    }
}
