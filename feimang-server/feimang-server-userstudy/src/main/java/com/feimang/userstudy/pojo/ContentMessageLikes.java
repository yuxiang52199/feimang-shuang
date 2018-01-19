package com.feimang.userstudy.pojo;

import java.util.Date;

public class ContentMessageLikes {
    private Long messageLikeid;

    private Long fromuid;

    private Long touid;

    private Long contentBaseid;

    private Long reviewid;

    private Integer isread;

    private Date createtime;

    public ContentMessageLikes(Long messageLikeid, Long fromuid, Long touid, Long contentBaseid, Long reviewid, Integer isread, Date createtime) {
        this.messageLikeid = messageLikeid;
        this.fromuid = fromuid;
        this.touid = touid;
        this.contentBaseid = contentBaseid;
        this.reviewid = reviewid;
        this.isread = isread;
        this.createtime = createtime;
    }

    public ContentMessageLikes() {
        super();
    }

    public Long getMessageLikeid() {
        return messageLikeid;
    }

    public void setMessageLikeid(Long messageLikeid) {
        this.messageLikeid = messageLikeid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public Long getTouid() {
        return touid;
    }

    public void setTouid(Long touid) {
        this.touid = touid;
    }

    public Long getContentBaseid() {
        return contentBaseid;
    }

    public void setContentBaseid(Long contentBaseid) {
        this.contentBaseid = contentBaseid;
    }

    public Long getReviewid() {
        return reviewid;
    }

    public void setReviewid(Long reviewid) {
        this.reviewid = reviewid;
    }

    public Integer getIsread() {
        return isread;
    }

    public void setIsread(Integer isread) {
        this.isread = isread;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}