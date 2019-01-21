package com.mrKhoai.webshop.objects;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mrKhoai.webshop.tools.IdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {

    @Id
    @GeneratedValue(generator = "productType_generator", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "productType_generator",
            strategy = "com.mrKhoai.webshop.tools.IdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INFIX_PARAMETER, value = "PRODTYPE"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")
            }
    )
    @Column(name = "PRODUCT_TYPE_ID", nullable = false, unique = true, length = 50)
    private String productTypeId;

    @Column(name = "PRODUCT_TYPE_NAME_EN", nullable = false)
    private String productTypeNameEN;

    @Column(name = "PRODUCT_TYPE_NAME_DE", nullable = false)
    private String productTypeNameDE;

    @JsonIgnore
    @ManyToMany(mappedBy = "productTypes")
    private Set<Catalog> catalogs = new HashSet<>();

    @JsonIgnore
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
