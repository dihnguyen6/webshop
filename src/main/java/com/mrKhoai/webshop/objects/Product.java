package com.mrKhoai.webshop.objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", nullable = false, unique = true)
    private String productId;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId : " + productId + ", " +
                "productName : " + productName +
                "}";
    }
}
