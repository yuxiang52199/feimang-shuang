package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookRemark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBookRemarkMapper {
    int deleteByPrimaryKey(Long remarkid);

    int insert(UserBookRemark record);

    int insertSelective(UserBookRemark record);

    UserBookRemark selectByPrimaryKey(Long remarkid);

    int updateByPrimaryKeySelective(UserBookRemark record);

    int updateByPrimaryKey(UserBookRemark record);
    // 根据用户id和图书id查询
    UserBookRemark getRemarkByFromidAndBookID(@Param("fromuid") Long fromuid,@Param("bookid")Long bookid);
    // 获取备注图书列表
    List<UserBookRemark> getBookRemarksByFromuid(Long fromuid);
}