package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookPerfect;
import com.feimang.userstudy.pojo.UserBookPerfectWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBookPerfectMapper {
    int deleteByPrimaryKey(Long perfectid);

    int insert(UserBookPerfectWithBLOBs record);

    int insertSelective(UserBookPerfectWithBLOBs record);

    UserBookPerfectWithBLOBs selectByPrimaryKey(Long perfectid);

    int updateByPrimaryKeySelective(UserBookPerfectWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserBookPerfectWithBLOBs record);

    int updateByPrimaryKey(UserBookPerfect record);
    // 根据用户id和图书id查询完善信息
    UserBookPerfect selectPerfectBookByUserIDAndBookID(@Param("userId") Long userId,@Param("bookId") Integer bookId);

    List<UserBookPerfect> getPerfectBooksByUserID(Long userId);
}