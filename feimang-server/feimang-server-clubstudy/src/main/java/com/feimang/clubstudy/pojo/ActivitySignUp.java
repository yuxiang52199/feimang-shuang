package com.feimang.clubstudy.pojo;

import java.util.Date;

public class ActivitySignUp {
    private Long signupid;

    private Long caid;

    private Long fromuid;

    private Date createtime;

    private String rcusername;

    private String rcuserphone;

    private String payid;

    private Integer signstatus;

    public ActivitySignUp(Long signupid, Long caid, Long fromuid, Date createtime, String rcusername, String rcuserphone, String payid, Integer signstatus) {
        this.signupid = signupid;
        this.caid = caid;
        this.fromuid = fromuid;
        this.createtime = createtime;
        this.rcusername = rcusername;
        this.rcuserphone = rcuserphone;
        this.payid = payid;
        this.signstatus = signstatus;
    }

    public ActivitySignUp() {
        super();
    }

    public Long getSignupid() {
        return signupid;
    }

    public void setSignupid(Long signupid) {
        this.signupid = signupid;
    }

    public Long getCaid() {
        return caid;
    }

    public void setCaid(Long caid) {
        this.caid = caid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRcusername() {
        return rcusername;
    }

    public void setRcusername(String rcusername) {
        this.rcusername = rcusername == null ? null : rcusername.trim();
    }

    public String getRcuserphone() {
        return rcuserphone;
    }

    public void setRcuserphone(String rcuserphone) {
        this.rcuserphone = rcuserphone == null ? null : rcuserphone.trim();
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid == null ? null : payid.trim();
    }

    public Integer getSignstatus() {
        return signstatus;
    }

    public void setSignstatus(Integer signstatus) {
        this.signstatus = signstatus;
    }
}