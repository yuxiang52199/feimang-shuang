package com.feimang.month.pojo;

public class UserTag {
    private Long utid;

    private Long userid;

    private Integer tagid;

    public UserTag(Long utid, Long userid, Integer tagid) {
        this.utid = utid;
        this.userid = userid;
        this.tagid = tagid;
    }

    public UserTag() {
        super();
    }

    public Long getUtid() {
        return utid;
    }

    public void setUtid(Long utid) {
        this.utid = utid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }
}