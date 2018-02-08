package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.ClubInfo;

public interface ClubInfoMapper {
    int deleteByPrimaryKey(Long clubid);

    int insert(ClubInfo record);

    int insertSelective(ClubInfo record);

    ClubInfo selectByPrimaryKey(Long clubid);

    int updateByPrimaryKeySelective(ClubInfo record);

    int updateByPrimaryKey(ClubInfo record);
}