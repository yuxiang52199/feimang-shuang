package com.feimang.client.monthread.VueVo;

import java.util.List;

public class EvaluationVueVo {
    private Long id ;
    private Long quid;
    private Integer type;
    private Integer flag;
    private Integer suid;
    private String tit;
    private List<OptionVueVo> option;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuid() {
        return quid;
    }

    public void setQuid(Long quid) {
        this.quid = quid;
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

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
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
                ", quid=" + quid +
                ", type=" + type +
                ", flag=" + flag +
                ", suid=" + suid +
                ", tit='" + tit + '\'' +
                ", option=" + option +
                '}';
    }
}
