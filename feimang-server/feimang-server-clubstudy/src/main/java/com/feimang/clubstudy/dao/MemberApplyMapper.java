package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.MemberApply;

import java.util.List;
import java.util.Map;

public interface MemberApplyMapper {
    int deleteByPrimaryKey(Long applyid);

    int insert(MemberApply record);

    int insertSelective(MemberApply record);

    MemberApply selectByPrimaryKey(Long applyid);

    int updateByPrimaryKeySelective(MemberApply record);

    int updateByPrimaryKey(MemberApply record);

    int selectCountByMap(Map<String,Object> map);

    List<MemberApply> selectListByMap(Map<String,Object> map);
}