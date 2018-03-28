package com.feimang.month.vo;

import com.feimang.month.pojo.UserAbstruct;

public class CeshiVO {
    public String userId;

    public UserAbstruct userAbstruct;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserAbstruct getUserAbstruct() {
        return userAbstruct;
    }

    @Override
    public String toString() {
        return "CeshiVO{" +
                "userId='" + userId + '\'' +
                ", userAbstruct=" + userAbstruct +
                '}';
    }

    public void setUserAbstruct(UserAbstruct userAbstruct) {
        this.userAbstruct = userAbstruct;
    }
}
