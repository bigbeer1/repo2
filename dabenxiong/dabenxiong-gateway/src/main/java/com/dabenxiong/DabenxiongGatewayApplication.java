package com.dabenxiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 一只大笨熊
 * @create 2020-02-23 7:29
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class DabenxiongGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DabenxiongGatewayApplication.class);
    }
}
