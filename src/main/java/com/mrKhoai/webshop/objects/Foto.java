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
    @GenericGenerator(name = "product_generator", strategy = "com.mrKhoai.webshop.objects.ProductIdGenerator")
    @GeneratedValue(generator = "product_generator")
    @Column(name = "FOTO_ID", length = 20, nullable = false, unique = true)
    private String fotoId;

    @Column(name = "FOTO_CODE", nullable = false)
    private MediaType fotos;

    @ManyToOne
    @JoinTable(name = "product")
    private Product product;


}
