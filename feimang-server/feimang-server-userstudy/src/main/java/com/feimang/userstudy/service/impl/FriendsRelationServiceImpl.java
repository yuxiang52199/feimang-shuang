package com.feimang.userstudy.service.impl;

import com.feimang.userstudy.common.ResponseCode;
import com.feimang.userstudy.common.ServerResponse;
import com.feimang.userstudy.dao.FriendsRelationMapper;
import com.feimang.userstudy.pojo.FriendsRelation;
import com.feimang.userstudy.service.IFriendsRelationService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yxm on 2018/1/29
 */
@Service("iFriendsRelationService")
public class FriendsRelationServiceImpl implements IFriendsRelationService{

    @Autowired
    private FriendsRelationMapper friendsRelationMapper;
    /**
     * 获取关注列表
     * @param userId 用户id
     * @return
     */
    public ServerResponse getAttens(Long userId){
        if (userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        List<FriendsRelation> friendsRelationList = friendsRelationMapper.getAttens(userId);
        if (CollectionUtils.isNotEmpty(friendsRelationList)){
            //todo 使用被关注id 查询用户信息
            return ServerResponse.createBySuccess("查询成功",friendsRelationList);
        }
        return ServerResponse.createByErrorMessage("用户未关注好友");
    }

    /**
     * 获取粉丝列表
     * @param userId
     * @return
     */
    public ServerResponse getFans(Long userId){
        if (userId == null){
            //参数为空
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        List<FriendsRelation> friendsRelationList = friendsRelationMapper.getFans(userId);
        if (CollectionUtils.isNotEmpty(friendsRelationList)){
            //todo 使用粉丝id 查询用户信息
            return ServerResponse.createBySuccess("查询成功",friendsRelationList);
        }
        return ServerResponse.createByErrorMessage("用户还未被关注");
    }
}
