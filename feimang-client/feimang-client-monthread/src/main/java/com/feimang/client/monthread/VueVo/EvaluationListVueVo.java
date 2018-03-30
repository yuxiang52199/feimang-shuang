package com.feimang.client.monthread.VueVo;

import java.util.List;

public class EvaluationListVueVo {

    private List<EvaluationVueVo> list;

    private int toast;

    private Integer suid;

    public List<EvaluationVueVo> getList() {
        return list;
    }

    public void setList(List<EvaluationVueVo> list) {
        this.list = list;
    }

    public int getToast() {
        return toast;
    }

    public void setToast(int toast) {
        this.toast = toast;
    }

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }

    @Override
    public String toString() {
        return "EvaluationListVueVo{" +
                "list=" + list +
                ", toast=" + toast +
                ", suid=" + suid +
                '}';
    }
}
