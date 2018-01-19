package com.feimang.userstudy.pojo;

import java.util.Date;

public class ContentReplyLikes {
    private Long replyLikeid;

    private Long replyid;

    private Long fromuid;

    private Date createtime;

    public ContentReplyLikes(Long replyLikeid, Long replyid, Long fromuid, Date createtime) {
        this.replyLikeid = replyLikeid;
        this.replyid = replyid;
        this.fromuid = fromuid;
        this.createtime = createtime;
    }

    public ContentReplyLikes() {
        super();
    }

    public Long getReplyLikeid() {
        return replyLikeid;
    }

    public void setReplyLikeid(Long replyLikeid) {
        this.replyLikeid = replyLikeid;
    }

    public Long getReplyid() {
        return replyid;
    }

    public void setReplyid(Long replyid) {
        this.replyid = replyid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}