package com.feimang.month;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.feimang.month.dao")
//@EnableDiscoveryClient
//@EnableFeignClients

public class MonthApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(
                MonthApplication.class)
                .web(true).run(args);
        // SpringApplication.run(UserApplication.class,args);
        //SpringBootApplication.run
        // SpringApplication.run(DemoApplication.class, args);

    }

    @GetMapping("/hello")
    public String hello() {
        return "hello month server";
    }
}
