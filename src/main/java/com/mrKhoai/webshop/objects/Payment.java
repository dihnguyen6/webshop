package com.mrKhoai.webshop.objects;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
