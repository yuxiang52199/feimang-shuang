package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookInput;

import java.util.List;

public interface UserBookInputMapper {
    int deleteByPrimaryKey(Long inputid);

    int insert(UserBookInput record);

    int insertSelective(UserBookInput record);

    UserBookInput selectByPrimaryKey(Long inputid);

    int updateByPrimaryKeySelective(UserBookInput record);

    int updateByPrimaryKey(UserBookInput record);
    //获取手动录入列表
    List<UserBookInput> getInputBooksByUserId(Long userId);
}