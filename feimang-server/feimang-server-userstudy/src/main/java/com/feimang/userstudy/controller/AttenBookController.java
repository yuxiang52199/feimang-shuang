package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BookInfo;
import com.feimang.userstudy.pojo.UserBookAtten;
import com.feimang.userstudy.pojo.UserInfo;
import com.feimang.userstudy.service.IAttenBookService;
import com.feimang.userstudy.service.IBookService;
import com.feimang.userstudy.service.IUserService;
import com.feimang.userstudy.service.impl.AttenBookServiceImpl;

import com.netflix.discovery.converters.Auto;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    @GetMapping("/getBooksByBookIds/{bookIds}")
    ServerResponse<List<BookInfo>> getBooksByBookIds(@PathVariable("bookIds") String bookIds){
        return bookService.getBooksByBookIds(bookIds);
    }

    @GetMapping("/getUserByUserIds/{userIds}")
    ServerResponse<List<UserInfo>> getUsersByUserIds(@PathVariable("userIds") String userIds){
       return userService.getUsersByUserIds(userIds);
    }

    /**
     * 添加关注
     * @param request
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    @GetMapping("/addAtten")
    public ServerResponse addAtten(HttpServletRequest request,Long userId,Integer bookId){
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
    public ServerResponse<List<UserBookAtten>> getAttenBooks(HttpServletRequest request, Long userId,
                                                             @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                             @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return iAttenBookService.getAttenBooks(userId, pageNum, pageSize);
    }

    /**
     * 判断图书是否被关注
     * @param request
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    @GetMapping("/isAttenBook")
    public ServerResponse isAttenBook(HttpServletRequest request, Long userId, Integer bookId){
        return iAttenBookService.isAttenBook(userId, bookId);
    }

    /**
     * 取消关注图书
     * @param request
     * @param userId
     * @param bookId
     * @return
     */
    @GetMapping("/delAtten")
    public ServerResponse delAtten(HttpServletRequest request,Long userId,Integer bookId){
        return iAttenBookService.delAtten(userId, bookId);
    }

}
