package com.feimang.book.dao;

import com.feimang.book.pojo.BookInfo;

import java.util.List;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Long bookid);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Long bookid);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

    List<BookInfo> getBooksByBookIds(List<String> bookIdList);
}