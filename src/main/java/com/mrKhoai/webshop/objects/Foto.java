package com.mrKhoai.webshop.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "FOTO")
public class Foto {
    @Id
    @Column(name = "FOTO_ID", length = 20, nullable = false, unique = true)
    private String fotoId;

    @Column(name = "FOTO_CODE", nullable = false)
    private Blob fotos;

    @ManyToOne
    @JoinTable(name = "product")
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
}
