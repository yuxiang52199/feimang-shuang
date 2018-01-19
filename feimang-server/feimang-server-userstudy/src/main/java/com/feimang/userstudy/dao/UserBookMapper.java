package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBook;

public interface UserBookMapper {
    int deleteByPrimaryKey(Integer ubid);

    int insert(UserBook record);

    int insertSelective(UserBook record);

    UserBook selectByPrimaryKey(Integer ubid);

    int updateByPrimaryKeySelective(UserBook record);

    int updateByPrimaryKey(UserBook record);
}