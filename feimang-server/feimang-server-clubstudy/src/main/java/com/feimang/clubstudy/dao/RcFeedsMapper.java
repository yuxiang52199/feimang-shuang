package com.feimang.clubstudy.dao;

import com.feimang.clubstudy.pojo.RcFeeds;

public interface RcFeedsMapper {
    int deleteByPrimaryKey(Long clubfeedsid);

    int insert(RcFeeds record);

    int insertSelective(RcFeeds record);

    RcFeeds selectByPrimaryKey(Long clubfeedsid);

    int updateByPrimaryKeySelective(RcFeeds record);

    int updateByPrimaryKey(RcFeeds record);
}