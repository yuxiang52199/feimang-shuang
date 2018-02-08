package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.*;
import com.feimang.userstudy.pojo.*;
import com.feimang.userstudy.service.IContentBaseService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yxm on 2018/2/6
 */
@Service("contentBaseService")
public class ContentBaseServiceImpl implements IContentBaseService{

    @Autowired
    private ContentBaseMapper contentBaseMapper;

    @Autowired
    private ContentCollectionMapper contentCollectionMapper;

    @Autowired
    private ContentReviewMapper contentReviewMapper;

    @Autowired
    private ContentReviewLikesMapper contentReviewLikesMapper;

    @Autowired
    private ContentReplyMapper contentReplyMapper;

    /**
     * 书拍点赞
     * @param contentBaseid
     * @return
     */
    public ServerResponse addLikeCount(Long contentBaseid){
        if (contentBaseid == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ContentBase contentBase = contentBaseMapper.selectByPrimaryKey(contentBaseid);
        if (contentBase == null){
            return ServerResponse.createByErrorMessage("该记录不存在");
        }
        contentBase.setLikecount(contentBase.getLikecount()+1);
        contentBaseMapper.updateByPrimaryKeySelective(contentBase);
        return ServerResponse.createBySuccess("点赞成功");
    }

    /**
     * 取消书拍点赞
     * @param contentBaseid
     * @return
     */
    public ServerResponse delLikeCount(Long contentBaseid){
        if (contentBaseid == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ContentBase contentBase = contentBaseMapper.selectByPrimaryKey(contentBaseid);
        if (contentBase == null){
            return ServerResponse.createByErrorMessage("该记录不存在");
        }
        contentBase.setLikecount(contentBase.getLikecount()-1);
        contentBaseMapper.updateByPrimaryKeySelective(contentBase);
        return ServerResponse.createBySuccess("取消点赞成功");
    }

    /**
     * 获取书拍的点赞 收藏详情
     * @param contentBaseid
     * @return
     */
    public ServerResponse getContentBase(Long contentBaseid){
        if (contentBaseid == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ContentBase contentBase = contentBaseMapper.selectByPrimaryKey(contentBaseid);
        if (contentBase == null){
            return ServerResponse.createByErrorMessage("该记录不存在");
        }
        return ServerResponse.createBySuccess("查询成功",contentBase);
    }

    /**
     * 收藏书拍
     * @param contentCollection
     * @return
     */
    public ServerResponse addCollection(ContentCollection contentCollection){
        if (contentCollection == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ServerResponse serverResponse = isCollection(contentCollection);
        if (serverResponse.isSuccess()){
            return ServerResponse.createByErrorMessage("已收藏该书拍");
        }
        int resultCount = contentCollectionMapper.insert(contentCollection);
        if (resultCount > 0){
            return ServerResponse.createBySuccess("收藏成功");
        }
        return ServerResponse.createByErrorMessage("收藏失败");
    }

    /**
     * 判断是否收藏书拍
     * @param contentCollection
     * @return
     */
    public ServerResponse isCollection(ContentCollection contentCollection){
        if (contentCollection == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ContentCollection contentCollection1 =contentCollectionMapper.selectByFromuidAndContentbaseId(contentCollection);
        if (contentCollection1 != null){
            return ServerResponse.createBySuccess("已收藏图书",contentCollection1);
        }
        return ServerResponse.createByErrorMessage("未收藏图书");
    }

    /**
     * 取消收藏书拍
     * @param collectionID
     * @return
     */
    public ServerResponse delCollection(Long collectionID){
        if (collectionID == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ContentCollection contentCollection = contentCollectionMapper.selectByPrimaryKey(collectionID);
        if (contentCollection == null){
            return ServerResponse.createByErrorMessage("未关注此书拍");
        }
        contentCollectionMapper.deleteByPrimaryKey(collectionID);
        return ServerResponse.createBySuccess("取消收藏书拍");
    }

    /**
     * 获取收藏书拍列表  分页获取
     * @param userId
     * @return
     */
    public ServerResponse getCollection(Long userId,int pageNum,int pageSize){
        if (userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ContentCollection> contentCollections = contentCollectionMapper.selectAllByFromUid(userId);
        if (CollectionUtils.isNotEmpty(contentCollections)){
            return ServerResponse.createBySuccess("查询成功",contentCollections);
        }
        return ServerResponse.createByErrorMessage("用户未收藏书拍");
    }

    /**
     * 添加书拍评论
     * @param contentReview
     * @return
     */
    public ServerResponse addReview(ContentReview contentReview){
        if (contentReview == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        contentReview.setLikecount(0);//设置点赞数量
        contentReview.setRewcount(0);//设置评论数量
        //添加评论
        contentReviewMapper.insert(contentReview);
        //更新该书拍的评论数量
        contentBaseMapper.updateRewCountByContentBaseID(contentReview.getContentBaseid());
        return ServerResponse.createBySuccess("评论成功");
    }

    /**
     * 一级评论点赞
     * @return
     */
    public ServerResponse addReviewLikes(ContentReviewLikes contentReviewLikes){
        if (contentReviewLikes == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ServerResponse serverResponse = isReviewLikes(contentReviewLikes);
        if (serverResponse.isSuccess()){
            return ServerResponse.createByErrorMessage("用户已经赞过评论了");
        }
        //添加评论
        contentReviewLikesMapper.insert(contentReviewLikes);
        //更新该条评论的点赞数
        contentReviewMapper.updateLikeCountByReviewID(contentReviewLikes.getReviewid());
        return ServerResponse.createBySuccess("点赞成功");
    }

    /**
     * 判断是否一级点赞
     * @param contentReviewLikes
     * @return
     */
    public ServerResponse isReviewLikes(ContentReviewLikes contentReviewLikes){
        if (contentReviewLikes == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ContentReviewLikes contentReviewLikes1 =contentReviewLikesMapper.selectByUserIdAndReviewID(contentReviewLikes);
        if (contentReviewLikes1 !=null){
            return ServerResponse.createBySuccess("用户已点赞该评论",contentReviewLikes1);
        }
        return ServerResponse.createByErrorMessage("用户未点赞该评论");
    }

    /**
     * 取消一级评论点赞
     * @param contentReviewLikes
     * @return
     */
    public ServerResponse delReviewLikes(ContentReviewLikes contentReviewLikes){
        if (contentReviewLikes == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        // 删除点赞
        contentReviewLikesMapper.delByUserIDAndReviewID(contentReviewLikes);
        // 更新评论的点赞数量
        contentReviewMapper.updateLikeCountByReviewID(contentReviewLikes.getReviewid());
        return ServerResponse.createBySuccess("取消点赞成功");
    }

    /**
     * 添加评论回复
     * @param contentReply
     * @return
     */
    public ServerResponse addReply(ContentReply contentReply){
        if (contentReply == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        if (contentReply.getTouid() == null || contentReply.getTouid()==0){
            contentReply.setTouid(Long.valueOf(0));//设置为 留言
            contentReplyMapper.insert(contentReply);
            return ServerResponse.createBySuccess("留言成功");
        }
        contentReplyMapper.insert(contentReply);
        return ServerResponse.createBySuccess("回复成功");
    }
}
