package com.feimang.clubstudy.pojo;

import java.util.Date;

public class Member {
    private Long memberid;

    private Long clubid;

    private Long fromuid;

    private Integer membertype;

    private Integer isremove;

    private Integer iscreatephoto;

    private Integer isforbidphoto;

    private Integer memberstatus;

    private Date createtime;

    private Date removetime;

    private Date phototime;

    private Date forbidtime;

    public Member(Long memberid, Long clubid, Long fromuid, Integer membertype, Integer isremove, Integer iscreatephoto, Integer isforbidphoto, Integer memberstatus, Date createtime, Date removetime, Date phototime, Date forbidtime) {
        this.memberid = memberid;
        this.clubid = clubid;
        this.fromuid = fromuid;
        this.membertype = membertype;
        this.isremove = isremove;
        this.iscreatephoto = iscreatephoto;
        this.isforbidphoto = isforbidphoto;
        this.memberstatus = memberstatus;
        this.createtime = createtime;
        this.removetime = removetime;
        this.phototime = phototime;
        this.forbidtime = forbidtime;
    }

    public Member() {
        super();
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Long getClubid() {
        return clubid;
    }

    public void setClubid(Long clubid) {
        this.clubid = clubid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public Integer getMembertype() {
        return membertype;
    }

    public void setMembertype(Integer membertype) {
        this.membertype = membertype;
    }

    public Integer getIsremove() {
        return isremove;
    }

    public void setIsremove(Integer isremove) {
        this.isremove = isremove;
    }

    public Integer getIscreatephoto() {
        return iscreatephoto;
    }

    public void setIscreatephoto(Integer iscreatephoto) {
        this.iscreatephoto = iscreatephoto;
    }

    public Integer getIsforbidphoto() {
        return isforbidphoto;
    }

    public void setIsforbidphoto(Integer isforbidphoto) {
        this.isforbidphoto = isforbidphoto;
    }

    public Integer getMemberstatus() {
        return memberstatus;
    }

    public void setMemberstatus(Integer memberstatus) {
        this.memberstatus = memberstatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getRemovetime() {
        return removetime;
    }

    public void setRemovetime(Date removetime) {
        this.removetime = removetime;
    }

    public Date getPhototime() {
        return phototime;
    }

    public void setPhototime(Date phototime) {
        this.phototime = phototime;
    }

    public Date getForbidtime() {
        return forbidtime;
    }

    public void setForbidtime(Date forbidtime) {
        this.forbidtime = forbidtime;
    }
}