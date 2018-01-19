package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentReviewLikes;

public interface ContentReviewLikesMapper {
    int deleteByPrimaryKey(Long reviewLikeid);

    int insert(ContentReviewLikes record);

    int insertSelective(ContentReviewLikes record);

    ContentReviewLikes selectByPrimaryKey(Long reviewLikeid);

    int updateByPrimaryKeySelective(ContentReviewLikes record);

    int updateByPrimaryKey(ContentReviewLikes record);
}