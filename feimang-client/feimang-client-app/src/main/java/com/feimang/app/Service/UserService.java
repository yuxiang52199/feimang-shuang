package com.feimang.app.Service;

import com.feimang.app.common.ServerResponse;
import com.feimang.app.pojo.FM_UserStudy;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.awt.SunHints;

import java.lang.reflect.Method;

@FeignClient("eureka-user-server")
public interface UserService {

    @GetMapping("/getUserByUserName")
    ServerResponse<FM_UserStudy> getUserByUserName(@RequestParam("username")String username);
}
