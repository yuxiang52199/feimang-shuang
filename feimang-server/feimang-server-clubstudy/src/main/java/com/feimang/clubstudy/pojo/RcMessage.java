package com.feimang.clubstudy.pojo;

import java.util.Date;

public class RcMessage {
    private Long clubmessageid;

    private Long clubid;

    private Long fromuid;

    private Long touid;

    private Long caid;

    private Integer messagetype;

    private Date createtime;

    private Integer messagestatus;

    public RcMessage(Long clubmessageid, Long clubid, Long fromuid, Long touid, Long caid, Integer messagetype, Date createtime, Integer messagestatus) {
        this.clubmessageid = clubmessageid;
        this.clubid = clubid;
        this.fromuid = fromuid;
        this.touid = touid;
        this.caid = caid;
        this.messagetype = messagetype;
        this.createtime = createtime;
        this.messagestatus = messagestatus;
    }

    public RcMessage() {
        super();
    }

    public Long getClubmessageid() {
        return clubmessageid;
    }

    public void setClubmessageid(Long clubmessageid) {
        this.clubmessageid = clubmessageid;
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

    public Long getTouid() {
        return touid;
    }

    public void setTouid(Long touid) {
        this.touid = touid;
    }

    public Long getCaid() {
        return caid;
    }

    public void setCaid(Long caid) {
        this.caid = caid;
    }

    public Integer getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(Integer messagetype) {
        this.messagetype = messagetype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getMessagestatus() {
        return messagestatus;
    }

    public void setMessagestatus(Integer messagestatus) {
        this.messagestatus = messagestatus;
    }
}