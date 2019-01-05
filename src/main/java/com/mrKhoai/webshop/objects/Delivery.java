package com.mrKhoai.webshop.objects;

import javax.persistence.*;

@Entity
@Table(name = "DELIVERY")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID", nullable = false, unique = true, length = 30)
    private int deliveryId;

    @Column(name = "DELIVERY_NAME", nullable = false)
    private String deliveryName;

    @Column(name = "DELIVERY_COUNTRY")
    private String deliveryCountry;

    @Column(name = "DELIVERY_ADDRESS")
    private String deliveryAddress;

    @Column(name = "DELIVERY_CITY")
    private String deliveryCity;

    @Column(name = "DELIVERY_POSTCODE")
    private int deliveryPostcode;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getDeliveryCountry() {
        return deliveryCountry;
    }

    public void setDeliveryCountry(String deliveryCountry) {
        this.deliveryCountry = deliveryCountry;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.deliveryAddress = customerAddress;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public int getDeliveryPostcode() {
        return deliveryPostcode;
    }

    public void setDeliveryPostcode(int deliveryPostcode) {
        this.deliveryPostcode = deliveryPostcode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id : " + deliveryId + ", " +
                "name : " + deliveryName + ", " +
                "address : " + deliveryAddress + ", " +
                "city : " + deliveryCity + ", " +
                "postcode : " + deliveryPostcode + ", " +
                "country : " + deliveryCountry +
                "}";
    }
}
