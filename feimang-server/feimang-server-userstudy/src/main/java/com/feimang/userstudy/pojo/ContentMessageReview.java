package com.feimang.userstudy.pojo;

import java.util.Date;

public class ContentMessageReview {
    private Long messageReviewid;

    private Long fromuid;

    private Long touid;

    private Long replyid;

    private Long reviewid;

    private Long bookid;

    private Date createtime;

    private Integer isread;

    private Long contentBaseid;

    public ContentMessageReview(Long messageReviewid, Long fromuid, Long touid, Long replyid, Long reviewid, Long bookid, Date createtime, Integer isread, Long contentBaseid) {
        this.messageReviewid = messageReviewid;
        this.fromuid = fromuid;
        this.touid = touid;
        this.replyid = replyid;
        this.reviewid = reviewid;
        this.bookid = bookid;
        this.createtime = createtime;
        this.isread = isread;
        this.contentBaseid = contentBaseid;
    }

    public ContentMessageReview() {
        super();
    }

    public Long getMessageReviewid() {
        return messageReviewid;
    }

    public void setMessageReviewid(Long messageReviewid) {
        this.messageReviewid = messageReviewid;
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

    public Long getReplyid() {
        return replyid;
    }

    public void setReplyid(Long replyid) {
        this.replyid = replyid;
    }

    public Long getReviewid() {
        return reviewid;
    }

    public void setReviewid(Long reviewid) {
        this.reviewid = reviewid;
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

    public Integer getIsread() {
        return isread;
    }

    public void setIsread(Integer isread) {
        this.isread = isread;
    }

    public Long getContentBaseid() {
        return contentBaseid;
    }

    public void setContentBaseid(Long contentBaseid) {
        this.contentBaseid = contentBaseid;
    }
}