package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.BookTagAtten;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookTagAttenMapper {
    int deleteByPrimaryKey(Long attenid);

    int insert(BookTagAtten record);

    int insertSelective(BookTagAtten record);

    BookTagAtten selectByPrimaryKey(Long attenid);

    int updateByPrimaryKeySelective(BookTagAtten record);

    int updateByPrimaryKey(BookTagAtten record);
    //获取用户关注的书架列表
    List<BookTagAtten> getAttenBookTags(Long userId);
    //判断用户是否关注书架
    BookTagAtten isAttenBookTagByUserIdAndUtid(@Param("userId") Long userId, @Param("utid") Long utid);

}