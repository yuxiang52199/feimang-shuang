package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.UserBookRecordAtuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yxm on 2018/2/8
 */
public interface UserBookRecordAtuserMapper {
    int deleteByPrimaryKey(Long atid);

    int insert(UserBookRecordAtuser record);

    int insertSelective(UserBookRecordAtuser record);

    UserBookRecordAtuser selectByPrimaryKey(Long atid);

    int updateByPrimaryKeySelective(UserBookRecordAtuser record);

    int updateByPrimaryKey(UserBookRecordAtuser record);
    // 插入@人
    void addAtuser(@Param("userBookRecordAtusers") List<UserBookRecordAtuser> userBookRecordAtusers);
    // 获取所有被@的信息
    List<UserBookRecordAtuser> getAtusersByTouid(Long touid);
}
