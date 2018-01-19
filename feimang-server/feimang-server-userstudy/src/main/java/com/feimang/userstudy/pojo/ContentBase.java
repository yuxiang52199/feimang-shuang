package com.feimang.userstudy.pojo;

import java.util.Date;

public class ContentBase {
    private Long contentBaseid;

    private Integer likecount;

    private Integer rewcount;

    private Integer collectioncount;

    private Integer sharecount;

    private Integer phototype;

    private Date createtime;

    private String describeaction;

    public ContentBase(Long contentBaseid, Integer likecount, Integer rewcount, Integer collectioncount, Integer sharecount, Integer phototype, Date createtime, String describeaction) {
        this.contentBaseid = contentBaseid;
        this.likecount = likecount;
        this.rewcount = rewcount;
        this.collectioncount = collectioncount;
        this.sharecount = sharecount;
        this.phototype = phototype;
        this.createtime = createtime;
        this.describeaction = describeaction;
    }

    public ContentBase() {
        super();
    }

    public Long getContentBaseid() {
        return contentBaseid;
    }

    public void setContentBaseid(Long contentBaseid) {
        this.contentBaseid = contentBaseid;
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    public Integer getRewcount() {
        return rewcount;
    }

    public void setRewcount(Integer rewcount) {
        this.rewcount = rewcount;
    }

    public Integer getCollectioncount() {
        return collectioncount;
    }

    public void setCollectioncount(Integer collectioncount) {
        this.collectioncount = collectioncount;
    }

    public Integer getSharecount() {
        return sharecount;
    }

    public void setSharecount(Integer sharecount) {
        this.sharecount = sharecount;
    }

    public Integer getPhototype() {
        return phototype;
    }

    public void setPhototype(Integer phototype) {
        this.phototype = phototype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDescribeaction() {
        return describeaction;
    }

    public void setDescribeaction(String describeaction) {
        this.describeaction = describeaction == null ? null : describeaction.trim();
    }
}