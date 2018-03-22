package com.feimang.month.pojo;

public class Gbk2312 {
    private Long id;

    private String v;

    private String y;

    private String mark;

    private Integer flg;

    private Integer bh;

    public Gbk2312(Long id, String v, String y, String mark, Integer flg, Integer bh) {
        this.id = id;
        this.v = v;
        this.y = y;
        this.mark = mark;
        this.flg = flg;
        this.bh = bh;
    }

    public Gbk2312() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v == null ? null : v.trim();
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y == null ? null : y.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getFlg() {
        return flg;
    }

    public void setFlg(Integer flg) {
        this.flg = flg;
    }

    public Integer getBh() {
        return bh;
    }

    public void setBh(Integer bh) {
        this.bh = bh;
    }
}