package com.feimang.client.monthread.VueVo;

import java.util.List;

public class EvaluationVueVo {
    private Long id ;
    private Integer type;
    private Integer flag;
    private String tit;
    private List<OptionVueVo> option;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<OptionVueVo> getOption() {
        return option;
    }

    public void setOption(List<OptionVueVo> option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "EvaluationVueVo{" +
                "id=" + id +
                ", type=" + type +
                ", flag=" + flag +
                ", tit='" + tit + '\'' +
                ", option=" + option +
                '}';
    }
}
