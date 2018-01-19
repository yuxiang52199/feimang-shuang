package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentBase;

public interface ContentBaseMapper {
    int deleteByPrimaryKey(Long contentBaseid);

    int insert(ContentBase record);

    int insertSelective(ContentBase record);

    ContentBase selectByPrimaryKey(Long contentBaseid);

    int updateByPrimaryKeySelective(ContentBase record);

    int updateByPrimaryKeyWithBLOBs(ContentBase record);

    int updateByPrimaryKey(ContentBase record);
}