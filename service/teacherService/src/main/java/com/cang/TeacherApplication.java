package com.cang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.cang.dao")
@EnableFeignClients
@EnableDiscoveryClient
public class TeacherApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeacherApplication.class);
    }
}
