package com.feimang.user.pojo;

import java.util.Date;

public class UserInfo {
    private Long userid;

    private String username;

    private String userpass;

    private String md5userpass;

    private String nickname;

    private String phone;

    private String signature;

    private String studyname;

    private String studysummary;

    private String userhead;

    private Integer sex;

    private String userlocation;

    private String country;

    private String provinces;

    private String city;

    private String area;

    private Integer bookcount;

    private Integer fanscount;

    private Integer attentioncount;

    private Integer attentagcount;

    private Integer accounttype;

    private Integer privatetype;

    private Integer fansstatus;

    private Integer attenuserrecbook;

    private Integer systemflg;

    private Integer privateflg;

    private Integer reviewflg;

    private Integer atuserflg;

    private Integer attenbookflg;

    private Integer scoreflg;

    private Integer imgflg;

    private Integer machinetype;

    private String version;

    private String thirduserid;

    private Date lastlogintime;

    private Date createtime;

    private Integer userstatus;

    private Integer generatestatus;

    private String bgimg;

    public UserInfo(Long userid, String username, String userpass, String md5userpass, String nickname, String phone, String signature, String studyname, String studysummary, String userhead, Integer sex, String userlocation, String country, String provinces, String city, String area, Integer bookcount, Integer fanscount, Integer attentioncount, Integer attentagcount, Integer accounttype, Integer privatetype, Integer fansstatus, Integer attenuserrecbook, Integer systemflg, Integer privateflg, Integer reviewflg, Integer atuserflg, Integer attenbookflg, Integer scoreflg, Integer imgflg, Integer machinetype, String version, String thirduserid, Date lastlogintime, Date createtime, Integer userstatus, Integer generatestatus, String bgimg) {
        this.userid = userid;
        this.username = username;
        this.userpass = userpass;
        this.md5userpass = md5userpass;
        this.nickname = nickname;
        this.phone = phone;
        this.signature = signature;
        this.studyname = studyname;
        this.studysummary = studysummary;
        this.userhead = userhead;
        this.sex = sex;
        this.userlocation = userlocation;
        this.country = country;
        this.provinces = provinces;
        this.city = city;
        this.area = area;
        this.bookcount = bookcount;
        this.fanscount = fanscount;
        this.attentioncount = attentioncount;
        this.attentagcount = attentagcount;
        this.accounttype = accounttype;
        this.privatetype = privatetype;
        this.fansstatus = fansstatus;
        this.attenuserrecbook = attenuserrecbook;
        this.systemflg = systemflg;
        this.privateflg = privateflg;
        this.reviewflg = reviewflg;
        this.atuserflg = atuserflg;
        this.attenbookflg = attenbookflg;
        this.scoreflg = scoreflg;
        this.imgflg = imgflg;
        this.machinetype = machinetype;
        this.version = version;
        this.thirduserid = thirduserid;
        this.lastlogintime = lastlogintime;
        this.createtime = createtime;
        this.userstatus = userstatus;
        this.generatestatus = generatestatus;
        this.bgimg = bgimg;
    }

    public UserInfo() {
        super();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass == null ? null : userpass.trim();
    }

    public String getMd5userpass() {
        return md5userpass;
    }

    public void setMd5userpass(String md5userpass) {
        this.md5userpass = md5userpass == null ? null : md5userpass.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getStudyname() {
        return studyname;
    }

    public void setStudyname(String studyname) {
        this.studyname = studyname == null ? null : studyname.trim();
    }

    public String getStudysummary() {
        return studysummary;
    }

    public void setStudysummary(String studysummary) {
        this.studysummary = studysummary == null ? null : studysummary.trim();
    }

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead == null ? null : userhead.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUserlocation() {
        return userlocation;
    }

    public void setUserlocation(String userlocation) {
        this.userlocation = userlocation == null ? null : userlocation.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces == null ? null : provinces.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Integer getBookcount() {
        return bookcount;
    }

    public void setBookcount(Integer bookcount) {
        this.bookcount = bookcount;
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

    public Integer getAttentagcount() {
        return attentagcount;
    }

    public void setAttentagcount(Integer attentagcount) {
        this.attentagcount = attentagcount;
    }

    public Integer getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Integer accounttype) {
        this.accounttype = accounttype;
    }

    public Integer getPrivatetype() {
        return privatetype;
    }

    public void setPrivatetype(Integer privatetype) {
        this.privatetype = privatetype;
    }

    public Integer getFansstatus() {
        return fansstatus;
    }

    public void setFansstatus(Integer fansstatus) {
        this.fansstatus = fansstatus;
    }

    public Integer getAttenuserrecbook() {
        return attenuserrecbook;
    }

    public void setAttenuserrecbook(Integer attenuserrecbook) {
        this.attenuserrecbook = attenuserrecbook;
    }

    public Integer getSystemflg() {
        return systemflg;
    }

    public void setSystemflg(Integer systemflg) {
        this.systemflg = systemflg;
    }

    public Integer getPrivateflg() {
        return privateflg;
    }

    public void setPrivateflg(Integer privateflg) {
        this.privateflg = privateflg;
    }

    public Integer getReviewflg() {
        return reviewflg;
    }

    public void setReviewflg(Integer reviewflg) {
        this.reviewflg = reviewflg;
    }

    public Integer getAtuserflg() {
        return atuserflg;
    }

    public void setAtuserflg(Integer atuserflg) {
        this.atuserflg = atuserflg;
    }

    public Integer getAttenbookflg() {
        return attenbookflg;
    }

    public void setAttenbookflg(Integer attenbookflg) {
        this.attenbookflg = attenbookflg;
    }

    public Integer getScoreflg() {
        return scoreflg;
    }

    public void setScoreflg(Integer scoreflg) {
        this.scoreflg = scoreflg;
    }

    public Integer getImgflg() {
        return imgflg;
    }

    public void setImgflg(Integer imgflg) {
        this.imgflg = imgflg;
    }

    public Integer getMachinetype() {
        return machinetype;
    }

    public void setMachinetype(Integer machinetype) {
        this.machinetype = machinetype;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getThirduserid() {
        return thirduserid;
    }

    public void setThirduserid(String thirduserid) {
        this.thirduserid = thirduserid == null ? null : thirduserid.trim();
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public Integer getGeneratestatus() {
        return generatestatus;
    }

    public void setGeneratestatus(Integer generatestatus) {
        this.generatestatus = generatestatus;
    }

    public String getBgimg() {
        return bgimg;
    }

    public void setBgimg(String bgimg) {
        this.bgimg = bgimg == null ? null : bgimg.trim();
    }
}