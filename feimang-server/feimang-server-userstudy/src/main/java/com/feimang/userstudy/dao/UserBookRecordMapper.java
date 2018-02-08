package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookRecord;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBookRecordMapper {
    int deleteByPrimaryKey(Long recordid);

    int insert(UserBookRecord record);

    int insertSelective(UserBookRecord record);

    UserBookRecord selectByPrimaryKey(Long recordid);

    int updateByPrimaryKeySelective(UserBookRecord record);

    int updateByPrimaryKey(UserBookRecord record);
    // 获取推荐列表
    List<UserBookRecord> getRecommendBooksByUserID(Long userId);
    // 根据用户id和图书id 查询是否存在
    UserBookRecord selectByUserIdAndBookId(@Param("userId") Long userId,@Param("bookId") Long bookId);
    // 获取用户的书拍列表
    List<UserBookRecord> getBookPhotos(Long userId);
    // 修改delflg 改成已删除 1
    int updateDelflgById(@Param("userBookRecordList") List<UserBookRecord> userBookRecordList);
    // 修改书拍的delflg 改成已删除
    int updateBookPhotoDelflgByRecordID(Long recordId);
    // 根据ids 查询推荐图书列表
    List<UserBookRecord> getRecommendBooksByIds(@Param("ids") List<String> ids);
    // 根据ids 查询书拍列表
    List<UserBookRecord> getBookPhotosByIds(@Param("ids")List<String> ids);

}