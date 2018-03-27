package com.feimang.month.dao;

import com.feimang.month.pojo.OrderBooksRelation;

import java.util.List;

public interface OrderBooksRelationMapper {
    int deleteByPrimaryKey(Long oBRelationid);

    int insert(OrderBooksRelation record);

    int insertSelective(OrderBooksRelation record);

    OrderBooksRelation selectByPrimaryKey(Long oBRelationid);

    int updateByPrimaryKeySelective(OrderBooksRelation record);

    int updateByPrimaryKey(OrderBooksRelation record);
    //肖洒添加的:根据用户获取已读图书
    int selectBooksByUserId(Long UserId);

    Long selectDaysByUserId(Long UserId);
}