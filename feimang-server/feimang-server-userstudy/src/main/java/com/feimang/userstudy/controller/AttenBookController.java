package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.UserBookAtten;
import com.feimang.userstudy.service.IAttenBookService;
import com.feimang.userstudy.service.impl.AttenBookServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 关注图书功能
 */
@RestController
public class AttenBookController {

    @Autowired
    private IAttenBookService iAttenBookService;

    /**
     * 添加关注
     * @param request
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */

    public ServerResponse addAtten(HttpServletRequest request,Integer userId,Integer bookId){
        return iAttenBookService.addAttenByUserIdAndBookId(userId, bookId);
    }

    /**
     * 获取当前用户关注的图书
     * @param request
     * @param userId 用户id
     * @param pageNum 第几页
     * @param pageSize 每页几条数据
     * @return
     */
    @GetMapping("/getAttenBooks")
    public ServerResponse<List<UserBookAtten>> getAttenBooks(HttpServletRequest request, Integer userId,
                                                             @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                             @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return iAttenBookService.getAttenBooks(userId, pageNum, pageSize);
    }
}
