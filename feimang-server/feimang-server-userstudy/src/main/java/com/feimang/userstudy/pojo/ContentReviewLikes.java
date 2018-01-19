package com.feimang.userstudy.pojo;

import java.util.Date;

public class ContentReviewLikes {
    private Long reviewLikeid;

    private Long fromuid;

    private Long reviewid;

    private Date createtime;

    public ContentReviewLikes(Long reviewLikeid, Long fromuid, Long reviewid, Date createtime) {
        this.reviewLikeid = reviewLikeid;
        this.fromuid = fromuid;
        this.reviewid = reviewid;
        this.createtime = createtime;
    }

    public ContentReviewLikes() {
        super();
    }

    public Long getReviewLikeid() {
        return reviewLikeid;
    }

    public void setReviewLikeid(Long reviewLikeid) {
        this.reviewLikeid = reviewLikeid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public Long getReviewid() {
        return reviewid;
    }

    public void setReviewid(Long reviewid) {
        this.reviewid = reviewid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}