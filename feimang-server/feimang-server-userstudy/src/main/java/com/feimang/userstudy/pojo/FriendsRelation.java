package com.feimang.userstudy.pojo;

import java.util.Date;

public class FriendsRelation {
    private Integer conid;

    private Long fromuid;

    private Long attentionuid;

    private Integer linkstatus;

    private Date createtime;

    private Integer isscreen;

    private Date screentime;

    public FriendsRelation(Integer conid, Long formuid, Long attentionuid, Integer linkstatus, Date createtime) {
        this.conid = conid;
        this.fromuid = formuid;
        this.attentionuid = attentionuid;
        this.linkstatus = linkstatus;
        this.createtime = createtime;
        this.isscreen = isscreen;
        this.screentime = screentime;
    }

    public Integer getIsscreen() {
        return isscreen;
    }

    public void setIsscreen(Integer isscreen) {
        this.isscreen = isscreen;
    }

    public Date getScreentime() {
        return screentime;
    }

    public void setScreentime(Date screentime) {
        this.screentime = screentime;
    }

    public FriendsRelation() {
        super();
    }

    public Integer getConid() {
        return conid;
    }

    public void setConid(Integer conid) {
        this.conid = conid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public Long getAttentionuid() {
        return attentionuid;
    }

    public void setAttentionuid(Long attentionuid) {
        this.attentionuid = attentionuid;
    }

    public Integer getLinkstatus() {
        return linkstatus;
    }

    public void setLinkstatus(Integer linkstatus) {
        this.linkstatus = linkstatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}