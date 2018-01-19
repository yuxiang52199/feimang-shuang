package com.feimang.user.service;

import com.feimang.user.common.ServerResponse;
import com.feimang.user.pojo.UserInfo;
import com.feimang.user.pojo.UserinfoThirdpart;

public interface IUserService {

    ServerResponse<UserInfo> getUserByUserName(String username);

    ServerResponse<UserInfo> getUserByThirdId(String thirdId);

    ServerResponse<UserInfo> getUserByUserId(Long userid);

    ServerResponse<String> register(UserInfo user);

    ServerResponse<String> registerByThirdUser(UserinfoThirdpart user);

    ServerResponse<String> checkValid(String str,String type);


}
