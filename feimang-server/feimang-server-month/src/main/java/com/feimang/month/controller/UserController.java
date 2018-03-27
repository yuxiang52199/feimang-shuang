package com.feimang.month.controller;

import com.feimang.month.common.ServerResponse;
import com.feimang.month.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
        @Autowired
        private IUserService userServices;

    @GetMapping("/getxsUserReceivingAddress/{userId}")
    public ServerResponse getUserReceivingAddress(@PathVariable("userId")Long userId) {
        return  userServices.getUserReceivingAddress(userId);
    }
    @GetMapping("/getxsUserReadsth/{userId}")
    public ServerResponse getUserReadsth(@PathVariable("userId")Long userId) {
        return  userServices.getUserReadsth(userId);
    }
}
