package com.dabenxiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 一只大笨熊
 * @create 2020-02-23 8:01
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.dabenxiong.item.mapper")
public class DabenxiongItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(DabenxiongItemApplication.class);
    }
}
