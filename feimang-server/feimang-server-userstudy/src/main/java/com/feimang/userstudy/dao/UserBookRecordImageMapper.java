package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookRecordImage;

public interface UserBookRecordImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBookRecordImage record);

    int insertSelective(UserBookRecordImage record);

    UserBookRecordImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBookRecordImage record);

    int updateByPrimaryKeyWithBLOBs(UserBookRecordImage record);

    int updateByPrimaryKey(UserBookRecordImage record);
}