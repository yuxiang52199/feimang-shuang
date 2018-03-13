package com.feimang.userstudy.vo;

import com.feimang.userstudy.pojo.UserBookRecord;
import com.feimang.userstudy.pojo.UserBookRecordAtuser;

import java.util.Date;

/**
 * Created by yxm on 2018/2/8
 */
public class UserBookRecordAtuserVO {
    private Long atid;

    private Long fromuid;

    private Long touid;

    private Long recordid;

    private Date createtime;

    private Integer status;

    public UserBookRecord userBookRecord;

    public Long getAtid() {
        return atid;
    }

    public void setAtid(Long atid) {
        this.atid = atid;
    }

    public Long getFromuid() {
        return fromuid;
    }

    public void setFromuid(Long fromuid) {
        this.fromuid = fromuid;
    }

    public Long getTouid() {
        return touid;
    }

    public void setTouid(Long touid) {
        this.touid = touid;
    }

    public Long getRecordid() {
        return recordid;
    }

    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserBookRecord getUserBookRecord() {
        return userBookRecord;
    }

    public void setUserBookRecord(UserBookRecord userBookRecord) {
        this.userBookRecord = userBookRecord;
    }
}
