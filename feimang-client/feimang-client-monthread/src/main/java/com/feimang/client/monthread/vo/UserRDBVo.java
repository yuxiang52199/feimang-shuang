package com.feimang.client.monthread.vo;

import com.feimang.month.pojo.UserAbstruct;

public class UserRDBVo {
    private int userRDBId;
    private Long readingDates;
    private  int readingBooks;
    private UserAbstruct userAbstruct;

    public UserAbstruct getUserAbstruct() {
        return userAbstruct;
    }

    public void setUserAbstruct(UserAbstruct userAbstruct) {
        this.userAbstruct = userAbstruct;
    }

    public Long getReadingDates() {
        return readingDates;
    }

    public void setReadingDates(Long readingDates) {
        this.readingDates = readingDates;
    }



    public int getUserRDBId() {
        return userRDBId;
    }

    public void setUserRDBId(int userRDBId) {
        this.userRDBId = userRDBId;
    }


    public int getReadingBooks() {
        return readingBooks;
    }

    public void setReadingBooks(int readingBooks) {
        this.readingBooks = readingBooks;
    }
}
