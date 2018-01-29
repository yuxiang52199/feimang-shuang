package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.service.IFriendsRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yxm on 2018/1/29
 */
@RestController
public class FriendsRelationController {

    @Autowired
    private IFriendsRelationService iFriendsRelationService;
    /**
     * 获取关注列表
     * @param request
     * @param userId
     * @return
     */
    @GetMapping("/getAttens")
    public ServerResponse getAttens(HttpServletRequest request,Long userId){
        return iFriendsRelationService.getAttens(userId);
    }

    /**
     * 获取粉丝列表
     * @param request
     * @param userId
     * @return
     */
    @GetMapping("/getFans")
    public ServerResponse getFans(HttpServletRequest request,Long userId){
        return iFriendsRelationService.getFans(userId);
    }
}
