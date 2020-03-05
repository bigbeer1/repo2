package com.dabenxiong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 解决跨域问题
 * @author 一只大笨熊
 * @create 2020-01-25 14:01
 */

@Configuration
public class DabenxiongCorsConfiguration {



    @Bean
    public CorsFilter corsFilter(){

        //初始化配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许跨域的域名，可以设置多个.  *代表所有域名， 如果要携带 cookie， 一定不能设置为*
        corsConfiguration.addAllowedOrigin("http://localhost:6005");
        //允许携带cookies
        corsConfiguration.setAllowCredentials(true);
        //允许所有请求方式跨域访问
        corsConfiguration.addAllowedMethod("*");
        //允许携带所有头信息跨域访问
        corsConfiguration.addAllowedHeader("*");

        //初始化配置源对象
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        // 拦截所有请求,校验是否允许跨域
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        //返回 corsFilter实例,参数: cors配置源对象
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
