package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentMessageLikes;

public interface ContentMessageLikesMapper {
    int deleteByPrimaryKey(Long messageLikeid);

    int insert(ContentMessageLikes record);

    int insertSelective(ContentMessageLikes record);

    ContentMessageLikes selectByPrimaryKey(Long messageLikeid);

    int updateByPrimaryKeySelective(ContentMessageLikes record);

    int updateByPrimaryKey(ContentMessageLikes record);
}