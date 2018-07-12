package com.mrKhoai.webshop.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BILL")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BILL_ID", nullable = false, unique = true)
    private int billId;

    @Column(name = "TRACKING_NUMBER")
    private String trackingNumber;

    @OneToOne(mappedBy = "bill")
    private Basket basket;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id : " + billId + ", " +
                "tracking number : " + trackingNumber +
                "}";
    }
}
