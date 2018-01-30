package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BookTag;
import com.feimang.userstudy.service.IBookTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yxm on 2018/1/30
 */
@RestController
public class BookTagController {
    @Autowired
    private IBookTagService bookTagService;
    /**
     * 获取书架列表
     * @param request
     * @param userId
     * @return
     */
    @GetMapping("/getBookTags")
    public ServerResponse getBookTags(HttpServletRequest request,Long userId){
        return bookTagService.getBookTags(userId);
    }

    /**
     * 书架排序
     * @param request
     * @param bookTagList
     * @return
     */
    @PutMapping("/editBookTagSeq")
    public ServerResponse editBookTagSeq(HttpServletRequest request,Long userId, List<BookTag> bookTagList){
        return bookTagService.editBookTagSeq(userId,bookTagList);
    }

    /**
     * 删除书架
     * @param request
     * @param utid 书架id
     * @return
     */
    @DeleteMapping("/delBookTag")
    public ServerResponse delBookTag(HttpServletRequest request,Integer utid){
        return bookTagService.delBookTag(utid);
    }
}
