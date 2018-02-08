package com.feimang.userstudy.vo;

import com.feimang.userstudy.pojo.ContentReply;

import java.util.Date;
import java.util.List;

/**
 * Created by yxm on 2018/2/8
 */
public class ContentReviewVO {
    private Long reviewid;

    private Long contentBaseid;

    private Long fromuid;

    private String rewcontent;

    private Integer rewcount;

    private Integer likecount;

    private Date createtime;

    private List<ContentReply> contentReplyList;

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
        this.rewcontent = rewcontent;
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

    public List<ContentReply> getContentReplyList() {
        return contentReplyList;
    }

    public void setContentReplyList(List<ContentReply> contentReplyList) {
        this.contentReplyList = contentReplyList;
    }
}
