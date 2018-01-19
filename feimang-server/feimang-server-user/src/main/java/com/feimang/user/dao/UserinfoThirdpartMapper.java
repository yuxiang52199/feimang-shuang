package com.feimang.user.dao;

import com.feimang.user.pojo.UserinfoThirdpart;

public interface UserinfoThirdpartMapper {
    int deleteByPrimaryKey(Integer tpid);

    int insert(UserinfoThirdpart record);

    int insertSelective(UserinfoThirdpart record);

    UserinfoThirdpart selectByPrimaryKey(Integer tpid);

    int updateByPrimaryKeySelective(UserinfoThirdpart record);

    int updateByPrimaryKey(UserinfoThirdpart record);
}