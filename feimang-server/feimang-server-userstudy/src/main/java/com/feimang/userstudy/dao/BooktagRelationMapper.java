package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.BooktagRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BooktagRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BooktagRelation record);

    int insertSelective(BooktagRelation record);

    BooktagRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BooktagRelation record);

    int updateByPrimaryKey(BooktagRelation record);
    // 获取书架内图书列表
    List<BooktagRelation> getBooksByUTID(Integer utid);
    // 书架内删除图书
    int delBookByUserIdAndId(@Param("booktagRelationList") List<BooktagRelation> booktagRelationList);

    //int addBookByBookIdAndUTID(@Param());


}