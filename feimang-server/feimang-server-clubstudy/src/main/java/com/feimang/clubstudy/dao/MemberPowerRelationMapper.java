package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.MemberPowerRelation;

public interface MemberPowerRelationMapper {
    int deleteByPrimaryKey(Integer rpid);

    int insert(MemberPowerRelation record);

    int insertSelective(MemberPowerRelation record);

    MemberPowerRelation selectByPrimaryKey(Integer rpid);

    int updateByPrimaryKeySelective(MemberPowerRelation record);

    int updateByPrimaryKey(MemberPowerRelation record);

    int deleteByMemberId(Long memberId);

}