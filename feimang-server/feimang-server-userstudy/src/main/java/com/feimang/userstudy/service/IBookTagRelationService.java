package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BooktagRelation;

import java.util.List;

/**
 * Created by yxm on 2018/2/3
 */
public interface IBookTagRelationService {
    // 获取书架内图书列表
    ServerResponse getBooksByBookTag(Integer utid, int pageNum, int pageSize);
    // 书架内删除图书
    ServerResponse delBookFromBookTag(List<BooktagRelation> booktagRelationList);
}
