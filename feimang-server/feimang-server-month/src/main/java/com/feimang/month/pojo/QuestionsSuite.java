package com.feimang.month.pojo;

public class QuestionsSuite {
    private Integer qsid;

    private Integer suid;

    private Integer flg;

    public QuestionsSuite(Integer qsid, Integer suid, Integer flg) {
        this.qsid = qsid;
        this.suid = suid;
        this.flg = flg;
    }

    public QuestionsSuite() {
        super();
    }

    public Integer getQsid() {
        return qsid;
    }

    public void setQsid(Integer qsid) {
        this.qsid = qsid;
    }

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }

    public Integer getFlg() {
        return flg;
    }

    public void setFlg(Integer flg) {
        this.flg = flg;
    }
}