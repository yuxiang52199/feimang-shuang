package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.*;
import com.feimang.userstudy.pojo.*;
import com.feimang.userstudy.service.IContentBaseService;
import com.feimang.userstudy.vo.ContentReviewVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    // region 书拍点赞相关
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
    // endregion
    //region 收藏书拍相关
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
            //修改书拍的收藏数量+1
            contentCollectionMapper.addShareCount(contentCollection.getContentBaseid());

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
        //修改书拍的收藏数量-1
        contentCollectionMapper.delShareCount(contentCollection.getContentBaseid());
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
            PageInfo pageInfo = new PageInfo(contentCollections);
            return ServerResponse.createBySuccess("查询成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("用户未收藏书拍");
    }
    //endregion
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
    //region 一级评论点赞相关
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
        ContentReview contentReview = contentReviewMapper.selectByPrimaryKey(contentReviewLikes.getReviewid());
        contentReview.setLikecount(contentReview.getLikecount()+1);
        contentReviewMapper.updateByPrimaryKeySelective(contentReview);
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
        // 更新评论的点赞数量-1
        ContentReview contentReview = contentReviewMapper.selectByPrimaryKey(contentReviewLikes.getReviewid());
        contentReview.setLikecount(contentReview.getLikecount()-1);
        contentReviewMapper.updateByPrimaryKeySelective(contentReview);
        return ServerResponse.createBySuccess("取消点赞成功");
    }
    //endregion
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
        //增加一级评论的回复数量
        ContentReview contentReview = contentReviewMapper.selectByPrimaryKey(contentReply.getReviewid());
        contentReview.setRewcount(contentReview.getRewcount()+1);
        return ServerResponse.createBySuccess("回复成功");
    }

    /**
     * 根据ids获取列表
     * @param ids
     * @return
     */
    public ServerResponse getListByIds(String ids){
        //region
        if (ids == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        String [] arr = ids.split(",");
        List<String> stringList = new ArrayList<>();
        for (int i=0; i<arr.length;i++){
            stringList.add(arr[i]);
        }
        List<ContentBase> contentBases = contentBaseMapper.getListByIds(stringList);
        if (CollectionUtils.isNotEmpty(contentBases)){
            return ServerResponse.createBySuccess("查询成功",contentBases);
        }
        return ServerResponse.createByErrorMessage("查询失败");
        //endregion
    }
    //region 获取一 二级评论
    /**
     * 获取一级评论
     * @param contentBaseId
     * @return
     */
    public ServerResponse getReviews(Long contentBaseId,int pageNum,int pageSize){
        if (contentBaseId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ContentReview> contentReviewList = contentReviewMapper.getReviews(contentBaseId);
        // 将contentReviewlist转换成vo
        if (CollectionUtils.isNotEmpty(contentReviewList)){
            List<ContentReviewVO> contentReviewVOList = new ArrayList<>();
            for (ContentReview contentReview : contentReviewList){
                ContentReviewVO contentReviewVO = new ContentReviewVO();
                contentReviewVO.setContentBaseid(contentReview.getContentBaseid());
                contentReviewVO.setCreatetime(contentReview.getCreatetime());
                contentReviewVO.setFromuid(contentReview.getFromuid());
                contentReviewVO.setLikecount(contentReview.getLikecount());
                contentReviewVO.setReviewid(contentReview.getReviewid());
                contentReviewVO.setRewcontent(contentReview.getRewcontent());
                contentReviewVO.setRewcount(contentReview.getRewcount());
                // 判断一级回复是否有二级回复 若有 只显示三条二级回复
                if (contentReview.getRewcount()>0){
                    List<ContentReply> contentReplies = contentReplyMapper.getReplysLimitByReviewID(contentReview.getReviewid());
                    contentReviewVO.setContentReplyList(contentReplies);
                }
                contentReviewVOList.add(contentReviewVO);
            }
            PageInfo pageInfo = new PageInfo(contentReviewVOList);
            return ServerResponse.createBySuccess("查询成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("该书拍未有评论");
    }

    /**
     * 获取二级评论
     * @param reviewid
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse getReplys(Long reviewid,int pageNum,int pageSize){
        if (reviewid==null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ContentReply> contentReplyList = contentReplyMapper.getReplysByReviewID(reviewid);
        if (CollectionUtils.isNotEmpty(contentReplyList)){
            PageInfo pageInfo = new PageInfo(contentReplyList);
            return ServerResponse.createBySuccess("查询成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("查询失败");
    }
    //endregion
}
