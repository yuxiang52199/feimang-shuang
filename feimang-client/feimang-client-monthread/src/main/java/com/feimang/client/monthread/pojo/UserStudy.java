package com.feimang.client.monthread.pojo;

import java.util.Date;

public class UserStudy {
    private String ThirdUserID;

    private String UnionID;

    private Long UserID;

    private int AccountType;

    private String NickName;

    private String UserHead;

    public String getThirdUserID() {
        return ThirdUserID;
    }

    public void setThirdUserID(String thirdUserID) {
        ThirdUserID = thirdUserID;
    }

    public String getUnionID() {
        return UnionID;
    }

    public void setUnionID(String unionID) {
        UnionID = unionID;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public int getAccountType() {
        return AccountType;
    }

    public void setAccountType(int accountType) {
        AccountType = accountType;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getUserHead() {
        return UserHead;
    }

    public void setUserHead(String userHead) {
        UserHead = userHead;
    }

    @Override
    public String toString() {
        return "UserStudy{" +
                "ThirdUserID='" + ThirdUserID + '\'' +
                ", UnionID='" + UnionID + '\'' +
                ", UserID=" + UserID +
                ", AccountType=" + AccountType +
                ", NickName='" + NickName + '\'' +
                ", UserHead='" + UserHead + '\'' +
                '}';
    }
}
