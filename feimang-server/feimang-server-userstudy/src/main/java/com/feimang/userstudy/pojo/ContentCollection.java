package com.feimang.userstudy.pojo;

import java.util.Date;

public class ContentCollection {
    private Long collectionid;

    private Long contentBaseid;

    private Long fromuid;

    private Date createtime;

    public ContentCollection(Long collectionid, Long contentBaseid, Long fromuid, Date createtime) {
        this.collectionid = collectionid;
        this.contentBaseid = contentBaseid;
        this.fromuid = fromuid;
        this.createtime = createtime;
    }

    public ContentCollection() {
        super();
    }

    public Long getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(Long collectionid) {
        this.collectionid = collectionid;
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