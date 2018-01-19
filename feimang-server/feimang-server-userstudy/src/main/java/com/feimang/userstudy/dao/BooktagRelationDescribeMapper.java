package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.BooktagRelationDescribe;

public interface BooktagRelationDescribeMapper {
    int deleteByPrimaryKey(Long describeid);

    int insert(BooktagRelationDescribe record);

    int insertSelective(BooktagRelationDescribe record);

    BooktagRelationDescribe selectByPrimaryKey(Long describeid);

    int updateByPrimaryKeySelective(BooktagRelationDescribe record);

    int updateByPrimaryKey(BooktagRelationDescribe record);
}