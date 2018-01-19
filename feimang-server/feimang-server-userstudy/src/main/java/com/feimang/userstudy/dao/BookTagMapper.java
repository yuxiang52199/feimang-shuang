package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.BookTag;

public interface BookTagMapper {
    int deleteByPrimaryKey(Integer utid);

    int insert(BookTag record);

    int insertSelective(BookTag record);

    BookTag selectByPrimaryKey(Integer utid);

    int updateByPrimaryKeySelective(BookTag record);

    int updateByPrimaryKey(BookTag record);
}