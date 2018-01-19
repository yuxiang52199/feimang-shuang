package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentReply;

public interface ContentReplyMapper {
    int deleteByPrimaryKey(Long replyid);

    int insert(ContentReply record);

    int insertSelective(ContentReply record);

    ContentReply selectByPrimaryKey(Long replyid);

    int updateByPrimaryKeySelective(ContentReply record);

    int updateByPrimaryKey(ContentReply record);
}