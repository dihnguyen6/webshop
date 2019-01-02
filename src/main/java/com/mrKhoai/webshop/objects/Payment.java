package com.mrKhoai.webshop.objects;

import com.mrKhoai.webshop.tools.IdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PAYMENT")
public class Payment implements Identifiable{
    @Id
    @GeneratedValue(generator = "payment_generator", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "payment_generator",
            strategy = "com.mrKhoai.webshop.tools.IdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INFIX_PARAMETER, value = "PAYMENT"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")
            }
    )
    @Column(name = "PAYMENT_ID", nullable = false, unique = true)
    private int paymentId;

    @Column(name = "PAYMENT_ART")
    private String paymentArt;

    @Column(name = "PAYMENT_PRICE")
    private double paymentPrice;

    @OneToOne(mappedBy = "payment")
    private Basket basket;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentArt() {
        return paymentArt;
    }

    public void setPaymentArt(String paymentArt) {
        this.paymentArt = paymentArt;
    }

    public double getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(double paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID : " + paymentId + ", " +
                "paymentArt : " + paymentArt + ", " +
                "paymentPrice : " + paymentPrice +
                "}";
    }

    @Override
    public Serializable getId() {
        return paymentId;
    }
}
