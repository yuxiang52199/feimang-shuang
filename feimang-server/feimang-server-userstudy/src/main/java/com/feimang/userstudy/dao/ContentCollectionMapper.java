package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentCollection;

public interface ContentCollectionMapper {
    int deleteByPrimaryKey(Long collectionid);

    int insert(ContentCollection record);

    int insertSelective(ContentCollection record);

    ContentCollection selectByPrimaryKey(Long collectionid);

    int updateByPrimaryKeySelective(ContentCollection record);

    int updateByPrimaryKey(ContentCollection record);
}