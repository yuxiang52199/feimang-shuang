package com.feimang.userstudy.pojo;

import java.util.Date;

public class BooktagRelationDescribe {
    private Long describeid;

    private Long fromuid;

    private Long bookid;

    private Long utid;

    private String describe;

    private Integer describestatus;

    private Date createtime;

    public BooktagRelationDescribe(Long describeid, Long fromuid, Long bookid, Long utid, String describe, Integer describestatus, Date createtime) {
        this.describeid = describeid;
        this.fromuid = fromuid;
        this.bookid = bookid;
        this.utid = utid;
        this.describe = describe;
        this.describestatus = describestatus;
        this.createtime = createtime;
    }

    public BooktagRelationDescribe() {
        super();
    }

    public Long getDescribeid() {
        return describeid;
    }

    public void setDescribeid(Long describeid) {
        this.describeid = describeid;
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

    public Long getUtid() {
        return utid;
    }

    public void setUtid(Long utid) {
        this.utid = utid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Integer getDescribestatus() {
        return describestatus;
    }

    public void setDescribestatus(Integer describestatus) {
        this.describestatus = describestatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}