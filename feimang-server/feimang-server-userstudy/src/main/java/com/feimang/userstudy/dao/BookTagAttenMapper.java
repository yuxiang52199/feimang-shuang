package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.BookTagAtten;

public interface BookTagAttenMapper {
    int deleteByPrimaryKey(Long attenid);

    int insert(BookTagAtten record);

    int insertSelective(BookTagAtten record);

    BookTagAtten selectByPrimaryKey(Long attenid);

    int updateByPrimaryKeySelective(BookTagAtten record);

    int updateByPrimaryKey(BookTagAtten record);
}