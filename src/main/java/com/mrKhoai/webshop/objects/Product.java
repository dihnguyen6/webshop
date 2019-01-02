package com.mrKhoai.webshop.objects;


import com.mrKhoai.webshop.tools.IdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product implements Identifiable{
    @Id
    @GeneratedValue(generator = "product_generator", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "product_generator",
            strategy = "com.mrKhoai.webshop.tools.IdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INFIX_PARAMETER, value = "PRODUCT"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d")
            }
    )
    @Column(name = "PRODUCT_ID", nullable = false, unique = true, length = 30)
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

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Foto> fotos = new HashSet<>();

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

    public Set<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(Set<Foto> fotos) {
        this.fotos = fotos;
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

    @Override
    public Serializable getId() {
        return productId;
    }
}
