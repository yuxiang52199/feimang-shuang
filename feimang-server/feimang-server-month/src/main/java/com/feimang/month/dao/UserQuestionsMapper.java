package com.feimang.month.dao;

import com.feimang.month.pojo.UserQuestions;

public interface UserQuestionsMapper {
    int deleteByPrimaryKey(Integer uqid);

    int insert(UserQuestions record);

    int insertSelective(UserQuestions record);

    UserQuestions selectByPrimaryKey(Integer uqid);

    int updateByPrimaryKeySelective(UserQuestions record);

    int updateByPrimaryKey(UserQuestions record);

    UserQuestions selectLastByUserID(Long userid);
}