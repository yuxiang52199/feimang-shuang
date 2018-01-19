package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookPerfect;
import com.feimang.userstudy.pojo.UserBookPerfectWithBLOBs;

public interface UserBookPerfectMapper {
    int deleteByPrimaryKey(Long perfectid);

    int insert(UserBookPerfectWithBLOBs record);

    int insertSelective(UserBookPerfectWithBLOBs record);

    UserBookPerfectWithBLOBs selectByPrimaryKey(Long perfectid);

    int updateByPrimaryKeySelective(UserBookPerfectWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserBookPerfectWithBLOBs record);

    int updateByPrimaryKey(UserBookPerfect record);
}