package com.feimang.client.monthread.VueVo;

import java.util.List;

public class EvaluationResultListVueVo {
    private List<EvaluationResultVueVo> list;

    public List<EvaluationResultVueVo> getList() {
        return list;
    }

    public void setList(List<EvaluationResultVueVo> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "EvaluationResultListVueVo{" +
                "list=" + list +
                '}';
    }
}
