package com.feimang.month.pojo;

import java.util.Date;

public class OrderProductRelation {
    private Long oPRelationid;

    private Long userid;

    private String orderNumber;

    private Integer relationNumber;

    private Integer relationStatus;

    private String receivingNumber;

    private Integer receivingType;

    private String receivingCity;

    private String receivingAddress;

    private String receivingPhone;

    private String receivingName;

    private Date receivingTime;

    private Date deliveryTime;

    private Date createtime;

    public OrderProductRelation(Long oPRelationid, Long userid, String orderNumber, Integer relationNumber, Integer relationStatus, String receivingNumber, Integer receivingType, String receivingCity, String receivingAddress, String receivingPhone, String receivingName, Date receivingTime, Date deliveryTime, Date createtime) {
        this.oPRelationid = oPRelationid;
        this.userid = userid;
        this.orderNumber = orderNumber;
        this.relationNumber = relationNumber;
        this.relationStatus = relationStatus;
        this.receivingNumber = receivingNumber;
        this.receivingType = receivingType;
        this.receivingCity = receivingCity;
        this.receivingAddress = receivingAddress;
        this.receivingPhone = receivingPhone;
        this.receivingName = receivingName;
        this.receivingTime = receivingTime;
        this.deliveryTime = deliveryTime;
        this.createtime = createtime;
    }

    public OrderProductRelation() {
        super();
    }

    public Long getoPRelationid() {
        return oPRelationid;
    }

    public void setoPRelationid(Long oPRelationid) {
        this.oPRelationid = oPRelationid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Integer getRelationNumber() {
        return relationNumber;
    }

    public void setRelationNumber(Integer relationNumber) {
        this.relationNumber = relationNumber;
    }

    public Integer getRelationStatus() {
        return relationStatus;
    }

    public void setRelationStatus(Integer relationStatus) {
        this.relationStatus = relationStatus;
    }

    public String getReceivingNumber() {
        return receivingNumber;
    }

    public void setReceivingNumber(String receivingNumber) {
        this.receivingNumber = receivingNumber == null ? null : receivingNumber.trim();
    }

    public Integer getReceivingType() {
        return receivingType;
    }

    public void setReceivingType(Integer receivingType) {
        this.receivingType = receivingType;
    }

    public String getReceivingCity() {
        return receivingCity;
    }

    public void setReceivingCity(String receivingCity) {
        this.receivingCity = receivingCity == null ? null : receivingCity.trim();
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress == null ? null : receivingAddress.trim();
    }

    public String getReceivingPhone() {
        return receivingPhone;
    }

    public void setReceivingPhone(String receivingPhone) {
        this.receivingPhone = receivingPhone == null ? null : receivingPhone.trim();
    }

    public String getReceivingName() {
        return receivingName;
    }

    public void setReceivingName(String receivingName) {
        this.receivingName = receivingName == null ? null : receivingName.trim();
    }

    public Date getReceivingTime() {
        return receivingTime;
    }

    public void setReceivingTime(Date receivingTime) {
        this.receivingTime = receivingTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}