package com.feimang.client.monthread.VueVo;

import java.util.List;

public class AnswerVueVo {
    private Long quid;

    private List<Integer> answer;

    private Integer suid;

    public Long getQuid() {
        return quid;
    }

    public void setQuid(Long quid) {
        this.quid = quid;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }

    @Override
    public String toString() {
        return "AnswerVueVo{" +
                "quid=" + quid +
                ", answer=" + answer +
                ", suid=" + suid +
                '}';
    }
}
