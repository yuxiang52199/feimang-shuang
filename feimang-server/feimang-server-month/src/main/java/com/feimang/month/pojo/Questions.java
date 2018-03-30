package com.feimang.month.pojo;

public class Questions {
    private Long quid;

    private Integer questionstype;

    private String questions;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String option5;

    private String option6;

    private String answer;

    private Integer kType1;

    private Integer kType2;

    private Integer kType3;

    private Integer kType4;

    private Integer kType5;

    private Integer kType6;

    private Integer kType7;

    private Integer kType8;

    private Integer kType9;

    private Integer kType10;

    private Integer suid;

    public Questions(Long quid, Integer questionstype, String questions, String option1, String option2, String option3, String option4, String option5, String option6, String answer, Integer kType1, Integer kType2, Integer kType3, Integer kType4, Integer kType5, Integer kType6, Integer kType7, Integer kType8, Integer kType9, Integer kType10, Integer suid) {
        this.quid = quid;
        this.questionstype = questionstype;
        this.questions = questions;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.option6 = option6;
        this.answer = answer;
        this.kType1 = kType1;
        this.kType2 = kType2;
        this.kType3 = kType3;
        this.kType4 = kType4;
        this.kType5 = kType5;
        this.kType6 = kType6;
        this.kType7 = kType7;
        this.kType8 = kType8;
        this.kType9 = kType9;
        this.kType10 = kType10;
        this.suid = suid;
    }

    public Questions() {
        super();
    }

    public Long getQuid() {
        return quid;
    }

    public void setQuid(Long quid) {
        this.quid = quid;
    }

    public Integer getQuestionstype() {
        return questionstype;
    }

    public void setQuestionstype(Integer questionstype) {
        this.questionstype = questionstype;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions == null ? null : questions.trim();
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1 == null ? null : option1.trim();
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2 == null ? null : option2.trim();
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3 == null ? null : option3.trim();
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4 == null ? null : option4.trim();
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5 == null ? null : option5.trim();
    }

    public String getOption6() {
        return option6;
    }

    public void setOption6(String option6) {
        this.option6 = option6 == null ? null : option6.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getkType1() {

        return kType1==null?0:kType1;
    }

    public void setkType1(Integer kType1) {
        this.kType1 = kType1;
    }

    public Integer getkType2() {
        return kType2==null?0:kType2;
    }

    public void setkType2(Integer kType2) {
        this.kType2 = kType2;
    }

    public Integer getkType3() {
        return kType3==null?0:kType3;
    }

    public void setkType3(Integer kType3) {
        this.kType3 = kType3;
    }

    public Integer getkType4() {
        return kType4==null?0:kType4;
    }

    public void setkType4(Integer kType4) {
        this.kType4 = kType4;
    }

    public Integer getkType5() {
        return kType5==null?0:kType5;
    }

    public void setkType5(Integer kType5) {
        this.kType5 = kType5;
    }

    public Integer getkType6() {
        return kType6==null?0:kType6;
    }

    public void setkType6(Integer kType6) {
        this.kType6 = kType6;
    }

    public Integer getkType7() {
        return kType7==null?0:kType7;
    }

    public void setkType7(Integer kType7) {
        this.kType7 = kType7;
    }

    public Integer getkType8() {
        return kType8==null?0:kType8;
    }

    public void setkType8(Integer kType8) {
        this.kType8 = kType8;
    }

    public Integer getkType9() {
        return kType9==null?0:kType9;
    }

    public void setkType9(Integer kType9) {
        this.kType9 = kType9;
    }

    public Integer getkType10() {
        return kType10==null?0:kType10;
    }

    public void setkType10(Integer kType10) {
        this.kType10 = kType10;
    }

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }
}