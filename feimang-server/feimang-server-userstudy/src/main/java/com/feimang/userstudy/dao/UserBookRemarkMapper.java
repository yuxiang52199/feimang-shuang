package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookRemark;

public interface UserBookRemarkMapper {
    int deleteByPrimaryKey(Long remarkid);

    int insert(UserBookRemark record);

    int insertSelective(UserBookRemark record);

    UserBookRemark selectByPrimaryKey(Long remarkid);

    int updateByPrimaryKeySelective(UserBookRemark record);

    int updateByPrimaryKey(UserBookRemark record);
}