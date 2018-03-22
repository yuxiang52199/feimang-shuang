package com.feimang.month.dao;

import com.feimang.month.pojo.Questions;

import java.util.List;

public interface QuestionsMapper {
    int deleteByPrimaryKey(Long quid);

    int insert(Questions record);

    int insertSelective(Questions record);

    Questions selectByPrimaryKey(Long quid);

    int updateByPrimaryKeySelective(Questions record);

    int updateByPrimaryKey(Questions record);

    List<Questions> selectListBySuid(Integer suid);
}