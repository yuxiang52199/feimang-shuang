package com.feimang.user.controller;

import com.feimang.user.common.ServerResponse;
import com.feimang.user.pojo.UserInfo;
import com.feimang.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/getUserByUserName")
    public ServerResponse<UserInfo> getUserByUserName(String username){
        //String username="xiang11512";
        ServerResponse<UserInfo> response = userService.getUserByUserName(username);
        return response;
    }

    @GetMapping("/getUserByUserId")
    public ServerResponse<UserInfo> getUserByUserId(Long userid){
        //String username="xiang11512";
        ServerResponse<UserInfo> response = userService.getUserByUserId(userid);
        return response;
    }
    @GetMapping("/getUserByUserIds/{userIds}")
    public ServerResponse<List<UserInfo>> getUsersByUserIds(@PathVariable("userIds") String userIds) {
        return userService.getUsersByUserIds(userIds);
    }



}
