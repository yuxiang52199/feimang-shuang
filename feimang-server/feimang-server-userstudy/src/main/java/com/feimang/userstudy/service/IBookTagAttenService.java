package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.BookTagAtten;

/**
 * Created by yxm on 2018/1/30
 */
public interface IBookTagAttenService {
    //获取用户关注的书架列表
    ServerResponse getAttenBookTags(Long userId,int pageNum,int pageSize);
    //判断是否关注书架
    ServerResponse isAttenBookTag(Long userId,Long utid);
    //添加关注书架
    ServerResponse addAttenBookTag(Long userId,BookTagAtten bookTagAtten);
    //取消关注书架
    ServerResponse delAttenBookTag(Long userId,Long attenId);
}
