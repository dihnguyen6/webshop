package com.mrKhoai.webshop.objects;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COLOR")
public class Color {
    @Id
    @Column(name = "COLOR_NAME", nullable = false, unique = true, length = 10)
    private String colorName;

    @JsonIgnore
    @ManyToMany(mappedBy = "colors")
    private Set<Product> products = new HashSet<>();

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Color() {
    }

    public Color(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public String toString() {
        return "Color{" +
                "color : " + colorName +
                "}";
    }
}
