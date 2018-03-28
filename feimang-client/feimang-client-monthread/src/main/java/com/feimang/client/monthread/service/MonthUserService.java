package com.feimang.client.monthread.service;

import com.feimang.client.monthread.common.ServerResponse;
import com.feimang.client.monthread.pojo.UserAbstruct;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("eureka-month-server")
public interface MonthUserService {
    @PostMapping("/insertUserRegistration")
    ServerResponse insertUserRegistration(@RequestBody UserAbstruct userAbstruct);
    @PostMapping("/updateUserReceivingAddress")
    ServerResponse updateUserReceivingAddress(@RequestBody UserAbstruct userAbstruct);
    @GetMapping("/getxsUserReceivingAddress/{userId}")
    ServerResponse getUserReceivingAddress(@PathVariable("userId")Long userId);
    @GetMapping("/getxsUserReadsth/{userId}")
    ServerResponse getUserReadsth(@PathVariable("userId")Long userId);
}
