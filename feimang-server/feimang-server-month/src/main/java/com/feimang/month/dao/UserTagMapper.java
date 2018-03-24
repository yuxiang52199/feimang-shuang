package com.feimang.month.dao;

import com.feimang.month.pojo.UserTag;

import java.util.List;

public interface UserTagMapper {
    int deleteByPrimaryKey(Long utid);

    int insert(UserTag record);

    int insertSelective(UserTag record);

    UserTag selectByPrimaryKey(Long utid);

    int updateByPrimaryKeySelective(UserTag record);

    int updateByPrimaryKey(UserTag record);

    int deleteByUserId(Long userid);

    void insertUserTagBatch(List<UserTag> userTagList);

}