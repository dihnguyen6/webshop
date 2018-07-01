package com.mrKhoai.webshop.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ODER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ODER_ID", nullable = false, unique = true)
    private int orderId;

    @Column(name = "ODER_DATE", nullable = false)
    private Date oderDate;

    @Column(name = "ODER_PRICE", nullable = false)
    private double oderPrice;

    @ManyToOne
    @JoinColumn(name = "STAFF_ID")
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "PAYMENT_ID")
    private Payment payment;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOderDate() {
        return oderDate;
    }

    public void setOderDate(Date oderDate) {
        this.oderDate = oderDate;
    }

    public double getOderPrice() {
        return oderPrice;
    }

    public void setOderPrice(double oderPrice) {
        this.oderPrice = oderPrice;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Oder{" +
                "oderId : " + orderId + ", " +
                "oderDate : " + oderDate +
                "oderPrice : " + oderPrice +
                "}";
    }
}
