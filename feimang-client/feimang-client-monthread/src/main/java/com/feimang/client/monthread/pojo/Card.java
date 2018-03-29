package com.feimang.client.monthread.pojo;

import java.util.Date;

public class Card {
    private Long id;

    private String mark;

    private Integer valication;

    private Integer pid;

    private Integer qid;

    private Integer mid;

    private Integer uid;

    private Integer status;

    private Integer type;

    private Date startTime;

    private Date endTime;

    private String addtime;

    public Card(Long id, String mark, Integer valication, Integer pid, Integer qid, Integer mid, Integer uid, Integer status, Integer type, Date startTime, Date endTime, String addtime) {
        this.id = id;
        this.mark = mark;
        this.valication = valication;
        this.pid = pid;
        this.qid = qid;
        this.mid = mid;
        this.uid = uid;
        this.status = status;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.addtime = addtime;
    }

    public Card() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getValication() {
        return valication;
    }

    public void setValication(Integer valication) {
        this.valication = valication;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}