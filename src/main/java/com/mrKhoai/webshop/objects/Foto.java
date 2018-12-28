/*
package com.mrKhoai.webshop.objects;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.http.MediaType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FOTO")
public class Foto {
    @Id
    @Column(name = "FOTO_ID", length = 20, nullable = false, unique = true)
    private String fotoId;

    @Column(name = "FOTO_CODE", nullable = false)
    private MediaType fotos;

    @ManyToOne
    @JoinTable(name = "product")
    private Product product;

    public String getFotoId() {
        return fotoId;
    }

    public void setFotoId(String fotoId) {
        this.fotoId = fotoId;
    }

    public MediaType getFotos() {
        return fotos;
    }

    public void setFotos(MediaType fotos) {
        this.fotos = fotos;
    }
}
*/
