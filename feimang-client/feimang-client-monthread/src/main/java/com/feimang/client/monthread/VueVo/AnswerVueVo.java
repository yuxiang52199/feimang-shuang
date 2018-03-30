package com.feimang.client.monthread.VueVo;

import java.util.List;

public class AnswerVueVo {
    private Integer id;

    private List<Integer> answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "AnswerVueVo{" +
                "id=" + id +
                ", answer=" + answer +
                '}';
    }
}
