package com.feimang.month.dao;

import com.feimang.month.pojo.BookTagRel;

public interface BookTagRelMapper {
    int deleteByPrimaryKey(Long tbid);

    int insert(BookTagRel record);

    int insertSelective(BookTagRel record);

    BookTagRel selectByPrimaryKey(Long tbid);

    int updateByPrimaryKeySelective(BookTagRel record);

    int updateByPrimaryKey(BookTagRel record);
}