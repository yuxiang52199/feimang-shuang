package com.feimang.clubstudy.pojo;

import java.util.Date;

public class BankCard {
    private Integer cbcid;

    private Long clubid;

    private String bankcardid;

    private String username;

    private Date createtime;

    private String bankname;

    public BankCard(Integer cbcid, Long clubid, String bankcardid, String username, Date createtime, String bankname) {
        this.cbcid = cbcid;
        this.clubid = clubid;
        this.bankcardid = bankcardid;
        this.username = username;
        this.createtime = createtime;
        this.bankname = bankname;
    }

    public BankCard() {
        super();
    }

    public Integer getCbcid() {
        return cbcid;
    }

    public void setCbcid(Integer cbcid) {
        this.cbcid = cbcid;
    }

    public Long getClubid() {
        return clubid;
    }

    public void setClubid(Long clubid) {
        this.clubid = clubid;
    }

    public String getBankcardid() {
        return bankcardid;
    }

    public void setBankcardid(String bankcardid) {
        this.bankcardid = bankcardid == null ? null : bankcardid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }
}