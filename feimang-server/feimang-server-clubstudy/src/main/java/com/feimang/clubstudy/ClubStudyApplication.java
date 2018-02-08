package com.feimang.clubstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.feimang.clubstudy.dao")
@EnableDiscoveryClient
@EnableFeignClients
public class ClubStudyApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(
                ClubStudyApplication.class)
                .web(true).run(args);
        // SpringApplication.run(UserApplication.class,args);
        //SpringBootApplication.run
        // SpringApplication.run(DemoApplication.class, args);

    }
}
