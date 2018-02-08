package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.ActivitySignUp;

import java.util.List;
import java.util.Map;

public interface ActivitySignUpMapper {
    int deleteByPrimaryKey(Long signupid);

    int insert(ActivitySignUp record);

    int insertSelective(ActivitySignUp record);

    ActivitySignUp selectByPrimaryKey(Long signupid);

    int updateByPrimaryKeySelective(ActivitySignUp record);

    int updateByPrimaryKey(ActivitySignUp record);

    List<ActivitySignUp> selectListByMap(Map<String,Object> map);
}