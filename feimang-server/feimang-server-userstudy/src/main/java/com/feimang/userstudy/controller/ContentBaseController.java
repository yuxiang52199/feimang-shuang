package com.feimang.userstudy.controller;

import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.pojo.ContentCollection;
import com.feimang.userstudy.pojo.ContentReply;
import com.feimang.userstudy.pojo.ContentReview;
import com.feimang.userstudy.pojo.ContentReviewLikes;
import com.feimang.userstudy.service.IContentBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yxm on 2018/2/6
 */
@RestController
public class ContentBaseController {

    @Autowired
    private IContentBaseService contentBaseService;
    /**
     * 书拍点赞
     * @param request
     * @param contentBaseid
     * @return
     */
    @PostMapping("/addLikeCount")
    public ServerResponse addLikeCount(HttpServletRequest request,Long contentBaseid){
        return contentBaseService.addLikeCount(contentBaseid);
    }

    /**
     * 取消书拍点赞
     * @param request
     * @param contentBaseid
     * @return
     */
    @DeleteMapping("/delLikeCount")
    public ServerResponse delLikeCount(HttpServletRequest request,Long contentBaseid){
        return contentBaseService.delLikeCount(contentBaseid);
    }

    /**
     * 获取书拍的点赞收藏详情
     * @param request
     * @param contentBaseid
     * @return
     */
    @GetMapping("/getContentBase")
    public ServerResponse getContentBase(HttpServletRequest request,Long contentBaseid){
        return contentBaseService.getContentBase(contentBaseid);
    }

    /**
     * 收藏书拍
     * @param request
     * @return
     */
    @PostMapping("/addCollection")
    public ServerResponse addCollection(HttpServletRequest request, ContentCollection contentCollection){
        return contentBaseService.addCollection(contentCollection);
    }

    /**
     * 判断是否收藏书拍
     * @param request
     * @param contentCollection
     * @return
     */
    @GetMapping("/isCollection")
    public ServerResponse isCollection(HttpServletRequest request,ContentCollection contentCollection){
        return contentBaseService.isCollection(contentCollection);
    }

    /**
     * 取消收藏书拍
     * @param request
     * @param collectionID
     * @return
     */
    @DeleteMapping("/delCollection")
    public ServerResponse delCollection(HttpServletRequest request,Long collectionID){
        return contentBaseService.delCollection(collectionID);
    }

    /**
     * 获取收藏书拍列表
     * @param request
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getCollection")
    public ServerResponse getCollection(HttpServletRequest request,Long userId,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        return contentBaseService.getCollection(userId, pageNum, pageSize);
    }

    /**
     * 添加书拍评论
     * @param request
     * @param contentReview
     * @return
     */
    @PostMapping("/addReview")
    public ServerResponse addReview(HttpServletRequest request, ContentReview contentReview){
        return contentBaseService.addReview(contentReview);
    }

    /**
     * 一级评论点赞
     * @param request
     * @param contentReviewLikes
     * @return
     */
    @PostMapping("/addReviewLikes")
    public ServerResponse addReviewLikes(HttpServletRequest request, ContentReviewLikes contentReviewLikes){
        return contentBaseService.addReviewLikes(contentReviewLikes);
    }

    /**
     * 判断是否一级评论点赞
     * @param request
     * @param contentReviewLikes
     * @return
     */
    @GetMapping("/isReviewLikes")
    public ServerResponse isReviewLikes(HttpServletRequest request,ContentReviewLikes contentReviewLikes){
        return contentBaseService.isReviewLikes(contentReviewLikes);
    }

    /**
     * 取消一级评论点赞
     * @param request
     * @param contentReviewLikes
     * @return
     */
    @DeleteMapping("/delReviewLikes")
    public ServerResponse delReviewLikes(HttpServletRequest request,ContentReviewLikes contentReviewLikes){
        return contentBaseService.delReviewLikes(contentReviewLikes);
    }

    /**
     * 添加评论回复
     * @param request
     * @param contentReply
     * @return
     */
    @PostMapping("/addReply")
    public ServerResponse addReply(HttpServletRequest request, ContentReply contentReply){
        return contentBaseService.addReply(contentReply);
    }
}
