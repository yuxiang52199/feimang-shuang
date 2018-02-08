package com.feimang.clubstudy.pojo;

import java.util.Date;

public class ClubInfo {
    private Long clubid;

    private Long fromuid;

    private String clubname;

    private String clubhead;

    private String clubsign;

    private String phone;

    private Integer clubtype;

    private String personalurl;

    private String licenseurl;

    private String authorizationurl;

    private Integer clubstatus;

    private Integer jointype;

    private String joinpassword;

    private Integer browsetype;

    private Integer phototype;

    private Integer booktagcount;

    private Integer activitycount;

    private Integer doccount;

    private Integer admincount;

    private Integer membercount;

    private Integer noticecount;

    private Integer photocount;

    private Date createtime;

    public ClubInfo(Long clubid, Long fromuid, String clubname, String clubhead, String clubsign, String phone, Integer clubtype, String personalurl, String licenseurl, String authorizationurl, Integer clubstatus, Integer jointype, String joinpassword, Integer browsetype, Integer phototype, Integer booktagcount, Integer activitycount, Integer doccount, Integer admincount, Integer membercount, Integer noticecount, Integer photocount, Date createtime) {
        this.clubid = clubid;
        this.fromuid = fromuid;
        this.clubname = clubname;
        this.clubhead = clubhead;
        this.clubsign = clubsign;
        this.phone = phone;
        this.clubtype = clubtype;
        this.personalurl = personalurl;
        this.licenseurl = licenseurl;
        this.authorizationurl = authorizationurl;
        this.clubstatus = clubstatus;
        this.jointype = jointype;
        this.joinpassword = joinpassword;
        this.browsetype = browsetype;
        this.phototype = phototype;
        this.booktagcount = booktagcount;
        this.activitycount = activitycount;
        this.doccount = doccount;
        this.admincount = admincount;
        this.membercount = membercount;
        this.noticecount = noticecount;
        this.photocount = photocount;
        this.createtime = createtime;
    }

    public ClubInfo() {
        super();
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

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname == null ? null : clubname.trim();
    }

    public String getClubhead() {
        return clubhead;
    }

    public void setClubhead(String clubhead) {
        this.clubhead = clubhead == null ? null : clubhead.trim();
    }

    public String getClubsign() {
        return clubsign;
    }

    public void setClubsign(String clubsign) {
        this.clubsign = clubsign == null ? null : clubsign.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getClubtype() {
        return clubtype;
    }

    public void setClubtype(Integer clubtype) {
        this.clubtype = clubtype;
    }

    public String getPersonalurl() {
        return personalurl;
    }

    public void setPersonalurl(String personalurl) {
        this.personalurl = personalurl == null ? null : personalurl.trim();
    }

    public String getLicenseurl() {
        return licenseurl;
    }

    public void setLicenseurl(String licenseurl) {
        this.licenseurl = licenseurl == null ? null : licenseurl.trim();
    }

    public String getAuthorizationurl() {
        return authorizationurl;
    }

    public void setAuthorizationurl(String authorizationurl) {
        this.authorizationurl = authorizationurl == null ? null : authorizationurl.trim();
    }

    public Integer getClubstatus() {
        return clubstatus;
    }

    public void setClubstatus(Integer clubstatus) {
        this.clubstatus = clubstatus;
    }

    public Integer getJointype() {
        return jointype;
    }

    public void setJointype(Integer jointype) {
        this.jointype = jointype;
    }

    public String getJoinpassword() {
        return joinpassword;
    }

    public void setJoinpassword(String joinpassword) {
        this.joinpassword = joinpassword == null ? null : joinpassword.trim();
    }

    public Integer getBrowsetype() {
        return browsetype;
    }

    public void setBrowsetype(Integer browsetype) {
        this.browsetype = browsetype;
    }

    public Integer getPhototype() {
        return phototype;
    }

    public void setPhototype(Integer phototype) {
        this.phototype = phototype;
    }

    public Integer getBooktagcount() {
        return booktagcount;
    }

    public void setBooktagcount(Integer booktagcount) {
        this.booktagcount = booktagcount;
    }

    public Integer getActivitycount() {
        return activitycount;
    }

    public void setActivitycount(Integer activitycount) {
        this.activitycount = activitycount;
    }

    public Integer getDoccount() {
        return doccount;
    }

    public void setDoccount(Integer doccount) {
        this.doccount = doccount;
    }

    public Integer getAdmincount() {
        return admincount;
    }

    public void setAdmincount(Integer admincount) {
        this.admincount = admincount;
    }

    public Integer getMembercount() {
        return membercount;
    }

    public void setMembercount(Integer membercount) {
        this.membercount = membercount;
    }

    public Integer getNoticecount() {
        return noticecount;
    }

    public void setNoticecount(Integer noticecount) {
        this.noticecount = noticecount;
    }

    public Integer getPhotocount() {
        return photocount;
    }

    public void setPhotocount(Integer photocount) {
        this.photocount = photocount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}