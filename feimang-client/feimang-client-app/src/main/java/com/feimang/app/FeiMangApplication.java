package com.feimang.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeiMangApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FeiMangApplication.class).web(true).run(args);
    }
}
