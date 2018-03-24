package com.feimang.month.dao;

import com.feimang.month.pojo.Card;

public interface CardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);

    Card selectByMark(String mark);

}