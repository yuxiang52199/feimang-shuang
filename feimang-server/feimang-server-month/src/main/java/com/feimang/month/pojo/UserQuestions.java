package com.feimang.month.pojo;

import java.util.Date;

public class UserQuestions {
    private Integer uqid;

    private Long userid;

    private Integer suid;

    private Date createdatetime;

    public UserQuestions(Integer uqid, Long userid, Integer suid, Date createdatetime) {
        this.uqid = uqid;
        this.userid = userid;
        this.suid = suid;
        this.createdatetime = createdatetime;
    }

    public UserQuestions() {
        super();
    }

    public Integer getUqid() {
        return uqid;
    }

    public void setUqid(Integer uqid) {
        this.uqid = uqid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }
}