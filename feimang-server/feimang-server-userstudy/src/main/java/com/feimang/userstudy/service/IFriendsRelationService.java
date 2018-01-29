package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;

/**
 * Created by yxm on 2018/1/29
 */
public interface IFriendsRelationService {
    // 获取关注列表
    ServerResponse getAttens(Long userId);
    // 获取粉丝列表
    ServerResponse getFans(Long userId);
}
