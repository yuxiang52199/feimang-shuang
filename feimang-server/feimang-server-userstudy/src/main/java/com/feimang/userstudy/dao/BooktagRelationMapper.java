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
    List<BooktagRelation> getBooksByUTID(@Param("userId") Long userId,@Param("utid") Integer utid);
    // 书架内删除图书
    int delBookByUserIdAndId(@Param("booktagRelationList") List<BooktagRelation> booktagRelationList);
    // 书架内添加图书
    void addBookToBookTag(@Param("booktagRelations") List<BooktagRelation> booktagRelations);
    // 根据用户id和图书id查询,图书是否在书架内
    void checkBookRelation(@Param("bookid")Long bookid,@Param("fromuid")Long fromuid);
    // 书架内图书排序
    void editBookSeq(@Param("booktagRelationList") List<BooktagRelation> booktagRelationList);


}