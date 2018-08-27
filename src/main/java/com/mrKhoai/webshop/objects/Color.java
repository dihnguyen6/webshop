package com.mrKhoai.webshop.objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COLOR")
public class Color {
    @Id
    @Column(name = "COLOR_NAME", nullable = false, unique = true, length = 10)
    private String colorName;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public String getDescriptionText() {
        return colorName;
    }

    public void setDescriptionText(String colorName) {
        this.colorName = colorName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Color{" +
                "color : " + colorName +
                "}";
    }
}
