package com.feimang.userstudy.pojo;

import java.util.Date;

public class    BookTag {
    private Integer utid;

    private Long fromuid;

    private String tagname;

    private Integer tagcount;

    private Date createtime;

    private Integer seq;

    private Integer delflg;

    private Integer islock;

    private Integer attencount;

    private Integer tagyear;

    private Long clubid;

    private Integer isclub;

    private Integer addbookauthority;

    public BookTag(Integer utid, Long fromuid, String tagname, Integer tagcount, Date createtime, Integer seq, Integer delflg, Integer islock, Integer attencount, Integer tagyear, Long clubid, Integer isclub, Integer addbookauthority) {
        this.utid = utid;
        this.fromuid = fromuid;
        this.tagname = tagname;
        this.tagcount = tagcount;
        this.createtime = createtime;
        this.seq = seq;
        this.delflg = delflg;
        this.islock = islock;
        this.attencount = attencount;
        this.tagyear = tagyear;
        this.clubid = clubid;
        this.isclub = isclub;
        this.addbookauthority = addbookauthority;
    }

    public BookTag() {
        super();
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

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }

    public Integer getTagcount() {
        return tagcount;
    }

    public void setTagcount(Integer tagcount) {
        this.tagcount = tagcount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getDelflg() {
        return delflg;
    }

    public void setDelflg(Integer delflg) {
        this.delflg = delflg;
    }

    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
    }

    public Integer getAttencount() {
        return attencount;
    }

    public void setAttencount(Integer attencount) {
        this.attencount = attencount;
    }

    public Integer getTagyear() {
        return tagyear;
    }

    public void setTagyear(Integer tagyear) {
        this.tagyear = tagyear;
    }

    public Long getClubid() {
        return clubid;
    }

    public void setClubid(Long clubid) {
        this.clubid = clubid;
    }

    public Integer getIsclub() {
        return isclub;
    }

    public void setIsclub(Integer isclub) {
        this.isclub = isclub;
    }

    public Integer getAddbookauthority() {
        return addbookauthority;
    }

    public void setAddbookauthority(Integer addbookauthority) {
        this.addbookauthority = addbookauthority;
    }
}