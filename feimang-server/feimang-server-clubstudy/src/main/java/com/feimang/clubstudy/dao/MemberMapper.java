package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.Member;

import java.util.List;
import java.util.Map;

public interface MemberMapper {
    int deleteByPrimaryKey(Long memberid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Long memberid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    List<Member> getMemberListByMap(Map<String,Object> map);
}