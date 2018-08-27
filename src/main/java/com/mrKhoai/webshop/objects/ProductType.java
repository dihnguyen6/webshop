package com.mrKhoai.webshop.objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {

    @Id
    @Column(name = "PRODUCT_TYPE_NAME", nullable = false, unique = true, length = 30)
    private String productTypeName;

    @ManyToMany(mappedBy = "productTypes")
    private Set<Catalog> catalogs = new HashSet<>();

    @ManyToMany(mappedBy = "productTypes")
    private Set<Product> products = new HashSet<>();

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
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
                "productTypeName : " + productTypeName +
                "}";
    }
}
