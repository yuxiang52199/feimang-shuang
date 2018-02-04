package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BookTag;
import com.feimang.userstudy.service.IBookTagService;
import com.feimang.userstudy.vo.BookTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ServerResponse getBookTags(HttpServletRequest request,Long userId,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
    @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return bookTagService.getBookTags(userId,pageNum,pageSize);
    }

    /**
     * 书架排序
     * @param request
     * @param entity
     * @return
     */
    @PutMapping("/editBookTagSeq")
    public ServerResponse editBookTagSeq(HttpServletRequest request,@RequestBody BookTags entity){
        return bookTagService.editBookTagSeq(entity);
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

    /**
     * 添加书架
     * @param request
     * @param userId 用户id
     * @param bookTag 书架
     * @return
     */
    @PostMapping("/addBookTag")
    public ServerResponse addBookTag(HttpServletRequest request,Long userId,BookTag bookTag){
        return bookTagService.addBookTag(userId,bookTag);
    }

    /**
     * 编辑书架
     * @param request
     * @param bookTag 书架实体类
     * @return
     */
    @PutMapping("/editBookTag")
    public ServerResponse editBookTag(HttpServletRequest request,BookTag bookTag){
        return bookTagService.editBookTag(bookTag);
    }



    @PostMapping("/PostCeshi")
    public BookTags PostCeshi(@RequestBody BookTags entity){
        return entity;
    }
}
