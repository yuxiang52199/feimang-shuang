package com.feimang.userstudy.vo;

import com.feimang.userstudy.pojo.UserBook;

import java.util.List;

/**
 * Created by yxm on 2018/2/4
 */
public class UserBookVO {
    private Integer utid;
    private List<UserBook> userBooks;

    public Integer getUtid() {
        return utid;
    }

    public void setUtid(Integer utid) {
        this.utid = utid;
    }

    public List<UserBook> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<UserBook> userBooks) {
        this.userBooks = userBooks;
    }
}
