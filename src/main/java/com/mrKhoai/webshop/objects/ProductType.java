package com.mrKhoai.webshop.objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_TYPE_ID", nullable = false, unique = true)
    private int productId;

    @Column(name = "PRODUCT_TYPE_NAME", nullable = false)
    private String productTypeName;

    @ManyToMany(mappedBy = "productTypes")
    private List<Catalog> catalogs;

    @OneToMany(mappedBy = "productType")
    private List<Product> products;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public List<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(List<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "productTypeId : " + productId + ", " +
                "productTypeName : " + productTypeName +
                "}";
    }
}
