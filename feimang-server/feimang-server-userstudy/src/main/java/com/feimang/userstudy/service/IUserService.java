package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by yxm on 2018/1/28
 */
@FeignClient("eureka-user-server")
public interface IUserService {

    @GetMapping("/getUserByUserIds/{userIds}")
    ServerResponse<List<UserInfo>> getUsersByUserIds(@PathVariable("userIds") String userIds);
}
