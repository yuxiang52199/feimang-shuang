package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.PayOrder;

public interface PayOrderMapper {
    int deleteByPrimaryKey(String payid);

    int insert(PayOrder record);

    int insertSelective(PayOrder record);

    PayOrder selectByPrimaryKey(String payid);

    int updateByPrimaryKeySelective(PayOrder record);

    int updateByPrimaryKey(PayOrder record);
}