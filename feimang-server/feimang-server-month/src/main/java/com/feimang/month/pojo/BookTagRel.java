package com.feimang.month.pojo;

import java.util.Date;

public class BookTagRel {
    private Long tbid;

    private Integer tagid;

    private Long bookid;

    private Float bookweight;

    private Date createtime;

    public BookTagRel(Long tbid, Integer tagid, Long bookid, Float bookweight, Date createtime) {
        this.tbid = tbid;
        this.tagid = tagid;
        this.bookid = bookid;
        this.bookweight = bookweight;
        this.createtime = createtime;
    }

    public BookTagRel() {
        super();
    }

    public Long getTbid() {
        return tbid;
    }

    public void setTbid(Long tbid) {
        this.tbid = tbid;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public Float getBookweight() {
        return bookweight;
    }

    public void setBookweight(Float bookweight) {
        this.bookweight = bookweight;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}