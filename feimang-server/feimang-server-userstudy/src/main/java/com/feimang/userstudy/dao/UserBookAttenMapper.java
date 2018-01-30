package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookAtten;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBookAttenMapper {
    int deleteByPrimaryKey(Long atteninfoid);

    int insert(UserBookAtten record);

    int insertSelective(UserBookAtten record);

    UserBookAtten selectByPrimaryKey(Long atteninfoid);

    int updateByPrimaryKeySelective(UserBookAtten record);

    int updateByPrimaryKey(UserBookAtten record);

    // 查询用户关注的图书
    List<UserBookAtten> getAttendBooksByUserId(Long userId);
    //判断是否关注图书
    UserBookAtten isAttenBookByUserIDAndBookID(@Param("userId") Long userId, @Param("bookId") Integer bookId);
    //取消关注图书
    int delAttenByUserIdAndBookId(@Param("userId") Long userId, @Param("bookId") Integer bookId);
}