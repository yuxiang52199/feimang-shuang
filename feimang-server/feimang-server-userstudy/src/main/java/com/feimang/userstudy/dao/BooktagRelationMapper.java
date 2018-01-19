package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.BooktagRelation;

public interface BooktagRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BooktagRelation record);

    int insertSelective(BooktagRelation record);

    BooktagRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BooktagRelation record);

    int updateByPrimaryKey(BooktagRelation record);
}