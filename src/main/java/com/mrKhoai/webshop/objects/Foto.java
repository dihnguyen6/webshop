package com.mrKhoai.webshop.objects;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "FOTO")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOTO_ID", length = 20, nullable = false, unique = true)
    private String fotoId;

    @Column(name = "FOTO_CODE", nullable = false)
    private Blob fotos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public String getFotoId() {
        return fotoId;
    }

    public void setFotoId(String fotoId) {
        this.fotoId = fotoId;
    }

    public Blob getFotos() {
        return fotos;
    }

    public void setFotos(Blob fotos) {
        this.fotos = fotos;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
