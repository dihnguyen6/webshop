package com.mrKhoai.webshop.objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false, unique = true)
    private int customerId;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customerName;

    @Column(name = "CUSTOMER_EMAIL")
    private String customerEmail;

    @Column(name = "CUSTOMER_ADDRESS")
    private String customerAddress;

    @Column(name = "CUSTOMER_CITY")
    private String customerCity;

    @Column(name = "CUSTOMER_POSTCODE")
    private int customerPostcode;

    @Column(name = "CUSTOMER_COUNTRY")
    private String customerCountry;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Basket> baskets = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public int getCustomerPostcode() {
        return customerPostcode;
    }

    public void setCustomerPostcode(int customerPostcode) {
        this.customerPostcode = customerPostcode;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public Set<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
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
                "id : " + customerId + ", " +
                "name : " + customerName + ", " +
                "email : " + customerEmail + ", " +
                "adress : " + customerAddress + ", " +
                "city : " + customerCity + ", " +
                "postcode : " + customerPostcode + ", " +
                "country : " + customerCountry +
                "}";
    }
}
