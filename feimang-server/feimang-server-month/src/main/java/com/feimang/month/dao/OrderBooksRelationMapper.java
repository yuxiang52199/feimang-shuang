package com.feimang.month.dao;

import com.feimang.month.pojo.OrderBooksRelation;

public interface OrderBooksRelationMapper {
    int deleteByPrimaryKey(Long oBRelationid);

    int insert(OrderBooksRelation record);

    int insertSelective(OrderBooksRelation record);

    OrderBooksRelation selectByPrimaryKey(Long oBRelationid);

    int updateByPrimaryKeySelective(OrderBooksRelation record);

    int updateByPrimaryKey(OrderBooksRelation record);
}