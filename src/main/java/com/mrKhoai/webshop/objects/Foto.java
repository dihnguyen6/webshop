package com.mrKhoai.webshop.objects;



import com.mrKhoai.webshop.tools.RoomsIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "FOTO")
public class Foto implements Identifiable{
    @Id
    @GeneratedValue(generator = "foto_generator", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "foto_generator",
            strategy = "com.mrKhoai.webshop.tools.RoomsIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = RoomsIdGenerator.INFIX_PARAMETER, value = "FOTO"),
                    @org.hibernate.annotations.Parameter(name = RoomsIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = RoomsIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            }
    )
    @Column(name = "FOTO_ID", nullable = false, unique = true, length = 30)
    private String fotoId;


    @Column(name = "FOTO_CODE", nullable = false)
    private Blob fotos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "product")
    private Product product;



    public void setFotoId(String fotoId) {
        this.fotoId = fotoId;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public Serializable getId() {
        return fotoId;
    }
}
