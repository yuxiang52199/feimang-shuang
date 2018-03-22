package com.feimang.month.dao;

import com.feimang.month.pojo.UserKlStruct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserKlStructMapper {
    int deleteByPrimaryKey(Long tsid);

    int insert(UserKlStruct record);

    int insertSelective(UserKlStruct record);

    UserKlStruct selectByPrimaryKey(Long tsid);

    int updateByPrimaryKeySelective(UserKlStruct record);

    int updateByPrimaryKey(UserKlStruct record);

    void insertUserKlStructBatch(@Param("userBooks") List<UserKlStruct> userKlStructList);

    List<UserKlStruct> selectListByUserId(Long userId);
}