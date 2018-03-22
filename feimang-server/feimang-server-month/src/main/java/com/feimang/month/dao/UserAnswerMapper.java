package com.feimang.month.dao;

import com.feimang.month.pojo.UserAnswer;

public interface UserAnswerMapper {
    int deleteByPrimaryKey(Long asid);

    int insert(UserAnswer record);

    int insertSelective(UserAnswer record);

    UserAnswer selectByPrimaryKey(Long asid);

    int updateByPrimaryKeySelective(UserAnswer record);

    int updateByPrimaryKey(UserAnswer record);
}