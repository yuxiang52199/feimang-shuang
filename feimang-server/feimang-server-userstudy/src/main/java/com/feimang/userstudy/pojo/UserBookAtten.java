package com.feimang.userstudy.pojo;

import java.util.Date;

public class UserBookAtten {
    private Long atteninfoid;

    private Long fromuid;

    private Long bookid;

    private Date createtime;

    public UserBookAtten(Long atteninfoid, Long fromuid, Long bookid, Date createtime) {
        this.atteninfoid = atteninfoid;
        this.fromuid = fromuid;
        this.bookid = bookid;
        this.createtime = createtime;
    }

    public UserBookAtten() {
        super();
    }

    public Long getAtteninfoid() {
        return atteninfoid;
    }

    public void setAtteninfoid(Long atteninfoid) {
        this.atteninfoid = atteninfoid;
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