package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentReplyLikes;

public interface ContentReplyLikesMapper {
    int deleteByPrimaryKey(Long replyLikeid);

    int insert(ContentReplyLikes record);

    int insertSelective(ContentReplyLikes record);

    ContentReplyLikes selectByPrimaryKey(Long replyLikeid);

    int updateByPrimaryKeySelective(ContentReplyLikes record);

    int updateByPrimaryKey(ContentReplyLikes record);
}