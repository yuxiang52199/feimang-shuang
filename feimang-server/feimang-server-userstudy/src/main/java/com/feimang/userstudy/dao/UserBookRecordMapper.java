package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookRecord;

public interface UserBookRecordMapper {
    int deleteByPrimaryKey(Long recordid);

    int insert(UserBookRecord record);

    int insertSelective(UserBookRecord record);

    UserBookRecord selectByPrimaryKey(Long recordid);

    int updateByPrimaryKeySelective(UserBookRecord record);

    int updateByPrimaryKey(UserBookRecord record);
}