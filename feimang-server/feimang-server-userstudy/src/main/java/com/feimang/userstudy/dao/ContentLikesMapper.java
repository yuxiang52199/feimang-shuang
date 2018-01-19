package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentLikes;

public interface ContentLikesMapper {
    int deleteByPrimaryKey(Long contentLikeid);

    int insert(ContentLikes record);

    int insertSelective(ContentLikes record);

    ContentLikes selectByPrimaryKey(Long contentLikeid);

    int updateByPrimaryKeySelective(ContentLikes record);

    int updateByPrimaryKey(ContentLikes record);
}