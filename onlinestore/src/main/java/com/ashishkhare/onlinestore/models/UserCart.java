package com.ashishkhare.onlinestore.models;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class UserCart {
    @Id
    private int userId;
    @Column
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> productIds;

    public UserCart(){
    }

    public UserCart(int userId, List<Integer> productIds) {
        this.userId = userId;
        this.productIds = productIds;
    }

    /*
     * Getters
     */
    public int getUserId() {
        return userId;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    /*
     * Setters
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
}
