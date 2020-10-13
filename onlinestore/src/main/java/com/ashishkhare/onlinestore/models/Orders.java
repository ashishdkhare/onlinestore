package com.ashishkhare.onlinestore.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private Integer userId;
    private String paymentStatus;
    @Column
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> productIds;

    public Orders(){
    }

    public Orders(Integer userId, String paymentStatus, List<Integer> productIds) {
        super();
        this.userId = userId;
        this.paymentStatus = paymentStatus;
        this.productIds = productIds;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
}
