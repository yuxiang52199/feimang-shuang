package com.feimang.userstudy.pojo;

import java.util.Date;

public class BooktagRelation {
    private Integer id;

    private Integer utid;

    private Long bookid;

    private Date createtime;

    private Integer tagbookseq;

    public BooktagRelation(Integer id, Integer utid, Long bookid, Date createtime, Integer tagbookseq) {
        this.id = id;
        this.utid = utid;
        this.bookid = bookid;
        this.createtime = createtime;
        this.tagbookseq = tagbookseq;
    }

    public BooktagRelation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUtid() {
        return utid;
    }

    public void setUtid(Integer utid) {
        this.utid = utid;
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

    public Integer getTagbookseq() {
        return tagbookseq;
    }

    public void setTagbookseq(Integer tagbookseq) {
        this.tagbookseq = tagbookseq;
    }
}