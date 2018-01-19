package com.feimang.user.controller;

import com.feimang.user.common.ServerResponse;
import com.feimang.user.pojo.UserInfo;
import com.feimang.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/getUserByUserName")
    public ServerResponse<UserInfo> getUserByUserName(String username){
        //String username="xiang11512";
        ServerResponse<UserInfo> response = iUserService.getUserByUserName(username);
        return response;
    }

    @GetMapping("/getUserByUserId")
    public ServerResponse<UserInfo> getUserByUserId(Long userid){
        //String username="xiang11512";
        ServerResponse<UserInfo> response = iUserService.getUserByUserId(userid);
        return response;
    }


}
