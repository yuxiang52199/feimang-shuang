package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.FriendsRelation;

public interface FriendsRelationMapper {
    int deleteByPrimaryKey(Integer conid);

    int insert(FriendsRelation record);

    int insertSelective(FriendsRelation record);

    FriendsRelation selectByPrimaryKey(Integer conid);

    int updateByPrimaryKeySelective(FriendsRelation record);

    int updateByPrimaryKey(FriendsRelation record);
}