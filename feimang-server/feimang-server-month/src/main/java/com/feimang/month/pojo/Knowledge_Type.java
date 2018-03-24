package com.feimang.month.pojo;

import java.util.List;

public class Knowledge_Type {
    private Integer klid;

    private String kType;

    private String kClass;

    private List<Tag> tags;

    public Knowledge_Type(Integer klid, String kType, String kClass,List<Tag> tags) {
        this.klid = klid;
        this.kType = kType;
        this.kClass = kClass;
        this.tags=tags;
    }

    public Knowledge_Type() {
        super();
    }

    public Integer getKlid() {
        return klid;
    }

    public void setKlid(Integer klid) {
        this.klid = klid;
    }

    public String getkType() {
        return kType;
    }

    public void setkType(String kType) {
        this.kType = kType == null ? null : kType.trim();
    }

    public String getkClass() {
        return kClass;
    }

    public void setkClass(String kClass) {
        this.kClass = kClass == null ? null : kClass.trim();
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}