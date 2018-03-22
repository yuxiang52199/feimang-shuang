package com.feimang.month.dao;

import com.feimang.month.pojo.QuestionsSuite;

public interface QuestionsSuiteMapper {
    int deleteByPrimaryKey(Integer qsid);

    int insert(QuestionsSuite record);

    int insertSelective(QuestionsSuite record);

    QuestionsSuite selectByPrimaryKey(Integer qsid);

    int updateByPrimaryKeySelective(QuestionsSuite record);

    int updateByPrimaryKey(QuestionsSuite record);

    QuestionsSuite getQuestionsSuiteRandom(Long userId);
}