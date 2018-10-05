package com.mrKhoai.webshop.objects;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GenericGenerator(name = "product_generator", strategy = "com.mrKhoai.webshop.objects.ProductIdGenerator")
    @GeneratedValue(generator = "product_generator")
    @Column(name = "PRODUCT_ID", nullable = false, unique = true, length = 64)
    private String productId;

    @Column(name = "PRODUCT_NAME_EN", nullable = false)
    private String productNameEN;

    @Column(name = "PRODUCT_NAME_DE", nullable = false)
    private String productNameDE;

    @Column(name = "PRODUCT_DESCRIPTION_EN", nullable = false)
    private String productDescriptionEN;

    @Column(name = "PRODUCT_DESCRIPTION_DE", nullable = false)
    private String productDescriptionDE;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "PRODUCT_PRODUCT_TYPE",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_TYPE_ID"))
    private Set<ProductType> productTypes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "PRODUCT_COLOR",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COLOR_NAME"))
    private Set<Color> colors = new HashSet<>();

    @ManyToMany(mappedBy = "products")
    private Set<Basket> baskets = new HashSet<>();

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductNameEN() {
        return productNameEN;
    }

    public void setProductNameEN(String productNameEN) {
        this.productNameEN = productNameEN;
    }

    public String getProductNameDE() {
        return productNameDE;
    }

    public void setProductNameDE(String productNameDE) {
        this.productNameDE = productNameDE;
    }

    public String getProductDescriptionEN() {
        return productDescriptionEN;
    }

    public void setProductDescriptionEN(String productDescriptionEN) {
        this.productDescriptionEN = productDescriptionEN;
    }

    public String getProductDescriptionDE() {
        return productDescriptionDE;
    }

    public void setProductDescriptionDE(String productDescriptionDE) {
        this.productDescriptionDE = productDescriptionDE;
    }

    public Set<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(Set<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    public Set<Color> getColors() {
        return colors;
    }

    public void setColors(Set<Color> colors) {
        this.colors = colors;
    }

    public Set<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id : " + productId + ", " +
                "nameEN : " + productNameEN + ", " +
                "nameDE : " + productNameDE + ", " +
                "descriptionEN : " + productDescriptionEN + ", " +
                "descriptionDE : " + productDescriptionDE +
                "}";
    }
}
