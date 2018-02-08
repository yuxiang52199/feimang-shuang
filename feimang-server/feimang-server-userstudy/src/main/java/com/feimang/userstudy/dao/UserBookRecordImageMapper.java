package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookRecord;
import com.feimang.userstudy.pojo.UserBookRecordImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBookRecordImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBookRecordImage record);

    int insertSelective(UserBookRecordImage record);

    UserBookRecordImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBookRecordImage record);

    int updateByPrimaryKeyWithBLOBs(UserBookRecordImage record);

    int updateByPrimaryKey(UserBookRecordImage record);
    // 根据recordid 获取 书拍图片
    List<UserBookRecordImage> getImageByRecordId(@Param("userBookRecordList") List<UserBookRecord> userBookRecordList);

    int updateDelflgByBookIdAndUserIdAndRecordID(@Param("bookid") Long bookid,@Param("fromuid")Long fromuid,@Param("recordId")Long recordId);
}