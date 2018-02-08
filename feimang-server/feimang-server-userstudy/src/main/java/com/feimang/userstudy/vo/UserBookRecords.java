package com.feimang.userstudy.vo;

import com.feimang.userstudy.pojo.UserBookRecord;

import java.util.List;

/**
 * Created by yxm on 2018/2/5
 */
public class UserBookRecords {
    public List<UserBookRecord> userBookRecords;

    public List<UserBookRecord> getUserBookRecords() {
        return userBookRecords;
    }

    public void setUserBookRecords(List<UserBookRecord> userBookRecords) {
        this.userBookRecords = userBookRecords;
    }
}
