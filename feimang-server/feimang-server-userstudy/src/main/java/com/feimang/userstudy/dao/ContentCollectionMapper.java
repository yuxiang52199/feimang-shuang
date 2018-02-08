package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentCollection;

import java.util.List;

public interface ContentCollectionMapper {
    int deleteByPrimaryKey(Long collectionid);

    int insert(ContentCollection record);

    int insertSelective(ContentCollection record);

    ContentCollection selectByPrimaryKey(Long collectionid);

    int updateByPrimaryKeySelective(ContentCollection record);

    int updateByPrimaryKey(ContentCollection record);
    // 查询是否存在
    ContentCollection selectByFromuidAndContentbaseId(ContentCollection contentCollection);
    // 查询收藏书拍列表
    List<ContentCollection> selectAllByFromUid(Long userId);
    // 更新书拍收藏数量-1
    void delShareCount(Long contentBaseid);
    // 更新书拍收藏数量+1
    void addShareCount(Long contentBaseid);
}