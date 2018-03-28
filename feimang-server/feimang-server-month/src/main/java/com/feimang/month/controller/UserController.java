package com.feimang.month.controller;

import com.feimang.month.common.ServerResponse;
import com.feimang.month.pojo.UserAbstruct;
import com.feimang.month.service.IUserService;
import com.feimang.month.vo.CeshiVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private IUserService userServices;

    @PostMapping("/insertUserRegistration")
    public ServerResponse insertUserRegistration(@RequestBody UserAbstruct userAbstruct){
        return userServices.insertUserRegistration(userAbstruct);
    }
    @PostMapping("/updateUserReceivingAddress")
    public ServerResponse updateUserReceivingAddress(@RequestBody UserAbstruct userAbstruct){
        return userServices.updateUserReceivingAddress(userAbstruct);
    }

    @GetMapping("/getxsUserReceivingAddress/{userId}")
    public ServerResponse getUserReceivingAddress(@PathVariable("userId")Long userId) {
        return  userServices.getUserReceivingAddress(userId);
    }
    @GetMapping("/getxsUserReadsth/{userId}")
    public ServerResponse getUserReadsth(@PathVariable("userId")Long userId) {
        return  userServices.getUserReadsth(userId);
    }
}
