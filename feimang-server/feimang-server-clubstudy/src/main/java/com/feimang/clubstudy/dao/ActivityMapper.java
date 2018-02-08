package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityMapper {
    int deleteByPrimaryKey(Long caid);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Long caid);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKeyWithBLOBs(Activity record);

    int updateByPrimaryKey(Activity record);

    List<Activity> selectListByMap(Map<String,Object> map);

    int selectCountByMap(Map<String,Object> map);

    List<Activity> selectListByCaids(List<String> caidList);

    Long insertAndGetId(Activity record);
}