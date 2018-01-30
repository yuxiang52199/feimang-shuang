package com.feimang.userstudy.common;

/**
 * Created by geely
 */
public class Const {
    //用户关注
    public enum FriendnslinkStatus{
        UNILATERRAL_CONCERN(0,"非互相关注"),
        MUTUAL_CONCERN(1,"互相关注");
        private String value;
        private int code;
        FriendnslinkStatus(int code,String value){
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
    //书架中的是否删除
    public enum BookTagDelFlg{
        UNDELETED(0,"未删除"),
        DELETED(1,"已删除");
        private String value;
        private int code;
        BookTagDelFlg(int code,String value){
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
