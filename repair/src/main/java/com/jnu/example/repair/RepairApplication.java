package com.jnu.example.repair;

import com.jnu.example.core.annotation.CoreMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.jnu.example"})
@CoreMapperScan
public class RepairApplication {
    public static void main(String[] args) {
        SpringApplication.run(RepairApplication.class,args);
    }
}
