package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.RcMessage;

public interface RcMessageMapper {
    int deleteByPrimaryKey(Long clubmessageid);

    int insert(RcMessage record);

    int insertSelective(RcMessage record);

    RcMessage selectByPrimaryKey(Long clubmessageid);

    int updateByPrimaryKeySelective(RcMessage record);

    int updateByPrimaryKey(RcMessage record);
}