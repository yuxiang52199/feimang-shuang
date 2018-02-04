package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.UserBookPerfect;

/**
 * Created by yxm on 2018/1/29
 */
public interface IUserBookPerfectService {
    //判断是否完善过图书
    ServerResponse isPerfectBook(Long userId, Integer bookId);
    //获取完善信息列表
    ServerResponse getPerfectBooksByUserID(Long userId,int pageNum,int pageSize);
    //获取完善资料信息
    ServerResponse getPerfectBookByUserIdAndBookId(Long userId,Integer bookId);
    //删除完善资料信息
    ServerResponse delPerfectBook(Long perfectId);
    //编辑完善资料信息
    ServerResponse editPerfectBook(UserBookPerfect userBookPerfect);
    //添加完善资料信息
    ServerResponse addPerfectBook(UserBookPerfect userBookPerfect,Long userId,Long bookId);

}
