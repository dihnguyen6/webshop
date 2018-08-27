package com.mrKhoai.webshop.objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CATALOG")
public class Catalog {
    @Id
    @Column(name = "CATALOG_NAME", nullable = false, unique = true, length = 20)
    private String catalogName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "CATALOG_PRODUCT_TYPE",
            joinColumns = @JoinColumn(name = "PRODUCT_TYPE_NAME"),
            inverseJoinColumns = @JoinColumn(name = "CATALOG_NAME"))
    private Set<ProductType> productTypes = new HashSet<>();

    public String getName() {
        return catalogName;
    }

    public void setName(String catalogName) {
        this.catalogName = catalogName;
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
                "name : " + catalogName +
                "}";
    }
}
