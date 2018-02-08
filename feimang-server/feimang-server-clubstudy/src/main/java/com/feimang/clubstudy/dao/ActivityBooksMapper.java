package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.ActivityBooks;

import java.util.List;

public interface ActivityBooksMapper {
    int deleteByPrimaryKey(Integer abid);

    int insert(ActivityBooks record);

    int insertSelective(ActivityBooks record);

    ActivityBooks selectByPrimaryKey(Integer abid);

    int updateByPrimaryKeySelective(ActivityBooks record);

    int updateByPrimaryKey(ActivityBooks record);

    int insertByList(List<ActivityBooks> list);

    List<ActivityBooks> selectListByCaid(Long caid);
}