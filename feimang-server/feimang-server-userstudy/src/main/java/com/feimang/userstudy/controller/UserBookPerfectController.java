package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.UserBookPerfect;
import com.feimang.userstudy.service.IUserBookPerfectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yxm on 2018/1/29
 */
@RestController
public class UserBookPerfectController {
    @Autowired
    private IUserBookPerfectService userBookPerfectService;
    /**
     * 判断是否完善过图书
     * @param request
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    @GetMapping("/isPerfectBook")
    public ServerResponse isPerfectBook(HttpServletRequest request,Long userId,Integer bookId){
        return userBookPerfectService.isPerfectBook(userId, bookId);
    }

    /**
     * 获取用户完善资料列表
     * @param request
     * @param userId 用户id
     * @return
     */
    @GetMapping("/getPerfectBooks")
    public ServerResponse<List<UserBookPerfect>> getPerfectBooks(HttpServletRequest request,Long userId){
        return userBookPerfectService.getPerfectBooksByUserID(userId);
    }

    /**
     * 获取用户完善资料信息
     * @param request
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    @GetMapping("/getPerfectBook")
    public ServerResponse getPerfectBook(HttpServletRequest request,Long userId,Integer bookId){
        return userBookPerfectService.getPerfectBookByUserIdAndBookId(userId, bookId);
    }

    /**
     * 删除完善资料记录
     * @param request
     * @param perfectId 完善资料id
     * @return
     */
    @DeleteMapping("/delPerfectBook")
    public ServerResponse delPerfectBook(HttpServletRequest request,Long perfectId){
        return userBookPerfectService.delPerfectBook(perfectId);
    }

    /**
     * 编辑完善资料信息
     * @param request
     * @param userBookPerfect
     * @return
     */
    @PutMapping("/editPerfectBook")
    public ServerResponse editPerfectBook(HttpServletRequest request,UserBookPerfect userBookPerfect){
        return userBookPerfectService.editPerfectBook(userBookPerfect);
    }

    /**
     * 添加完善资料信息
     * @param request
     * @param userId 用户id
     * @param bookId 图书id
     * @param userBookPerfect
     * @return
     */
    @PostMapping("/addPerfectBook")
    public ServerResponse addPerfectBook(HttpServletRequest request,Long userId,Long bookId,UserBookPerfect userBookPerfect){
        return userBookPerfectService.addPerfectBook(userBookPerfect,userId,bookId);
    }

}