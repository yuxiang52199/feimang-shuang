package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.FriendsRelation;

import java.util.List;

public interface FriendsRelationMapper {
    int deleteByPrimaryKey(Integer conid);

    int insert(FriendsRelation record);

    int insertSelective(FriendsRelation record);

    FriendsRelation selectByPrimaryKey(Integer conid);

    int updateByPrimaryKeySelective(FriendsRelation record);

    int updateByPrimaryKey(FriendsRelation record);
    //获取关注列表
    List<FriendsRelation> getAttens(Long userId);
    //获取粉丝列表
    List<FriendsRelation> getFans(Long userId);
}