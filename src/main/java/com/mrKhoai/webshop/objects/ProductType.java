package com.mrKhoai.webshop.objects;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {

    @Id
    @GenericGenerator(name = "product_type_generator", strategy = "com.mrKhoai.webshop.objects.ProductTypeIdGenerator")
    @GeneratedValue(generator = "product_type_generator")
    @Column(name = "PRODUCT_TYPE_ID", nullable = false, unique = true, length = 32)
    private String productTypeId;

    @Column(name = "PRODUCT_TYPE_NAME_EN", nullable = false)
    private String productTypeNameEN;

    @Column(name = "PRODUCT_TYPE_NAME_DE", nullable = false)
    private String productTypeNameDE;

    @ManyToMany(mappedBy = "productTypes")
    private Set<Catalog> catalogs = new HashSet<>();

    @ManyToMany(mappedBy = "productTypes")
    private Set<Product> products = new HashSet<>();

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeNameEN() {
        return productTypeNameEN;
    }

    public void setProductTypeNameEN(String productTypeNameEN) {
        this.productTypeNameEN = productTypeNameEN;
    }

    public String getProductTypeNameDE() {
        return productTypeNameDE;
    }

    public void setProductTypeNameDE(String productTypeNameDE) {
        this.productTypeNameDE = productTypeNameDE;
    }

    public Set<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(Set<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "productTypeId : " + productTypeId + ", " +
                "productTypeNameEN : " + productTypeNameEN + ", " +
                "productTypeNameDE : " + productTypeNameDE +
                "}";
    }
}
