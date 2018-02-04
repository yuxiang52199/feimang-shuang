package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BookTag;
import com.feimang.userstudy.vo.BookTags;

import java.util.List;

/**
 * Created by yxm on 2018/1/30
 */
public interface IBookTagService {
    //获取书架列表
    ServerResponse<List<BookTag>> getBookTags(Long userId,int pageNum,int pageSize);
    //排序书架
    ServerResponse editBookTagSeq(BookTags bookTags);
    //删除书架
    ServerResponse delBookTag(Integer utid);
    //添加书架
    ServerResponse addBookTag(Long userId,BookTag bookTag);
    //编辑书架
    ServerResponse editBookTag(BookTag bookTag);
}
