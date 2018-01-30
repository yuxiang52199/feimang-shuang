package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BookTag;

import java.util.List;

/**
 * Created by yxm on 2018/1/30
 */
public interface IBookTagService {
    //获取书架列表
    ServerResponse<List<BookTag>> getBookTags(Long userId);
    //排序书架
    ServerResponse editBookTagSeq(Long userId,List<BookTag> bookTagList);
    //删除书架
    ServerResponse delBookTag(Integer utid);
}
