package com.feimang.userstudy.service;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.ContentCollection;
import com.feimang.userstudy.pojo.ContentReply;
import com.feimang.userstudy.pojo.ContentReview;
import com.feimang.userstudy.pojo.ContentReviewLikes;

/**
 * Created by yxm on 2018/2/6
 */
public interface IContentBaseService {
    // 书拍点赞
    ServerResponse addLikeCount(Long contentBaseid);
    // 取消书拍点赞
    ServerResponse delLikeCount(Long contentBaseid);
    // 获取书拍的点赞 收藏 详情
    ServerResponse getContentBase(Long contentBaseid);
    // 判断是否收藏书拍
    ServerResponse isCollection(ContentCollection contentCollection);
    // 收藏书拍
    ServerResponse addCollection(ContentCollection contentCollection);
    // 取消收藏书拍
    ServerResponse delCollection(Long collectionID);
    // 获取收藏的书拍列表
    ServerResponse getCollection(Long userId,int pageNum,int pageSize);
    // 添加书拍评论
    ServerResponse addReview(ContentReview contentReview);
    // 判断用户是否点赞评论
    ServerResponse isReviewLikes(ContentReviewLikes contentReviewLikes);
    // 一级评论的点赞
    ServerResponse addReviewLikes(ContentReviewLikes contentReviewLikes);
    // 取消一级点赞
    ServerResponse delReviewLikes(ContentReviewLikes contentReviewLikes);
    // 添加评论回复
    ServerResponse addReply(ContentReply contentReply);
    // 获取二级评论列表
    ServerResponse getReplys(Long reviewid,int pageNum,int pageSize);
    // 获取一级评论列表
    ServerResponse getReviews(Long contentBaseId,int pageNum,int pageSize);
}
