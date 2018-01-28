package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookAtten;

import java.util.List;

public interface UserBookAttenMapper {
    int deleteByPrimaryKey(Long atteninfoid);

    int insert(UserBookAtten record);

    int insertSelective(UserBookAtten record);

    UserBookAtten selectByPrimaryKey(Long atteninfoid);

    int updateByPrimaryKeySelective(UserBookAtten record);

    int updateByPrimaryKey(UserBookAtten record);

    // 查询用户关注的图书
    List<UserBookAtten> getAttendBooksByUserId(Integer userId);
}