package com.ashishkhare.onlinestore.models;

public class RequestToken {
    private Integer userId;
    private Integer orderId;
    private String accessToken;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
