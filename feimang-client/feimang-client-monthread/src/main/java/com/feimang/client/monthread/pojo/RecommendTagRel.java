package com.feimang.client.monthread.pojo;

import java.util.Date;

public class RecommendTagRel {
    private Long rtrelid;

    private Long rtid;

    private Long tagid;

    private Date createtime;

    public RecommendTagRel(Long rtrelid, Long rtid, Long tagid, Date createtime) {
        this.rtrelid = rtrelid;
        this.rtid = rtid;
        this.tagid = tagid;
        this.createtime = createtime;
    }

    public RecommendTagRel() {
        super();
    }

    public Long getRtrelid() {
        return rtrelid;
    }

    public void setRtrelid(Long rtrelid) {
        this.rtrelid = rtrelid;
    }

    public Long getRtid() {
        return rtid;
    }

    public void setRtid(Long rtid) {
        this.rtid = rtid;
    }

    public Long getTagid() {
        return tagid;
    }

    public void setTagid(Long tagid) {
        this.tagid = tagid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}