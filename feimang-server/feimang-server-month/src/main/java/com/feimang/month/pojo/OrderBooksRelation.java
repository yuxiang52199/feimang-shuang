package com.feimang.month.pojo;

import java.util.Date;

public class OrderBooksRelation {
    private Long oBRelationid;

    private Long oPRelationid;

    private Long bookid;

    private Integer relationStatus;

    private Date createtime;

    public OrderBooksRelation(Long oBRelationid, Long oPRelationid, Long bookid, Integer relationStatus, Date createtime) {
        this.oBRelationid = oBRelationid;
        this.oPRelationid = oPRelationid;
        this.bookid = bookid;
        this.relationStatus = relationStatus;
        this.createtime = createtime;
    }

    public OrderBooksRelation() {
        super();
    }

    public Long getoBRelationid() {
        return oBRelationid;
    }

    public void setoBRelationid(Long oBRelationid) {
        this.oBRelationid = oBRelationid;
    }

    public Long getoPRelationid() {
        return oPRelationid;
    }

    public void setoPRelationid(Long oPRelationid) {
        this.oPRelationid = oPRelationid;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public Integer getRelationStatus() {
        return relationStatus;
    }

    public void setRelationStatus(Integer relationStatus) {
        this.relationStatus = relationStatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}