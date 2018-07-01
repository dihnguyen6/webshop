package com.mrKhoai.webshop.objects;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", nullable = false, unique = true)
    private int productId;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_TYPE_ID")
    private ProductType productType;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Description> descriptions;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId : " + productId + ", " +
                "productName : " + productName +
                "}";
    }
}
