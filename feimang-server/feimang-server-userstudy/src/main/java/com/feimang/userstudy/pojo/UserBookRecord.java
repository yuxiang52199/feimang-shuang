package com.feimang.userstudy.pojo;

import java.util.Date;

public class UserBookRecord {
    private Long recordid;

    private Long contentBaseid;

    private Long bookid;

    private Long fromuid;

    private String contents;

    private String photos;

    private Integer phototype;

    private Integer photosource;

    private Integer delflg;

    private Date createtime;

    public UserBookRecord(Long recordid, Long contentBaseid, Long bookid, Long fromuid, String contents, String photos, Integer phototype, Integer photosource, Integer delflg, Date createtime) {
        this.recordid = recordid;
        this.contentBaseid = contentBaseid;
        this.bookid = bookid;
        this.fromuid = fromuid;
        this.contents = contents;
        this.photos = photos;
        this.phototype = phototype;
        this.photosource = photosource;
        this.delflg = delflg;
        this.createtime = createtime;
    }

    public UserBookRecord() {
        super();
    }

    public Long getRecordid() {
        return recordid;
    }

    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }

    public Long getContentBaseid() {
        return contentBaseid;
    }

    public void setContentBaseid(Long contentBaseid) {
        this.contentBaseid = contentBaseid;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos == null ? null : photos.trim();
    }

    public Integer getPhototype() {
        return phototype;
    }

    public void setPhototype(Integer phototype) {
        this.phototype = phototype;
    }

    public Integer getPhotosource() {
        return photosource;
    }

    public void setPhotosource(Integer photosource) {
        this.photosource = photosource;
    }

    public Integer getDelflg() {
        return delflg;
    }

    public void setDelflg(Integer delflg) {
        this.delflg = delflg;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}