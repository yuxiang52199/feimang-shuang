package com.feimang.client.monthread.pojo;

public class UserKlStruct {
    private Long tsid;

    private Long userid;

    private Integer klid;

    private Integer score;

    private Integer levels;

    private Integer uqid;

    private Knowledge_Type knowledge_type;

    public UserKlStruct(Long tsid, Long userid, Integer klid, Integer score, Integer levels, Integer uqid,Knowledge_Type knowledge_type) {
        this.tsid = tsid;
        this.userid = userid;
        this.klid = klid;
        this.score = score;
        this.levels = levels;
        this.uqid = uqid;
        this.knowledge_type=knowledge_type;
    }

    public UserKlStruct() {
        super();
    }

    public Long getTsid() {
        return tsid;
    }

    public void setTsid(Long tsid) {
        this.tsid = tsid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getKlid() {
        return klid;
    }

    public void setKlid(Integer klid) {
        this.klid = klid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Integer getUqid() {
        return uqid;
    }

    public void setUqid(Integer uqid) {
        this.uqid = uqid;
    }

    public Knowledge_Type getKnowledge_type() {
        return knowledge_type;
    }

    public void setKnowledge_type(Knowledge_Type knowledge_type) {
        this.knowledge_type = knowledge_type;
    }
}