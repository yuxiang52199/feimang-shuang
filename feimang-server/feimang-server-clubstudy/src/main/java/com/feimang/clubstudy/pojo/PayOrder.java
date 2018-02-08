package com.feimang.clubstudy.pojo;

import java.util.Date;

public class PayOrder {
    private String payid;

    private Integer paystatus;

    private Long fromuid;

    private Date createtime;

    public PayOrder(String payid, Integer paystatus, Long fromuid, Date createtime) {
        this.payid = payid;
        this.paystatus = paystatus;
        this.fromuid = fromuid;
        this.createtime = createtime;
    }

    public PayOrder() {
        super();
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid == null ? null : payid.trim();
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
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
}