package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.service.IFriendsRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yxm on 2018/1/29
 */
@RestController
public class FriendsRelationController {

    @Autowired
    private IFriendsRelationService friendsRelationService;
    /**
     * 获取关注列表
     * @param request
     * @param userId
     * @return
     */
    @GetMapping("/getAttens")
    public ServerResponse getAttens(HttpServletRequest request,Long userId,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return friendsRelationService.getAttens(userId,pageNum,pageSize);
    }

    /**
     * 获取粉丝列表
     * @param request
     * @param userId 用户id
     * @return
     */
    @GetMapping("/getFans")
    public ServerResponse getFans(HttpServletRequest request,Long userId,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return friendsRelationService.getFans(userId,pageNum,pageSize);
    }

    /**
     * 判断是否关注
     * @param request
     * @param attentionuid 被关注者id
     * @return
     */
    @GetMapping("/isAttenUser")
    public ServerResponse isAttenUser(HttpServletRequest request,Long userId,Long attentionuid){
        return friendsRelationService.isAttenUserByAttentionuid(userId, attentionuid);
    }

    /**
     * 添加关注
     * @param request
     * @param userId 用户id
     * @param attentionuid 被关注者id
     * @return
     */
    @PostMapping("/addFriends")
    public ServerResponse addFriends(HttpServletRequest request,Long userId,Long attentionuid){
        return friendsRelationService.addFriends(userId, attentionuid);
    }

    /**
     * 取消关注
     * @param request
     * @param userId
     * @param attentionuid
     * @return
     */
    @PutMapping("/delFriends")
    public ServerResponse delFriends(HttpServletRequest request,Long userId,Long attentionuid){
        return friendsRelationService.delFriendsByUserIdAndAttentionuid(userId, attentionuid);
    }

    /**
     * 获取屏蔽列表
     * @param request
     * @param userId 用户id
     * @return
     */
    @PostMapping("/getScreens")
    public ServerResponse getScreens(HttpServletRequest request,Long userId,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return friendsRelationService.getScreens(userId, pageNum, pageSize);
    }

    /**
     * 添加屏蔽用户
     * @param request
     * @param userID
     * @param screenID
     * @return
     */
    @PostMapping("/addScreen")
    public ServerResponse addScreen(HttpServletRequest request,Long userID,Long screenID){
        return friendsRelationService.addScreen(userID, screenID);
    }

    /**
     * 取消屏蔽用户
     * @param request
     * @param userID
     * @param screenID
     * @return
     */
    @PostMapping("/delScreen")
    public ServerResponse delScreen(HttpServletRequest request,Long userID,Long screenID){
        return friendsRelationService.delScreen(userID, screenID);
    }
}
