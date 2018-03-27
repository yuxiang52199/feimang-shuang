package com.feimang.month.dao;

import com.feimang.month.pojo.UserAbstruct;

public interface UserAbstructMapper {
    int deleteByPrimaryKey(Long uaid);

    int insert(UserAbstruct record);

    int insertSelective(UserAbstruct record);

    UserAbstruct selectByPrimaryKey(Long uaid);

    int updateByPrimaryKeySelective(UserAbstruct record);

    int updateByPrimaryKey(UserAbstruct record);

    UserAbstruct selectByUserId(Long userId);
}