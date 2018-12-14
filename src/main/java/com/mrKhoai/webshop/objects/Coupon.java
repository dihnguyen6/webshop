package com.mrKhoai.webshop.objects;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COUPON")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUPON_ID", nullable = false, unique = true)
    private int couponId;

    @Column(name = "COUPON_VALUE")
    private int couponValue;

    @Column(name = "COUPON_PERCENT")
    private int couponPercent;

    @Column(name = "COUPON_LIMIT")
    private int couponLimit;

    @Column(name = "EXPIRED_DATE")
    private Date expiredDate;

    @OneToOne(mappedBy = "coupon")
    private Basket basket;

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(int couponValue) {
        this.couponValue = couponValue;
    }

    public int getCouponPercent() {
        return couponPercent;
    }

    public void setCouponPercent(int couponPercent) {
        this.couponPercent = couponPercent;
    }

    public int getCouponLimit() {
        return couponLimit;
    }

    public void setCouponLimit(int couponLimit) {
        this.couponLimit = couponLimit;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
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
                "id : " + couponId + ", " +
                "value : " + couponValue + ", " +
                "percent : " + couponPercent + ", " +
                "limit : " + couponLimit + ", " +
                "expired : " + expiredDate + ", " +
                "}";
    }
}
