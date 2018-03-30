package com.feimang.client.monthread.VueVo;

public class OptionVueVo {

    private String key;

    private Integer val;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "OptionVueVo{" +
                "key='" + key + '\'' +
                ", val=" + val +
                '}';
    }
}
