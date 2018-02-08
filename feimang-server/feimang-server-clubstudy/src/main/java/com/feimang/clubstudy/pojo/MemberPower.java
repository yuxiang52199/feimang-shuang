package com.feimang.clubstudy.pojo;

public class MemberPower {
    private Integer powerid;

    private Integer pid;

    private String powername;

    public MemberPower(Integer powerid, Integer pid, String powername) {
        this.powerid = powerid;
        this.pid = pid;
        this.powername = powername;
    }

    public MemberPower() {
        super();
    }

    public Integer getPowerid() {
        return powerid;
    }

    public void setPowerid(Integer powerid) {
        this.powerid = powerid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPowername() {
        return powername;
    }

    public void setPowername(String powername) {
        this.powername = powername == null ? null : powername.trim();
    }
}