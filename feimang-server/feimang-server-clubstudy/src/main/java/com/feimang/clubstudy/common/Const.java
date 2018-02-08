package com.feimang.clubstudy.common;

/**
 * Created by geely
 */
public class Const {

    //群书房类型
    public enum ClubType{
        INDIVIDUAL(1,"个人"),
        OFFICIAL(2,"官方");


        private String value;
        private int code;
        ClubType(int code,String value){
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
    //群书房状态
    public enum ClubStatus{
        PROGRESS(0,"审核中"),
        SUCCESS(1,"审核通过"),
        FAIL(2,"拒绝审核");
        private String value;
        private int code;
        ClubStatus(int code,String value){
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
    //群书房加入权限类型
    public enum ClubJoinType{
        ALL(0,"所有人"),
        APPLY(1,"申请"),
        INVITATION(2,"邀请"),
        PASSWORD(3,"密码");

        private String value;
        private int code;
        ClubJoinType(int code,String value){
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
    //非会员是否可以查看会内信息
    public enum ClubBrowseType{
        Yes(0,"可以"),
        No(1,"不可以");

        private String value;
        private int code;
        ClubBrowseType(int code,String value){
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
    //群书房发布书拍权限类型
    public enum ClubPhotoType{
        ALL(0,"所有人"),
        Admin(1,"管理员"),
        APPOINT(2,"指定人员");

        private String value;
        private int code;
        ClubPhotoType(int code,String value){
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

    //成员类型
    public enum MemberType{
        GENERAL(0,"普通"),
        CREATOR(1,"会长"),
        ADMIN(2,"管理员");
        private String value;
        private int code;
        MemberType(int code,String value){
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
    //成员移除状态
    public enum MemberIsRemove{
        NO(0,"未被移除"),
        YES(1,"已移除");

        private String value;
        private int code;
        MemberIsRemove(int code,String value){
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

    //是否指定发群书拍
    public enum MemberIsCreatePhoto {
        NO(0,"未指定"),
        YES(1,"已指定");

        private String value;
        private int code;
        MemberIsCreatePhoto(int code,String value){
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

    // 是否禁止发群书拍
    public enum MemberIsForbidPhoto {
        NO(0,"未禁止"),
        YES(1,"已禁止");

        private String value;
        private int code;
        MemberIsForbidPhoto(int code,String value){
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

    // 是否禁止发群书拍
    public enum MemberIsExamine {
        PROGRESS(0,"审核中"),
        SUCCESS(1,"审核通过"),
        FAIL(2,"拒绝审核");

        private String value;
        private int code;
        MemberIsExamine(int code,String value){
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

    //加入群书房申请审核状态
    public enum MemberApplyIsExamine{
        PROGRESS(0,"审核中"),
        SUCCESS(1,"审核通过"),
        FAIL(2,"拒绝审核");
        private String value;
        private int code;
        MemberApplyIsExamine(int code,String value){
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
