package com.feimang.month.dao;

import com.feimang.month.pojo.RecommendTag;

public interface RecommendTagMapper {
    int deleteByPrimaryKey(Long rtid);

    int insert(RecommendTag record);

    int insertSelective(RecommendTag record);

    RecommendTag selectByPrimaryKey(Long rtid);

    int updateByPrimaryKeySelective(RecommendTag record);

    int updateByPrimaryKey(RecommendTag record);
}