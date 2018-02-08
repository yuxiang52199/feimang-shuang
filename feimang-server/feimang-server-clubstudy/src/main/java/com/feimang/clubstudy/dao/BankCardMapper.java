package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.BankCard;

public interface BankCardMapper {
    int deleteByPrimaryKey(Integer cbcid);

    int insert(BankCard record);

    int insertSelective(BankCard record);

    BankCard selectByPrimaryKey(Integer cbcid);

    int updateByPrimaryKeySelective(BankCard record);

    int updateByPrimaryKey(BankCard record);
}