package com.feimang.month.dao;

import com.feimang.month.pojo.Knowledge_Type;

public interface Knowledge_TypeMapper {
    int deleteByPrimaryKey(Integer klid);

    int insert(Knowledge_Type record);

    int insertSelective(Knowledge_Type record);

    Knowledge_Type selectByPrimaryKey(Integer klid);

    int updateByPrimaryKeySelective(Knowledge_Type record);

    int updateByPrimaryKey(Knowledge_Type record);
}