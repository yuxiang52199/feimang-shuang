package com.feimang.month.service;

import com.feimang.month.common.ServerResponse;
import com.feimang.month.pojo.UserAbstruct;

public interface IUserService {

    ServerResponse insertUserRegistration(UserAbstruct userAbstruct);
    ServerResponse updateUserReceivingAddress(UserAbstruct userAbstruct);
    ServerResponse getUserReceivingAddress(Long UserId);
    ServerResponse getUserReadsth(Long userId);

}
