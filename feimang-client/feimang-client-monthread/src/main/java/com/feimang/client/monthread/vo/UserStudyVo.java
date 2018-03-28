package com.feimang.client.monthread.vo;

import com.feimang.client.monthread.pojo.UserStudy;

public class UserStudyVo {
    public String Token;

    private UserStudy UserStudy;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public com.feimang.client.monthread.pojo.UserStudy getUserStudy() {
        return UserStudy;
    }

    public void setUserStudy(com.feimang.client.monthread.pojo.UserStudy userStudy) {
        UserStudy = userStudy;
    }

    @Override
    public String toString() {
        return "UserStudyVo{" +
                "Token='" + Token + '\'' +
                ", UserStudy=" + UserStudy +
                '}';
    }
}
