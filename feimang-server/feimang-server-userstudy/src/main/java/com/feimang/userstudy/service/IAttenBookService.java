package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.UserBookAtten;

import java.util.List;

/**
 * Created by yxm on 2018/1/27
 */
public interface IAttenBookService {
    /**
     * 添加图书关注
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    ServerResponse addAttenByUserIdAndBookId(Long userId, Integer bookId);

    /**
     * 获取用户的关注图书列表
     * @param userId 用户id
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<List<UserBookAtten>> getAttenBooks(Long userId, int pageNum, int pageSize);

    /**
     * 验证图书是否被关注
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    ServerResponse isAttenBook(Long userId,Integer bookId);

    /**
     * 取消关注的图书
     * @param userId 用户id
     * @param bookId 图书id
     * @return
     */
    ServerResponse delAtten(Long userId,Integer bookId);

}
