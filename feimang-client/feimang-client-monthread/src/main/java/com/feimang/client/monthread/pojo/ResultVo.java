package com.feimang.client.monthread.pojo;

public class ResultVo {
    private String Average ;
    private Integer Code ;
    private String Token ;

    public String getAverage() {
        return Average;
    }

    public void setAverage(String average) {
        Average = average;
    }

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "Average='" + Average + '\'' +
                ", Code=" + Code +
                ", Token='" + Token + '\'' +
                '}';
    }
}
