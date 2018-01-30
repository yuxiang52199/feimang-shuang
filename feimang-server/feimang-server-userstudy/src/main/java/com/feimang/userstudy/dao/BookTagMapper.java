package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.BookTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookTagMapper {
    int deleteByPrimaryKey(Integer utid);

    int insert(BookTag record);

    int insertSelective(BookTag record);

    BookTag selectByPrimaryKey(Integer utid);

    int updateByPrimaryKeySelective(BookTag record);

    int updateByPrimaryKey(BookTag record);
    //获取书架列表
    List<BookTag> getBookTags(Long userId);
    //更新书架排序
    int editBookTag(@Param("userId") Long userId,@Param("bookTagList")List<BookTag> bookTagList);
}