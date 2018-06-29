package com.mrKhoai.webshop.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATALOG")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATALOG_ID", nullable = false, unique = true)
    private String catalogId;

    @Column(name = "CATALOG_NAME", nullable = false)
    private String catalogName;

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }
}
