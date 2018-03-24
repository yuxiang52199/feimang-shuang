package com.feimang.month.dao;

import com.feimang.month.pojo.BookLv;

public interface BookLvMapper {
    int deleteByPrimaryKey(Long lvid);

    int insert(BookLv record);

    int insertSelective(BookLv record);

    BookLv selectByPrimaryKey(Long lvid);

    int updateByPrimaryKeySelective(BookLv record);

    int updateByPrimaryKey(BookLv record);
}