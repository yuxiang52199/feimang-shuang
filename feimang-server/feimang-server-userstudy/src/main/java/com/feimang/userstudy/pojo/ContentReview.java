package com.feimang.userstudy.pojo;

import java.util.Date;

public class ContentReview {
    private Long reviewid;

    private Long contentBaseid;

    private Long fromuid;

    private String rewcontent;

    private Integer rewcount;

    private Integer likecount;

    private Date createtime;

    public ContentReview(Long reviewid, Long contentBaseid, Long fromuid, String rewcontent, Integer rewcount, Integer likecount, Date createtime) {
        this.reviewid = reviewid;
        this.contentBaseid = contentBaseid;
        this.fromuid = fromuid;
        this.rewcontent = rewcontent;
        this.rewcount = rewcount;
        this.likecount = likecount;
        this.createtime = createtime;
    }

    public ContentReview() {
        super();
    }

    public Long getReviewid() {
        return reviewid;
    }

    public void setReviewid(Long reviewid) {
        this.reviewid = reviewid;
    }

    public Long getContentBaseid() {
        return contentBaseid;
    }

    public void setContentBaseid(Long contentBaseid) {
        this.contentBaseid = contentBaseid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public String getRewcontent() {
        return rewcontent;
    }

    public void setRewcontent(String rewcontent) {
        this.rewcontent = rewcontent == null ? null : rewcontent.trim();
    }

    public Integer getRewcount() {
        return rewcount;
    }

    public void setRewcount(Integer rewcount) {
        this.rewcount = rewcount;
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}