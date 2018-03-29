package com.feimang.client.monthread.pojo;

public class Tag {
    private Integer tagid;

    private String tagname;

    private Integer tagcount;

    private Integer tagsource;

    private Long oldtagid;

    public Tag(Integer tagid, String tagname, Integer tagcount, Integer tagsource, Long oldtagid) {
        this.tagid = tagid;
        this.tagname = tagname;
        this.tagcount = tagcount;
        this.tagsource = tagsource;
        this.oldtagid = oldtagid;
    }

    public Tag() {
        super();
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }

    public Integer getTagcount() {
        return tagcount;
    }

    public void setTagcount(Integer tagcount) {
        this.tagcount = tagcount;
    }

    public Integer getTagsource() {
        return tagsource;
    }

    public void setTagsource(Integer tagsource) {
        this.tagsource = tagsource;
    }

    public Long getOldtagid() {
        return oldtagid;
    }

    public void setOldtagid(Long oldtagid) {
        this.oldtagid = oldtagid;
    }
}