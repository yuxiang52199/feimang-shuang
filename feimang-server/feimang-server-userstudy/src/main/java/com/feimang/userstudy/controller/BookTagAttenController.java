package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BookTagAtten;
import com.feimang.userstudy.service.IBookTagAttenService;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yxm on 2018/1/30
 */
@RestController
public class BookTagAttenController {
    @Autowired
    private IBookTagAttenService bookTagAttenService;
    /**
     * 获取关注书架列表
     * @param request
     * @param userId 用户id
     * @return
     */
    @GetMapping("/getAttenBookTags")
    public ServerResponse getAttenBookTags(HttpServletRequest request, Long userId,@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
    @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return bookTagAttenService.getAttenBookTags(userId,pageNum,pageSize);
    }

    /**
     * 添加关注书架
     * @param request
     * @param userId
     * @param bookTagAtten
     * @return
     */
    @PostMapping("/addAttenBookTag")
    public ServerResponse addAttenBookTag(HttpServletRequest request, Long userId, BookTagAtten bookTagAtten){
        return bookTagAttenService.addAttenBookTag(userId,bookTagAtten);
    }

    /**
     * 判断是否关注书架
     * @param request
     * @param userId
     * @param utid
     * @return
     */
    @GetMapping("/isAttenBookTag")
    public ServerResponse isAttenBookTag(HttpServletRequest request,Long userId,Long utid){
        return bookTagAttenService.isAttenBookTag(userId, utid);
    }

    /**
     * 取消关注书架
     * @param request
     * @param userId
     * @param attenId
     * @return
     */
    @DeleteMapping("/delAttenBookTag")
    public ServerResponse delAttenBookTag(HttpServletRequest request,Long userId,Long attenId){
        return bookTagAttenService.delAttenBookTag(userId, attenId);
    }
}
