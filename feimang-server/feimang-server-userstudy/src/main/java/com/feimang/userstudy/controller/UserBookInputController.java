package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BookInfo;
import com.feimang.userstudy.service.IUserBookInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yxm on 2018/1/29
 */
@RestController
public class UserBookInputController {

    @Autowired
    private IUserBookInputService userBookInputService;
    /**
     * 获取手动录入列表
     * @param request
     * @param userId
     * @return
     */
    @GetMapping("/getInputBooks")
    public ServerResponse getInputBooks(HttpServletRequest request,Long userId){
        return userBookInputService.getInputBooks(userId);
    }

    /**
     * 删除手动录入记录
     * @param request
     * @param inputId 录入记录id
     * @return
     */
    @DeleteMapping("/delInputBook")
    public ServerResponse delInputBook(HttpServletRequest request,Long inputId){
        return userBookInputService.delInputBook(inputId);
    }

    /**
     * 添加手动录入记录
     * @param request
     * @param userId
     * @param bookInfo
     * @return
     */
    @PostMapping("/addInputBook")
    public ServerResponse addInputBook(HttpServletRequest request,Long userId,BookInfo bookInfo){
        return  userBookInputService.addInputBook(userId, bookInfo);
    }
}
