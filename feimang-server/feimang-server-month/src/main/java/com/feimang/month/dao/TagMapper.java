package com.feimang.month.dao;

import com.feimang.month.pojo.Tag;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tagid);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagid);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> selectListByPrimaryKlid(Integer klid);
}