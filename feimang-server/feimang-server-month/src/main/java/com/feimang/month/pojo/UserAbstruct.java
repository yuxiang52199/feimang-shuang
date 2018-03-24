package com.feimang.month.pojo;

import java.util.Date;

public class UserAbstruct {
    private Long uaid;

    private Long userid;

    private String nickname;

    private String userhead;

    private Date birthdate;

    private Integer sex;

    private Integer vocationid;

    private Integer readingV;

    private String receivingCity;

    private String receivingAddress;

    private String receivingPhone;

    private String receivingName;

    private String openid;

    public UserAbstruct(Long uaid, Long userid, String nickname, String userhead, Date birthdate, Integer sex, Integer vocationid, Integer readingV, String receivingCity, String receivingAddress, String receivingPhone, String receivingName, String openid) {
        this.uaid = uaid;
        this.userid = userid;
        this.nickname = nickname;
        this.userhead = userhead;
        this.birthdate = birthdate;
        this.sex = sex;
        this.vocationid = vocationid;
        this.readingV = readingV;
        this.receivingCity = receivingCity;
        this.receivingAddress = receivingAddress;
        this.receivingPhone = receivingPhone;
        this.receivingName = receivingName;
        this.openid = openid;
    }

    public UserAbstruct() {
        super();
    }

    public Long getUaid() {
        return uaid;
    }

    public void setUaid(Long uaid) {
        this.uaid = uaid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead == null ? null : userhead.trim();
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getVocationid() {
        return vocationid;
    }

    public void setVocationid(Integer vocationid) {
        this.vocationid = vocationid;
    }

    public Integer getReadingV() {
        return readingV;
    }

    public void setReadingV(Integer readingV) {
        this.readingV = readingV;
    }

    public String getReceivingCity() {
        return receivingCity;
    }

    public void setReceivingCity(String receivingCity) {
        this.receivingCity = receivingCity == null ? null : receivingCity.trim();
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress == null ? null : receivingAddress.trim();
    }

    public String getReceivingPhone() {
        return receivingPhone;
    }

    public void setReceivingPhone(String receivingPhone) {
        this.receivingPhone = receivingPhone == null ? null : receivingPhone.trim();
    }

    public String getReceivingName() {
        return receivingName;
    }

    public void setReceivingName(String receivingName) {
        this.receivingName = receivingName == null ? null : receivingName.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }
}