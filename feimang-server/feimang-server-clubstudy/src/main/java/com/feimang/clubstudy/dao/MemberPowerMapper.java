package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.MemberPower;

public interface MemberPowerMapper {
    int deleteByPrimaryKey(Integer powerid);

    int insert(MemberPower record);

    int insertSelective(MemberPower record);

    MemberPower selectByPrimaryKey(Integer powerid);

    int updateByPrimaryKeySelective(MemberPower record);

    int updateByPrimaryKey(MemberPower record);
}