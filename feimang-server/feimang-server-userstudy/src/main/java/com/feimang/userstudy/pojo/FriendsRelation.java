package com.feimang.userstudy.pojo;

import java.util.Date;

public class FriendsRelation {
    private Integer conid;

    private Long formuid;

    private Long attentionuid;

    private Integer linkstatus;

    private Date createtime;

    public FriendsRelation(Integer conid, Long formuid, Long attentionuid, Integer linkstatus, Date createtime) {
        this.conid = conid;
        this.formuid = formuid;
        this.attentionuid = attentionuid;
        this.linkstatus = linkstatus;
        this.createtime = createtime;
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

    public Long getFormuid() {
        return formuid;
    }

    public void setFormuid(Long formuid) {
        this.formuid = formuid;
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