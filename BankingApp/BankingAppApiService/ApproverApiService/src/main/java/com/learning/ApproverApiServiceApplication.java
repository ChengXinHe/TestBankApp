package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.learning.apis")
public class ApproverApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApproverApiServiceApplication.class, args);
    }

}