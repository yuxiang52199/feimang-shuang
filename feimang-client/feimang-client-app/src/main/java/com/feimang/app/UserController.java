package com.feimang.app;

import com.feimang.app.Service.UserService;
import com.feimang.app.common.ServerResponse;
import com.feimang.app.pojo.FM_UserStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getuser")
    public ServerResponse<FM_UserStudy> dc(String username) {
        return userService.getUserByUserName( username);
    }
}
