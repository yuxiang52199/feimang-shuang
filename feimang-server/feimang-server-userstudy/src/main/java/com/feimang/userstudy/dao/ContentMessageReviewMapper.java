package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentMessageReview;

public interface ContentMessageReviewMapper {
    int deleteByPrimaryKey(Long messageReviewid);

    int insert(ContentMessageReview record);

    int insertSelective(ContentMessageReview record);

    ContentMessageReview selectByPrimaryKey(Long messageReviewid);

    int updateByPrimaryKeySelective(ContentMessageReview record);

    int updateByPrimaryKey(ContentMessageReview record);
}