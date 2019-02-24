package com.mrKhoai.webshop.objects;


import javax.persistence.*;

@Entity
@Table(name = "CAROUSEL")
public class Carousel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAROUSEL_ID", nullable = false, unique = true)
    private int carouselId;


    @Lob
    @Column(name = "CAROUSEL_FOTO", nullable = false)
    private byte[] foto;


    public int getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(int carouselId) {
        this.carouselId = carouselId;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
