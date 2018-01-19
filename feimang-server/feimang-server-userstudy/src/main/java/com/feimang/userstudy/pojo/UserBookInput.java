package com.feimang.userstudy.pojo;

import java.util.Date;

public class UserBookInput {
    private Long inputid;

    private Long fromuid;

    private Long bookid;

    private Date createtime;

    public UserBookInput(Long inputid, Long fromuid, Long bookid, Date createtime) {
        this.inputid = inputid;
        this.fromuid = fromuid;
        this.bookid = bookid;
        this.createtime = createtime;
    }

    public UserBookInput() {
        super();
    }

    public Long getInputid() {
        return inputid;
    }

    public void setInputid(Long inputid) {
        this.inputid = inputid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}