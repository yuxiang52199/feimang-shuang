package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BookInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yxm on 2018/1/29
 */
public interface IUserBookInputService {
    //获取录入图书列表
    ServerResponse getInputBooks(Long userId);
    //删除手动录入记录
    ServerResponse delInputBook(Long inputId);
    //添加手动录入记录
    ServerResponse addInputBook(Long userId, BookInfo bookInfo);
}
