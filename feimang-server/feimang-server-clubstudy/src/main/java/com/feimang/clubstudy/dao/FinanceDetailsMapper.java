package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.FinanceDetails;

public interface FinanceDetailsMapper {
    int deleteByPrimaryKey(Long financeid);

    int insert(FinanceDetails record);

    int insertSelective(FinanceDetails record);

    FinanceDetails selectByPrimaryKey(Long financeid);

    int updateByPrimaryKeySelective(FinanceDetails record);

    int updateByPrimaryKey(FinanceDetails record);
}