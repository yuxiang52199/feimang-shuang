package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;

/**
 * Created by yxm on 2018/1/29
 */
public interface IFriendsRelationService {
    // 获取关注列表
    ServerResponse getAttens(Long userId,int pageNum,int pageSize);
    // 获取粉丝列表
    ServerResponse getFans(Long userId,int pageNum,int pageSize);
    // 判断是否关注
    ServerResponse isAttenUserByAttentionuid(Long userId,Long attentionuid);
    // 添加关注
    ServerResponse addFriends(Long userId,Long attentionuid);
    // 取消关注
    ServerResponse delFriendsByUserIdAndAttentionuid(Long userId,Long attentionuid);
    // 获取屏蔽列表
    ServerResponse getScreens(Long userId,int pageNum,int pageSize);
    // 添加屏蔽
    ServerResponse addScreen(Long userID,Long screenID);
    // 取消屏蔽
    ServerResponse delScreen(Long userID,Long screenID);
}
