package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.learning.apis")
public class StaffApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffApiServiceApplication.class, args);
    }

}