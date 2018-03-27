package com.feimang.month.dao;

import com.feimang.month.pojo.Order;

import java.util.HashMap;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByMap(HashMap map);

}