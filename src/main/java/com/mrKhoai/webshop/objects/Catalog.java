package com.mrKhoai.webshop.objects;

import com.mrKhoai.webshop.tools.RoomsIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CATALOG")
public class Catalog implements Identifiable{
    @Id
    @GeneratedValue(generator = "catalog_generator", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "catalog_generator",
            strategy = "com.mrKhoai.webshop.tools.RoomsIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = RoomsIdGenerator.INFIX_PARAMETER, value = "CATALOG"),
                    @org.hibernate.annotations.Parameter(name = RoomsIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = RoomsIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")
            }
    )
    @Column(name = "CATALOG_ID", nullable = false, unique = true)
    private String catalogId;

    @Column(name = "CATALOG_NAME_EN", nullable = false)
    private String catalogNameEN;

    @Column(name = "CATALOG_NAME_DE", nullable = false)
    private String catalogNameDE;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "CATALOG_PRODUCT_TYPE",
            joinColumns = @JoinColumn(name = "CATALOG_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_TYPE_ID"))
    private Set<ProductType> productTypes = new HashSet<>();

    public Catalog(String catalogNameEN, String catalogNameDE) {
        this.catalogNameEN = catalogNameEN;
        this.catalogNameDE = catalogNameDE;
    }

    public Catalog() {
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogNameEN() {
        return catalogNameEN;
    }

    public void setCatalogNameEN(String catalogNameEN) {
        this.catalogNameEN = catalogNameEN;
    }

    public String getCatalogNameDE() {
        return catalogNameDE;
    }

    public void setCatalogNameDE(String catalogNameDE) {
        this.catalogNameDE = catalogNameDE;
    }

    public Set<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(Set<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id : " + catalogId + ", " +
                "nameEN : " + catalogNameEN + ", " +
                "nameDE : " + catalogNameDE +
                "}";
    }

    @Override
    public Serializable getId() {
        return catalogId;
    }
}
