package com.feimang.clubstudy.pojo;

import java.util.Date;

public class MemberApply {
    private Long applyid;

    private Long clubid;

    private Long fromuid;

    private Date createtime;

    private Date examinetime;

    private Long examineuid;

    private Integer isexamine;

    public MemberApply(Long applyid, Long clubid, Long fromuid, Date createtime, Date examinetime, Long examineuid, Integer isexamine) {
        this.applyid = applyid;
        this.clubid = clubid;
        this.fromuid = fromuid;
        this.createtime = createtime;
        this.examinetime = examinetime;
        this.examineuid = examineuid;
        this.isexamine = isexamine;
    }

    public MemberApply() {
        super();
    }

    public Long getApplyid() {
        return applyid;
    }

    public void setApplyid(Long applyid) {
        this.applyid = applyid;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getExaminetime() {
        return examinetime;
    }

    public void setExaminetime(Date examinetime) {
        this.examinetime = examinetime;
    }

    public Long getExamineuid() {
        return examineuid;
    }

    public void setExamineuid(Long examineuid) {
        this.examineuid = examineuid;
    }

    public Integer getIsexamine() {
        return isexamine;
    }

    public void setIsexamine(Integer isexamine) {
        this.isexamine = isexamine;
    }
}