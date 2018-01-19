package com.feimang.userstudy.pojo;

import java.util.Date;

public class ContentLikes {
    private Long contentLikeid;

    private Long contentBaseid;

    private Long fromuid;

    private Date createtime;

    public ContentLikes(Long contentLikeid, Long contentBaseid, Long fromuid, Date createtime) {
        this.contentLikeid = contentLikeid;
        this.contentBaseid = contentBaseid;
        this.fromuid = fromuid;
        this.createtime = createtime;
    }

    public ContentLikes() {
        super();
    }

    public Long getContentLikeid() {
        return contentLikeid;
    }

    public void setContentLikeid(Long contentLikeid) {
        this.contentLikeid = contentLikeid;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}