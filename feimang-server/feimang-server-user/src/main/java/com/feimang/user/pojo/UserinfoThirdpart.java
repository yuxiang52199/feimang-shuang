package com.feimang.user.pojo;

import java.util.Date;

public class UserinfoThirdpart {
    private Integer tpid;

    private Integer userid;

    private String username;

    private String nickname;

    private String signature;

    private String userhead;

    private Integer fanscount;

    private Integer attentioncount;

    private String country;

    private String area;

    private String provinces;

    private Integer sex;

    private Integer accounttype;

    private Date createtime;

    private String thirduserid;

    private String unionid;

    private Integer thirdstatus;

    public UserinfoThirdpart(Integer tpid, Integer userid, String username, String nickname, String signature, String userhead, Integer fanscount, Integer attentioncount, String country, String area, String provinces, Integer sex, Integer accounttype, Date createtime, String thirduserid, String unionid, Integer thirdstatus) {
        this.tpid = tpid;
        this.userid = userid;
        this.username = username;
        this.nickname = nickname;
        this.signature = signature;
        this.userhead = userhead;
        this.fanscount = fanscount;
        this.attentioncount = attentioncount;
        this.country = country;
        this.area = area;
        this.provinces = provinces;
        this.sex = sex;
        this.accounttype = accounttype;
        this.createtime = createtime;
        this.thirduserid = thirduserid;
        this.unionid = unionid;
        this.thirdstatus = thirdstatus;
    }

    public UserinfoThirdpart() {
        super();
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead == null ? null : userhead.trim();
    }

    public Integer getFanscount() {
        return fanscount;
    }

    public void setFanscount(Integer fanscount) {
        this.fanscount = fanscount;
    }

    public Integer getAttentioncount() {
        return attentioncount;
    }

    public void setAttentioncount(Integer attentioncount) {
        this.attentioncount = attentioncount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces == null ? null : provinces.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Integer accounttype) {
        this.accounttype = accounttype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getThirduserid() {
        return thirduserid;
    }

    public void setThirduserid(String thirduserid) {
        this.thirduserid = thirduserid == null ? null : thirduserid.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public Integer getThirdstatus() {
        return thirdstatus;
    }

    public void setThirdstatus(Integer thirdstatus) {
        this.thirdstatus = thirdstatus;
    }
}