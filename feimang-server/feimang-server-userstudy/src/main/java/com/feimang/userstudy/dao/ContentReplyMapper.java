package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentReply;

import java.util.List;

public interface ContentReplyMapper {
    int deleteByPrimaryKey(Long replyid);

    int insert(ContentReply record);

    int insertSelective(ContentReply record);

    ContentReply selectByPrimaryKey(Long replyid);

    int updateByPrimaryKeySelective(ContentReply record);

    int updateByPrimaryKey(ContentReply record);
    // 获取二级评论
    List<ContentReply> getReplysByReviewID(Long reviewId);
    // 获取二级评论前三条
    List<ContentReply> getReplysLimitByReviewID(Long reviewId);
}