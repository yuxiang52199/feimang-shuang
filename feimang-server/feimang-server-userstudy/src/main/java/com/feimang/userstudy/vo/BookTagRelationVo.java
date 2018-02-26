package com.feimang.userstudy.vo;

import com.feimang.userstudy.pojo.UserBookRemark;

import java.util.Date;

/**
 * Created by yxm on 2018/2/8
 */
public class BookTagRelationVo {

    private Integer id;

    private Integer utid;

    private Long fromuid;

    private Long bookid;

    private Date createtime;

    private Integer tagbookseq;

    public UserBookRemark userBookRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUtid() {
        return utid;
    }

    public void setUtid(Integer utid) {
        this.utid = utid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
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

    public Integer getTagbookseq() {
        return tagbookseq;
    }

    public void setTagbookseq(Integer tagbookseq) {
        this.tagbookseq = tagbookseq;
    }

    public UserBookRemark getUserBookRemark() {
        return userBookRemark;
    }

    public void setUserBookRemark(UserBookRemark userBookRemark) {
        this.userBookRemark = userBookRemark;
    }
}
