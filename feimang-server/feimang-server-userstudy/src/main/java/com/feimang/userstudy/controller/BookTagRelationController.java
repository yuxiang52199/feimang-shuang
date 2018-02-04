package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.service.IBookTagRelationService;
import com.feimang.userstudy.vo.BookTagRelations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yxm on 2018/2/3
 */
@RestController
public class BookTagRelationController {
    @Autowired
    private IBookTagRelationService bookTagRelationService;
    /**
     * 获取书架内图书列表
     * @param request
     * @param utid
     * @return
     */
    @GetMapping("/getBooksByBookTag")
    public ServerResponse getBooksByBookTag(HttpServletRequest request,Integer utid,
                                            @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        return bookTagRelationService.getBooksByBookTag(utid, pageNum, pageSize);
    }

    /**
     * 书架内添加图书
     * @param request
     * @param entity
     * @return
     */
    @PostMapping("/addBookToBookTag")
    public ServerResponse addBookToBookTag(HttpServletRequest request,@RequestBody BookTagRelations entity){
        return null;
    }

    /**
     * 书架内删除图书
     * @param request
     * @param entity
     * @return
     */
    @PostMapping("delBookFromBookTag")
    public ServerResponse delBookFromBookTag(HttpServletRequest request,@RequestBody BookTagRelations entity){
        return bookTagRelationService.delBookFromBookTag(entity.booktagRelations);
    }
}
