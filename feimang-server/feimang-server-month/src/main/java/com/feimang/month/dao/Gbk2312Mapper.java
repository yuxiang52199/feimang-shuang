package com.feimang.month.dao;

import com.feimang.month.pojo.Gbk2312;

import java.util.List;

public interface Gbk2312Mapper {
    int deleteByPrimaryKey(Long id);

    int insert(Gbk2312 record);

    int insertSelective(Gbk2312 record);

    Gbk2312 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Gbk2312 record);

    int updateByPrimaryKey(Gbk2312 record);

    List<Gbk2312> getGbk2312ListRandom();
}