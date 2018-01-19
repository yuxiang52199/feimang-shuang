package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentReview;

public interface ContentReviewMapper {
    int deleteByPrimaryKey(Long reviewid);

    int insert(ContentReview record);

    int insertSelective(ContentReview record);

    ContentReview selectByPrimaryKey(Long reviewid);

    int updateByPrimaryKeySelective(ContentReview record);

    int updateByPrimaryKey(ContentReview record);
}