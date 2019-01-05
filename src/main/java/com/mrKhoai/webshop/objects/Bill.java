package com.mrKhoai.webshop.objects;

import com.mrKhoai.webshop.tools.IdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BILL")
public class Bill implements Identifiable{
    @Id
    @GeneratedValue(generator = "bill_generator", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "bill_generator",
            strategy = "com.mrKhoai.webshop.tools.IdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INFIX_PARAMETER, value = "BILL"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d")
            }
    )
    @Column(name = "BILL_ID", nullable = false, unique = true, length = 30)
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

    @Override
    public Serializable getId() {
        return billId;
    }
}
