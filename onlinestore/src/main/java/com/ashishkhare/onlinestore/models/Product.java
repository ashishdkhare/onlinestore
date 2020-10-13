package com.ashishkhare.onlinestore.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Integer productId;
    private String productName;
    private Double productPrice;
    private String productType;
    private String productSize;
    private String availability;
    private String sellerName;

    public Product() {
    }

    public Product(Integer productId, String productName, Double productPrice,
                   String productType, String productSize, String availability, String sellerName) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productSize = productSize;
        this.availability = availability;
        this.sellerName = sellerName;
    }

    /*
    * Getters
     */
    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductSize() {
        return productSize;
    }

    public String getAvailability() {
        return availability;
    }

    public String getSellerName() {
        return sellerName;
    }

    /*
     * Setters
     */
    private void setProductId(Integer productId) {
        this.productId = productId;
    }

    private void setProductName(String productName) {
        this.productName = productName;
    }

    private void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    private void setProductType(String productType) {
        this.productType = productType;
    }

    private void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    private void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
