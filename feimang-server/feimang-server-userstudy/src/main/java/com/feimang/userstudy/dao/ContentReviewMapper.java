package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentReview;

import java.util.List;

public interface ContentReviewMapper {
    int deleteByPrimaryKey(Long reviewid);

    int insert(ContentReview record);

    int insertSelective(ContentReview record);

    ContentReview selectByPrimaryKey(Long reviewid);

    int updateByPrimaryKeySelective(ContentReview record);

    int updateByPrimaryKey(ContentReview record);
    // 更新评论的点赞数量
    void updateLikeCountByReviewID(Long reviewId);
    // 获取一级评论列表
    List<ContentReview> getReviews(Long contentBaseID);
}