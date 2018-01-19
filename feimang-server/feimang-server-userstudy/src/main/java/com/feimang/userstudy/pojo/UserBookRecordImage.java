package com.feimang.userstudy.pojo;

import java.util.Date;

public class UserBookRecordImage {
    private Integer id;

    private Integer bookid;

    private Long contentBaseid;

    private Integer delflg;

    private Integer seq;

    private Date createtime;

    private Integer imagetype;

    private Long fromuid;

    private Integer imgflg;

    private String bookimage;

    public UserBookRecordImage(Integer id, Integer bookid, Long contentBaseid, Integer delflg, Integer seq, Date createtime, Integer imagetype, Long fromuid, Integer imgflg, String bookimage) {
        this.id = id;
        this.bookid = bookid;
        this.contentBaseid = contentBaseid;
        this.delflg = delflg;
        this.seq = seq;
        this.createtime = createtime;
        this.imagetype = imagetype;
        this.fromuid = fromuid;
        this.imgflg = imgflg;
        this.bookimage = bookimage;
    }

    public UserBookRecordImage() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Long getContentBaseid() {
        return contentBaseid;
    }

    public void setContentBaseid(Long contentBaseid) {
        this.contentBaseid = contentBaseid;
    }

    public Integer getDelflg() {
        return delflg;
    }

    public void setDelflg(Integer delflg) {
        this.delflg = delflg;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getImagetype() {
        return imagetype;
    }

    public void setImagetype(Integer imagetype) {
        this.imagetype = imagetype;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public Integer getImgflg() {
        return imgflg;
    }

    public void setImgflg(Integer imgflg) {
        this.imgflg = imgflg;
    }

    public String getBookimage() {
        return bookimage;
    }

    public void setBookimage(String bookimage) {
        this.bookimage = bookimage == null ? null : bookimage.trim();
    }
}