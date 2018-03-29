package com.feimang.client.monthread.vo;

import java.util.List;

public class Questions {
    private Integer id;
    private Integer type;
    private Integer flag;
    private String  tit;
    private List<Option> option;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public List<Option> getOption() {
        return option;
    }

    public void setOption(List<Option> option) {
        this.option = option;
    }


    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", type=" + type +
                ", flag=" + flag +
                ", tit='" + tit + '\'' +
                ", option=" + option +
                '}';
    }
}
