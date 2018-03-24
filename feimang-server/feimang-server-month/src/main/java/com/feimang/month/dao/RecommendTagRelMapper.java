package com.feimang.month.dao;

import com.feimang.month.pojo.RecommendTagRel;

public interface RecommendTagRelMapper {
    int deleteByPrimaryKey(Long rtrelid);

    int insert(RecommendTagRel record);

    int insertSelective(RecommendTagRel record);

    RecommendTagRel selectByPrimaryKey(Long rtrelid);

    int updateByPrimaryKeySelective(RecommendTagRel record);

    int updateByPrimaryKey(RecommendTagRel record);
}