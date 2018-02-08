package com.feimang.userstudy.pojo;

import java.util.Date;

public class UserBook {
    private Integer ubid;

    private Long fromuid;

    private Long bookid;

    private Date createtime;

    private Integer sourcebook;

    private Integer isTag;

    public UserBook(Integer ubid, Long fromuid, Long bookid, Date createtime, Integer sourcebook,Integer isTag) {
        this.ubid = ubid;
        this.fromuid = fromuid;
        this.bookid = bookid;
        this.createtime = createtime;
        this.sourcebook = sourcebook;
    }

    public UserBook() {
        super();
    }

    public Integer getUbid() {
        return ubid;
    }

    public void setUbid(Integer ubid) {
        this.ubid = ubid;
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

    public Integer getSourcebook() {
        return sourcebook;
    }

    public void setSourcebook(Integer sourcebook) {
        this.sourcebook = sourcebook;
    }

    public Integer getIsTag() {
        return isTag;
    }

    public void setIsTag(Integer isTag) {
        this.isTag = isTag;
    }
}