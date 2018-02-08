package com.feimang.clubstudy.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Activity {
    private Long caid;

    private Long contentBaseid;

    private Long clubid;

    private Long fromuid;

    private String title;

    private String coverurl;

    private Integer membercount;

    private Integer browsecount;

    private Integer joincount;

    private BigDecimal price;

    private Integer isactivity;

    private Integer islinks;

    private Integer isforever;

    private Integer istop;

    private Integer begintime;

    private Integer endtime;

    private Date createtime;

    private Integer activitystatus;

    private Integer activitytype;

    private Integer issticky;

    private String activityaddress;

    private Integer isdelete;

    private String contents;

    public Activity(Long caid, Long contentBaseid, Long clubid, Long fromuid, String title, String coverurl, Integer membercount, Integer browsecount, Integer joincount, BigDecimal price, Integer isactivity, Integer islinks, Integer isforever, Integer istop, Integer begintime, Integer endtime, Date createtime, Integer activitystatus, Integer activitytype, Integer issticky, String activityaddress, Integer isdelete, String contents) {
        this.caid = caid;
        this.contentBaseid = contentBaseid;
        this.clubid = clubid;
        this.fromuid = fromuid;
        this.title = title;
        this.coverurl = coverurl;
        this.membercount = membercount;
        this.browsecount = browsecount;
        this.joincount = joincount;
        this.price = price;
        this.isactivity = isactivity;
        this.islinks = islinks;
        this.isforever = isforever;
        this.istop = istop;
        this.begintime = begintime;
        this.endtime = endtime;
        this.createtime = createtime;
        this.activitystatus = activitystatus;
        this.activitytype = activitytype;
        this.issticky = issticky;
        this.activityaddress = activityaddress;
        this.isdelete = isdelete;
        this.contents = contents;
    }

    public Activity() {
        super();
    }

    public Long getCaid() {
        return caid;
    }

    public void setCaid(Long caid) {
        this.caid = caid;
    }

    public Long getContentBaseid() {
        return contentBaseid;
    }

    public void setContentBaseid(Long contentBaseid) {
        this.contentBaseid = contentBaseid;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCoverurl() {
        return coverurl;
    }

    public void setCoverurl(String coverurl) {
        this.coverurl = coverurl == null ? null : coverurl.trim();
    }

    public Integer getMembercount() {
        return membercount;
    }

    public void setMembercount(Integer membercount) {
        this.membercount = membercount;
    }

    public Integer getBrowsecount() {
        return browsecount;
    }

    public void setBrowsecount(Integer browsecount) {
        this.browsecount = browsecount;
    }

    public Integer getJoincount() {
        return joincount;
    }

    public void setJoincount(Integer joincount) {
        this.joincount = joincount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getIsactivity() {
        return isactivity;
    }

    public void setIsactivity(Integer isactivity) {
        this.isactivity = isactivity;
    }

    public Integer getIslinks() {
        return islinks;
    }

    public void setIslinks(Integer islinks) {
        this.islinks = islinks;
    }

    public Integer getIsforever() {
        return isforever;
    }

    public void setIsforever(Integer isforever) {
        this.isforever = isforever;
    }

    public Integer getIstop() {
        return istop;
    }

    public void setIstop(Integer istop) {
        this.istop = istop;
    }

    public Integer getBegintime() {
        return begintime;
    }

    public void setBegintime(Integer begintime) {
        this.begintime = begintime;
    }

    public Integer getEndtime() {
        return endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getActivitystatus() {
        return activitystatus;
    }

    public void setActivitystatus(Integer activitystatus) {
        this.activitystatus = activitystatus;
    }

    public Integer getActivitytype() {
        return activitytype;
    }

    public void setActivitytype(Integer activitytype) {
        this.activitytype = activitytype;
    }

    public Integer getIssticky() {
        return issticky;
    }

    public void setIssticky(Integer issticky) {
        this.issticky = issticky;
    }

    public String getActivityaddress() {
        return activityaddress;
    }

    public void setActivityaddress(String activityaddress) {
        this.activityaddress = activityaddress == null ? null : activityaddress.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }
}