package com.feimang.user.service.impl;

import com.feimang.user.common.ResponseCode;
import com.feimang.user.common.ServerResponse;

import com.feimang.user.dao.UserInfoMapper;
import com.feimang.user.dao.UserinfoThirdpartMapper;
import com.feimang.user.pojo.UserInfo;
import com.feimang.user.pojo.UserinfoThirdpart;
import com.feimang.user.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.*;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserinfoThirdpartMapper userinfoThirdpartMapper;


    @Override
    public ServerResponse<UserInfo> getUserByUserName(String username) {
        return null;
    }

    @Override
    public ServerResponse<UserInfo> getUserByThirdId(String thirdId) {
        return null;
    }

    @Override
    public ServerResponse<UserInfo> getUserByUserId(Long userid) {
        return null;
    }

    @Override
    public ServerResponse<String> register(UserInfo user) {
        return null;
    }

    @Override
    public ServerResponse<String> registerByThirdUser(UserinfoThirdpart user) {
        return null;
    }

    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        return null;
    }

    @Override
    public ServerResponse<List<UserInfo>> getUsersByUserIds(String userIds)
    {

        if(StringUtils.isBlank(userIds)){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        List<String> userIdList =  Arrays.asList(userIds.split(","));

        List<UserInfo> userList=userInfoMapper.getUsersByUserIds(userIdList);
        return ServerResponse.createBySuccess(userList);

    }
}
