package com.feimang.clubstudy.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class FinanceDetails {
    private Long financeid;

    private Long clubid;

    private Long fromuid;

    private BigDecimal price;

    private String describe;

    private Long docid;

    private Long caid;

    private String payid;

    private Integer financetype;

    private Integer financestatus;

    private Date createtime;

    public FinanceDetails(Long financeid, Long clubid, Long fromuid, BigDecimal price, String describe, Long docid, Long caid, String payid, Integer financetype, Integer financestatus, Date createtime) {
        this.financeid = financeid;
        this.clubid = clubid;
        this.fromuid = fromuid;
        this.price = price;
        this.describe = describe;
        this.docid = docid;
        this.caid = caid;
        this.payid = payid;
        this.financetype = financetype;
        this.financestatus = financestatus;
        this.createtime = createtime;
    }

    public FinanceDetails() {
        super();
    }

    public Long getFinanceid() {
        return financeid;
    }

    public void setFinanceid(Long financeid) {
        this.financeid = financeid;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Long getDocid() {
        return docid;
    }

    public void setDocid(Long docid) {
        this.docid = docid;
    }

    public Long getCaid() {
        return caid;
    }

    public void setCaid(Long caid) {
        this.caid = caid;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid == null ? null : payid.trim();
    }

    public Integer getFinancetype() {
        return financetype;
    }

    public void setFinancetype(Integer financetype) {
        this.financetype = financetype;
    }

    public Integer getFinancestatus() {
        return financestatus;
    }

    public void setFinancestatus(Integer financestatus) {
        this.financestatus = financestatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}