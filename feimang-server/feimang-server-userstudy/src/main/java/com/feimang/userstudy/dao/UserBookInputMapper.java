package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookInput;

public interface UserBookInputMapper {
    int deleteByPrimaryKey(Long inputid);

    int insert(UserBookInput record);

    int insertSelective(UserBookInput record);

    UserBookInput selectByPrimaryKey(Long inputid);

    int updateByPrimaryKeySelective(UserBookInput record);

    int updateByPrimaryKey(UserBookInput record);
}