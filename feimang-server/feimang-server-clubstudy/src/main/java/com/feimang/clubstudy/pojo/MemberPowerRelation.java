package com.feimang.clubstudy.pojo;

import java.util.Date;

public class MemberPowerRelation {
    private Integer rpid;

    private Integer powerid;

    private Long memberid;

    private Date createtime;

    public MemberPowerRelation(Integer rpid, Integer powerid, Long memberid, Date createtime) {
        this.rpid = rpid;
        this.powerid = powerid;
        this.memberid = memberid;
        this.createtime = createtime;
    }

    public MemberPowerRelation() {
        super();
    }

    public Integer getRpid() {
        return rpid;
    }

    public void setRpid(Integer rpid) {
        this.rpid = rpid;
    }

    public Integer getPowerid() {
        return powerid;
    }

    public void setPowerid(Integer powerid) {
        this.powerid = powerid;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}