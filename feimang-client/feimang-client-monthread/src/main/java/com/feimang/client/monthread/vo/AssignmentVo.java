package com.feimang.client.monthread.vo;

import com.feimang.client.monthread.pojo.Gbk2312;

import java.util.List;

public class AssignmentVo {
    private Long userId;

    private List<Gbk2312Vo> gbk2312Vos;

    private List<QuestionsVo> questionsVos;

    private Integer suid;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Gbk2312Vo> getGbk2312Vos() {
        return gbk2312Vos;
    }

    public void setGbk2312Vos(List<Gbk2312Vo> gbk2312Vos) {
        this.gbk2312Vos = gbk2312Vos;
    }

    public List<QuestionsVo> getQuestionsVos() {
        return questionsVos;
    }

    public void setQuestionsVos(List<QuestionsVo> questionsVos) {
        this.questionsVos = questionsVos;
    }

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }
}