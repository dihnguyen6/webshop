package com.mrKhoai.webshop.objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "CATALOG")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATALOG_ID", nullable = false, unique = true)
    private int catalogId;

    @Column(name = "CATALOG_NAME", nullable = false)
    private String catalogName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CATALOG_PRODUCT_TYPE",
            joinColumns = @JoinColumn(name = "PRODUCT_TYPE_ID", referencedColumnName = "CATALOG_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATALOG_ID", referencedColumnName = "PRODUCT_TYPE_ID"))
    private List<ProductType> productTypes;

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public List<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId : " + catalogId + ", " +
                "catalogName : " + catalogName +
                "}";
    }
}
