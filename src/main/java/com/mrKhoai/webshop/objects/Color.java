package com.mrKhoai.webshop.objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COLOR")
public class Color {
    @Id
    @Column(name = "COLOR_NAME", nullable = false, unique = true, length = 10)
    private String colorName;

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

    @Override
    public String toString() {
        return "Color{" +
                "color : " + colorName +
                "}";
    }
}
