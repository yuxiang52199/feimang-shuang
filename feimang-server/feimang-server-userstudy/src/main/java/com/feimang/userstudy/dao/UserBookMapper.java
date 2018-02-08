package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.BooktagRelation;
import com.feimang.userstudy.pojo.UserBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBookMapper {
    int deleteByPrimaryKey(Integer ubid);

    int insert(UserBook record);

    int insertSelective(UserBook record);

    UserBook selectByPrimaryKey(Integer ubid);

    int updateByPrimaryKeySelective(UserBook record);

    int updateByPrimaryKey(UserBook record);
    // 向userbook表插入数据
    void addUserBook(@Param("userBooks") List<UserBook> userBooks);
    // 检查是否有错误数据 有的话 改错
    void checkError(Long userId);
}