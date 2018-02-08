package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BooktagRelation;
import com.feimang.userstudy.vo.BookTagRelations;
import com.feimang.userstudy.vo.UserBookVO;

import java.util.List;

/**
 * Created by yxm on 2018/2/3
 */
public interface IBookTagRelationService {
    // 获取书架内图书列表
    ServerResponse getBooksByBookTag(Long userId,Integer utid, int pageNum, int pageSize);
    // 书架内删除图书
    ServerResponse delBookFromBookTag(List<BooktagRelation> booktagRelationList);
    // 书架内添加图书
    ServerResponse addBookToBookTag(UserBookVO bookTagRelations);
    // 书架内复制图书
    ServerResponse copyBook(List<BooktagRelation> booktagRelationList);
    // 书架内移动图书
    ServerResponse moveBook(BookTagRelations entity);
    // 书架内排序图书
    ServerResponse editBookSeq(List<BooktagRelation> booktagRelationList);
}
