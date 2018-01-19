package com.feimang.userstudy.pojo;

import java.util.Date;

public class UserBookPerfect {
    private Long perfectid;

    private Long bookid;

    private Long fromuid;

    private String bookname;

    private String isbn;

    private String author;

    private String price;

    private String publisher;

    private String pubdate;

    private Date createtime;

    private Date lastupdatetime;

    private Integer imgflg;

    private Integer perfectstatus;

    private String cover;

    public UserBookPerfect(Long perfectid, Long bookid, Long fromuid, String bookname, String isbn, String author, String price, String publisher, String pubdate, Date createtime, Date lastupdatetime, Integer imgflg, Integer perfectstatus, String cover) {
        this.perfectid = perfectid;
        this.bookid = bookid;
        this.fromuid = fromuid;
        this.bookname = bookname;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.pubdate = pubdate;
        this.createtime = createtime;
        this.lastupdatetime = lastupdatetime;
        this.imgflg = imgflg;
        this.perfectstatus = perfectstatus;
        this.cover = cover;
    }

    public UserBookPerfect() {
        super();
    }

    public Long getPerfectid() {
        return perfectid;
    }

    public void setPerfectid(Long perfectid) {
        this.perfectid = perfectid;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate == null ? null : pubdate.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public Integer getImgflg() {
        return imgflg;
    }

    public void setImgflg(Integer imgflg) {
        this.imgflg = imgflg;
    }

    public Integer getPerfectstatus() {
        return perfectstatus;
    }

    public void setPerfectstatus(Integer perfectstatus) {
        this.perfectstatus = perfectstatus;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }
}