package com.feimang.month.dao;

import com.feimang.month.pojo.OrderProductRelation;

import java.util.List;

public interface OrderProductRelationMapper {
    int deleteByPrimaryKey(Long oPRelationid);

    int insert(OrderProductRelation record);

    Long insertSelective(OrderProductRelation record);

    OrderProductRelation selectByPrimaryKey(Long oPRelationid);

    int updateByPrimaryKeySelective(OrderProductRelation record);

    int updateByPrimaryKey(OrderProductRelation record);

    List<OrderProductRelation> selectListByOrderNumber(String orderNumber);

}