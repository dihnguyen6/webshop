package com.mrKhoai.webshop.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENTID")
    private int paymentId;

    @Column(name = "PAYMENT_ART")
    private String paymentArt;

    @Column(name = "PAYMENT_PRICE")
    private double paymentPrice;

    @OneToOne(mappedBy = "payment")
    private Order order;

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID : " + paymentId + ", " +
                "paymentArt : " + paymentArt +
                "paymentPrice : " + paymentPrice +
                "}";
    }
}
