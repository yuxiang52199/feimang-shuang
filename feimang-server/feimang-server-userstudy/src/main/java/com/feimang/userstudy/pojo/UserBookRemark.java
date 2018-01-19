package com.feimang.userstudy.pojo;

import java.util.Date;

public class UserBookRemark {
    private Long remarkid;

    private Long fromuid;

    private Long bookid;

    private String remark;

    private Date lastupdatetime;

    private Date createtime;

    public UserBookRemark(Long remarkid, Long fromuid, Long bookid, String remark, Date lastupdatetime, Date createtime) {
        this.remarkid = remarkid;
        this.fromuid = fromuid;
        this.bookid = bookid;
        this.remark = remark;
        this.lastupdatetime = lastupdatetime;
        this.createtime = createtime;
    }

    public UserBookRemark() {
        super();
    }

    public Long getRemarkid() {
        return remarkid;
    }

    public void setRemarkid(Long remarkid) {
        this.remarkid = remarkid;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}