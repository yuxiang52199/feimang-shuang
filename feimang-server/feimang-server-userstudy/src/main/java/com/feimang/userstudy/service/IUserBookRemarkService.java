package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.UserBookRemark;

/**
 * Created by yxm on 2018/2/8
 */
public interface IUserBookRemarkService {
    // 判断是否备注图书
    ServerResponse isRemarkBook(Long fromuid, Long bookid);
    // 获取备注图书列表
    ServerResponse getBookRemarksByFromuid(Long fromuid,int pageNum,int pageSize);
    // 添加或修改图书备注
    ServerResponse addOrupdateRemark(UserBookRemark userBookRemark);
}
