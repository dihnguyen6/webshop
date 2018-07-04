package com.mrKhoai.webshop.objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DESCRIPTION")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DESCRIPTION_ID", nullable = false, unique = true)
    private int descriptionId;

    @Column(name = "DESCRIPTION_TEXT", nullable = false)
    private String descriptionText;

    @Column(name = "DESCRIPTION_COLOR", nullable = false)
    private String descriptionColor;

    @Column(name = "DESCRIPTION_PIC", nullable = false)
    private String descriptionPic;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public String getDescriptionColor() {
        return descriptionColor;
    }

    public void setDescriptionColor(String descriptionColor) {
        this.descriptionColor = descriptionColor;
    }

    public String getDescriptionPic() {
        return descriptionPic;
    }

    public void setDescriptionPic(String descriptionPic) {
        this.descriptionPic = descriptionPic;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Description{" +
                "descriptionId : " + descriptionId + ", " +
                "descriptionText : " + descriptionText +
                "descriptionColor : " + descriptionColor +
                "descriptionPic : " + descriptionPic +
                "}";
    }
}
