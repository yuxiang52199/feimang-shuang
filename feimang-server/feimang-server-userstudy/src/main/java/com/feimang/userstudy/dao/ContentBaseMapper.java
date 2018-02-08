package com.feimang.userstudy.dao;

import com.feimang.userstudy.pojo.ContentBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentBaseMapper {
    int deleteByPrimaryKey(Long contentBaseid);

    int insert(ContentBase record);

    int insertSelective(ContentBase record);

    ContentBase selectByPrimaryKey(Long contentBaseid);

    int updateByPrimaryKeySelective(ContentBase record);

    int updateByPrimaryKeyWithBLOBs(ContentBase record);

    int updateByPrimaryKey(ContentBase record);
    // 根据主键 修改评论数量
    void updateRewCountByContentBaseID(Long contentBaseid);
    //根据ids获取列表
    List<ContentBase> getListByIds(@Param("ids") List<String> ids);
}