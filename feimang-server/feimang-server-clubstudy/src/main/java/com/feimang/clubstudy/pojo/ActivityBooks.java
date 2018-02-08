package com.feimang.clubstudy.pojo;

import java.util.Date;

public class ActivityBooks {
    private Integer abid;

    private Long caid;

    private Long bookid;

    private String bookname;

    private Date createtime;

    public ActivityBooks(Integer abid, Long caid, Long bookid, String bookname, Date createtime) {
        this.abid = abid;
        this.caid = caid;
        this.bookid = bookid;
        this.bookname = bookname;
        this.createtime = createtime;
    }

    public ActivityBooks() {
        super();
    }

    public Integer getAbid() {
        return abid;
    }

    public void setAbid(Integer abid) {
        this.abid = abid;
    }

    public Long getCaid() {
        return caid;
    }

    public void setCaid(Long caid) {
        this.caid = caid;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}