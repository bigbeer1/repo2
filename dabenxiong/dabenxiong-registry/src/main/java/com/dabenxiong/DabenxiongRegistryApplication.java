package com.dabenxiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 一只大笨熊
 * @create 2020-02-23 6:59
 */
@SpringBootApplication
@EnableEurekaServer
public class DabenxiongRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DabenxiongRegistryApplication.class);
    }
}
