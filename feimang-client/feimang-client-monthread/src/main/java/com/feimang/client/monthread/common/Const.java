package com.feimang.client.monthread.common;

/**
 * Created by geely
 */
public class Const {
    //每次生成计划方向选择
    public enum KLFlg{
        KL_LENGTH(0,"取长"),
        KL_SHORT(1,"补短"),
        KL_CUSTOM(2,"自定义"),;
        private String value;
        private int code;
        KLFlg(int code,String value){
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }

    public enum CardStatus{
        CARD_NO(0,"未使用"),
        CARD_YES(1,"已使用");
        private String value;
        private int code;
        CardStatus(int code,String value){
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }

    public enum PlatformStatus{
        PlatformStatus_NO(0,"未支付"),
        PlatformStatus_YES(1,"已支付"),
        PlatformStatus_FAIL(2,"已失败"),
        PlatformStatus_COMPLETE(3,"已结束"),
        PlatformStatus_Invalid(4,"已失效");
        private String value;
        private int code;
        PlatformStatus(int code,String value){
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }
    public enum PlatformType{
        PlatformType_CARD(0,"兑换卡"),
        PlatformType_WEIXIN(1,"微信");
        private String value;
        private int code;
        PlatformType(int code,String value){
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }
    public enum RelationStatus{
        RelationStatus_NO(0,"未确认"),
        RelationStatus_YES(1,"已确认"),
        RelationStatus_DELIVER(2,"已发货"),
        RelationStatus_RECEIPT(3,"已收货"),
        RelationStatus_COMPLETE(4,"已完成");
        private String value;
        private int code;
        RelationStatus(int code,String value){
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }

}
