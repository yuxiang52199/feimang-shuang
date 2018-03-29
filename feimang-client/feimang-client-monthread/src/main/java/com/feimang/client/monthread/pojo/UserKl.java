package com.feimang.client.monthread.pojo;

public class UserKl {
    private Long ukid;

    private Long userid;

    private Integer flg;

    public UserKl(Long ukid, Long userid, Integer flg) {
        this.ukid = ukid;
        this.userid = userid;
        this.flg = flg;
    }

    public UserKl() {
        super();
    }

    public Long getUkid() {
        return ukid;
    }

    public void setUkid(Long ukid) {
        this.ukid = ukid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getFlg() {
        return flg;
    }

    public void setFlg(Integer flg) {
        this.flg = flg;
    }
}