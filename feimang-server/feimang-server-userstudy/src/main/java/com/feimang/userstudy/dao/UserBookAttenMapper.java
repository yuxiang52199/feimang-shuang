package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookAtten;

public interface UserBookAttenMapper {
    int deleteByPrimaryKey(Long atteninfoid);

    int insert(UserBookAtten record);

    int insertSelective(UserBookAtten record);

    UserBookAtten selectByPrimaryKey(Long atteninfoid);

    int updateByPrimaryKeySelective(UserBookAtten record);

    int updateByPrimaryKey(UserBookAtten record);
}