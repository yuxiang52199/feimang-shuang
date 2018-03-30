package com.feimang.client.monthread.VueVo;

public class EvaluationResultVueVo {
    private String name;

    private Integer val;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "EvaluationResultVueVo{" +
                "name='" + name + '\'' +
                ", val=" + val +
                '}';
    }
}
