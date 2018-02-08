package com.feimang.clubstudy.pojo;

import java.util.Date;

public class RcFeeds {
    private Long clubfeedsid;

    private Long clubid;

    private Long photoid;

    private Integer feedstype;

    private Date createtime;

    public RcFeeds(Long clubfeedsid, Long clubid, Long photoid, Integer feedstype, Date createtime) {
        this.clubfeedsid = clubfeedsid;
        this.clubid = clubid;
        this.photoid = photoid;
        this.feedstype = feedstype;
        this.createtime = createtime;
    }

    public RcFeeds() {
        super();
    }

    public Long getClubfeedsid() {
        return clubfeedsid;
    }

    public void setClubfeedsid(Long clubfeedsid) {
        this.clubfeedsid = clubfeedsid;
    }

    public Long getClubid() {
        return clubid;
    }

    public void setClubid(Long clubid) {
        this.clubid = clubid;
    }

    public Long getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Long photoid) {
        this.photoid = photoid;
    }

    public Integer getFeedstype() {
        return feedstype;
    }

    public void setFeedstype(Integer feedstype) {
        this.feedstype = feedstype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}