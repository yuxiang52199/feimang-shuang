package com.feimang.month.dao;

import com.feimang.month.pojo.UserKl;

public interface UserKlMapper {
    int deleteByPrimaryKey(Long ukid);

    int insert(UserKl record);

    int insertSelective(UserKl record);

    UserKl selectByPrimaryKey(Long ukid);

    int updateByPrimaryKeySelective(UserKl record);

    int updateByPrimaryKey(UserKl record);

    UserKl selectByUserId(Long userid);

}