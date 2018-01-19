package com.feimang.userstudy.pojo;

import java.util.Date;

public class BookTagAtten {
    private Long attenid;

    private Long utid;

    private Long fromuid;

    private Long attenuserid;

    private Integer delflg;

    private Date createdate;

    private Integer tagnotifystatus;

    public BookTagAtten(Long attenid, Long utid, Long fromuid, Long attenuserid, Integer delflg, Date createdate, Integer tagnotifystatus) {
        this.attenid = attenid;
        this.utid = utid;
        this.fromuid = fromuid;
        this.attenuserid = attenuserid;
        this.delflg = delflg;
        this.createdate = createdate;
        this.tagnotifystatus = tagnotifystatus;
    }

    public BookTagAtten() {
        super();
    }

    public Long getAttenid() {
        return attenid;
    }

    public void setAttenid(Long attenid) {
        this.attenid = attenid;
    }

    public Long getUtid() {
        return utid;
    }

    public void setUtid(Long utid) {
        this.utid = utid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public Long getAttenuserid() {
        return attenuserid;
    }

    public void setAttenuserid(Long attenuserid) {
        this.attenuserid = attenuserid;
    }

    public Integer getDelflg() {
        return delflg;
    }

    public void setDelflg(Integer delflg) {
        this.delflg = delflg;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getTagnotifystatus() {
        return tagnotifystatus;
    }

    public void setTagnotifystatus(Integer tagnotifystatus) {
        this.tagnotifystatus = tagnotifystatus;
    }
}