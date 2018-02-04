package com.feimang.user.dao;

import com.feimang.user.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long userid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> getUsersByUserIds(List<String> userIdList);
}