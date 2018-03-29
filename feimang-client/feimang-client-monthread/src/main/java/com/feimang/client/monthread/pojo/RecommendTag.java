package com.feimang.client.monthread.pojo;

import java.util.Date;

public class RecommendTag {
    private Long rtid;

    private String rtname;

    private Integer klid;

    private Integer seq;

    private Date createtime;

    private Integer rtstatus;

    public RecommendTag(Long rtid, String rtname, Integer klid, Integer seq, Date createtime, Integer rtstatus) {
        this.rtid = rtid;
        this.rtname = rtname;
        this.klid = klid;
        this.seq = seq;
        this.createtime = createtime;
        this.rtstatus = rtstatus;
    }

    public RecommendTag() {
        super();
    }

    public Long getRtid() {
        return rtid;
    }

    public void setRtid(Long rtid) {
        this.rtid = rtid;
    }

    public String getRtname() {
        return rtname;
    }

    public void setRtname(String rtname) {
        this.rtname = rtname == null ? null : rtname.trim();
    }

    public Integer getKlid() {
        return klid;
    }

    public void setKlid(Integer klid) {
        this.klid = klid;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getRtstatus() {
        return rtstatus;
    }

    public void setRtstatus(Integer rtstatus) {
        this.rtstatus = rtstatus;
    }
}