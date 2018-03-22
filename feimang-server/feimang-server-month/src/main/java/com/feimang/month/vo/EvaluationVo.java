package com.feimang.month.vo;

import com.feimang.month.pojo.Gbk2312;
import com.feimang.month.pojo.Questions;

import java.util.List;

public class EvaluationVo {

    private List<Questions> questions;

    private List<Gbk2312> gbk2312s;

    private Integer suid;

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public List<Gbk2312> getGbk2312s() {
        return gbk2312s;
    }

    public void setGbk2312s(List<Gbk2312> gbk2312s) {
        this.gbk2312s = gbk2312s;
    }

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }
}
