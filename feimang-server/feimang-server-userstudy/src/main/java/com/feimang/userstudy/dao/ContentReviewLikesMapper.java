package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentReviewLikes;

public interface ContentReviewLikesMapper {
    int deleteByPrimaryKey(Long reviewLikeid);

    int insert(ContentReviewLikes record);

    int insertSelective(ContentReviewLikes record);

    ContentReviewLikes selectByPrimaryKey(Long reviewLikeid);

    int updateByPrimaryKeySelective(ContentReviewLikes record);

    int updateByPrimaryKey(ContentReviewLikes record);
    // 判断是否存在
    ContentReviewLikes selectByUserIdAndReviewID(ContentReviewLikes contentReviewLikes);
    // 删除数据 根据用户id和一级评论id
    void delByUserIDAndReviewID(ContentReviewLikes contentReviewLikes);
}