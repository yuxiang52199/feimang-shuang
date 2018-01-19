package com.feimang.userstudy.pojo;

import java.util.Date;

public class ContentReply {
    private Long replyid;

    private Long reviewid;

    private Long fromuid;

    private Long touid;

    private String replycontent;

    private Integer replycount;

    private Integer likecount;

    private Date createtime;

    public ContentReply(Long replyid, Long reviewid, Long fromuid, Long touid, String replycontent, Integer replycount, Integer likecount, Date createtime) {
        this.replyid = replyid;
        this.reviewid = reviewid;
        this.fromuid = fromuid;
        this.touid = touid;
        this.replycontent = replycontent;
        this.replycount = replycount;
        this.likecount = likecount;
        this.createtime = createtime;
    }

    public ContentReply() {
        super();
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

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent == null ? null : replycontent.trim();
    }

    public Integer getReplycount() {
        return replycount;
    }

    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
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