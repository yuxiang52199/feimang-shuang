package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.Const;
import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.FriendsRelationMapper;
import com.feimang.userstudy.pojo.FriendsRelation;
import com.feimang.userstudy.service.IFriendsRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yxm on 2018/1/29
 */
@Service("friendsRelationService")
public class FriendsRelationServiceImpl implements IFriendsRelationService{

    @Autowired
    private FriendsRelationMapper friendsRelationMapper;
    // region 获取粉丝 关注列表
    /**
     * 获取关注列表
     * @param userId 用户id
     * @return
     */
    public ServerResponse getAttens(Long userId,int pageNum,int pageSize){
        if (userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<FriendsRelation> friendsRelationList = friendsRelationMapper.getAttens(userId);
        if (CollectionUtils.isNotEmpty(friendsRelationList)){
            //todo 使用被关注id 查询用户信息
            PageInfo pageInfo = new PageInfo(friendsRelationList);
            return ServerResponse.createBySuccess("查询成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("用户未关注好友");
    }

    /**
     * 获取粉丝列表
     * @param userId
     * @return
     */
    public ServerResponse getFans(Long userId,int pageNum,int pageSize){
        if (userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<FriendsRelation> friendsRelationList = friendsRelationMapper.getFans(userId);
        if (CollectionUtils.isNotEmpty(friendsRelationList)){
            //todo 使用粉丝id 查询用户信息
            PageInfo pageInfo = new PageInfo(friendsRelationList);
            return ServerResponse.createBySuccess("查询成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("用户还未被关注");
    }

    /**
     * 获取屏蔽列表
     * @param userId
     * @return
     */
    public ServerResponse getScreens(Long userId,int pageNum,int pageSize){
        if (userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<FriendsRelation> friendsRelations = friendsRelationMapper.getScreens(userId);
        if (CollectionUtils.isNotEmpty(friendsRelations)){
            PageInfo pageInfo = new PageInfo(friendsRelations);
            return ServerResponse.createBySuccess("查询成功",pageInfo);
        }
        return ServerResponse.createByErrorMessage("未屏蔽用户");
    }

    /**
     * 添加屏蔽用户
     * @param userID
     * @param screenID
     * @return
     */
    public ServerResponse addScreen(Long userID,Long screenID){
        if (userID == null || screenID == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        friendsRelationMapper.addScreen(userID, screenID);
        return ServerResponse.createBySuccess("屏蔽成功");
    }

    /**
     * 取消屏蔽用户
     * @param userID
     * @param screenID
     * @return
     */
    public ServerResponse delScreen(Long userID,Long screenID){
        if (userID == null || screenID == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        friendsRelationMapper.delScreen(userID, screenID);
        return ServerResponse.createBySuccess("取消屏蔽成功");
    }
    //endregion
    //region 关注好友 相关
    /**
     * 判断是否关注
     * @param userId 用户id
     * @param attentionuid 关注者id
     * @return
     */
    public ServerResponse<FriendsRelation> isAttenUserByAttentionuid(Long userId,Long attentionuid){
        if (attentionuid == null || userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        FriendsRelation friendsRelation = friendsRelationMapper.isAttenUserByAttentionuid(userId, attentionuid);
        if (friendsRelation !=null){
            return ServerResponse.createBySuccess("用户已关注",friendsRelation);
        }
        return ServerResponse.createByErrorMessage("用户未关注");
    }

    /**
     * 添加关注
     * @param userId 用户id
     * @param attentionuid 关注者id
     * @return
     */
    public ServerResponse addFriends(Long userId,Long attentionuid){
        if (attentionuid == null || userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ServerResponse serverResponse = isAttenUserByAttentionuid(attentionuid,userId);//验证被关注者是否关注当前用户
        if (serverResponse.isSuccess()){
            //被关注者 关注了当前用户
            Object attentionFriend = serverResponse.getData();
            FriendsRelation friend = (FriendsRelation) attentionFriend;
            FriendsRelation friendsRelation = new FriendsRelation();
            friendsRelation.setFromuid(userId);
            friendsRelation.setAttentionuid(attentionuid);
            friendsRelation.setLinkstatus(Const.FriendnslinkStatus.MUTUAL_CONCERN.getCode());//设置权限为互相关注
            int resultCount = friendsRelationMapper.insert(friendsRelation);
            if (resultCount > 0){
                //关注成功  更改被关注者关注当前用户的状态为 互相关注
                friend.setLinkstatus(Const.FriendnslinkStatus.MUTUAL_CONCERN.getCode());
                int rowCount = friendsRelationMapper.updateByPrimaryKey(friend);
                if (rowCount > 0){
                    return ServerResponse.createBySuccess("关注成功");
                }
                //todo 更改失败 回退rollback
            }
            return ServerResponse.createByErrorMessage("关注失败");
        }
        // 被关注者未关注当前用户
        FriendsRelation friendsRelation = new FriendsRelation();
        friendsRelation.setFromuid(userId);
        friendsRelation.setAttentionuid(attentionuid);
        friendsRelation.setLinkstatus(Const.FriendnslinkStatus.UNILATERRAL_CONCERN.getCode());//设置状态为 非互相关注
        int resultCount = friendsRelationMapper.insert(friendsRelation);
        if (resultCount > 0){
            return ServerResponse.createBySuccess("关注成功");
        }
        return ServerResponse.createByErrorMessage("关注失败");
    }

    /**
     * 取消关注
     * @param userId 用户id
     * @param attentionuid 被关注者id
     * @return
     */
    public ServerResponse delFriendsByUserIdAndAttentionuid(Long userId,Long attentionuid){
        if (attentionuid == null || userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ServerResponse serverResponse = isAttenUserByAttentionuid(attentionuid,userId);// 查看被关注者是否关注当前用户
        if (serverResponse.isSuccess()){
            //被关注者 关注了当前用户
            Object attentionFriend = serverResponse.getData();//被关注者关注当前用户的实体
            FriendsRelation friend = (FriendsRelation) attentionFriend;
            //删除当前用户关注记录
            int resultCount = friendsRelationMapper.delFriendsByUserIdAndAttentionuid(userId, attentionuid);
            if (resultCount > 0){
                //删除成功
                //修改被关注者关注当前用户的状态
                friend.setLinkstatus(Const.FriendnslinkStatus.UNILATERRAL_CONCERN.getCode());//设置为 非互相关注
                int rowCount = friendsRelationMapper.updateByPrimaryKey(friend);
                if (resultCount > 0){
                    return ServerResponse.createBySuccess("取消关注成功");
                }
                //todo 做rollback处理
            }
            return ServerResponse.createByErrorMessage("取消关注失败");
        }
        int resultCount = friendsRelationMapper.delFriendsByUserIdAndAttentionuid(userId, attentionuid);
        if (resultCount > 0){
            return ServerResponse.createBySuccess("取消关注成功");
        }
        return ServerResponse.createByErrorMessage("取消关注失败");
    }
    //endregion
}
