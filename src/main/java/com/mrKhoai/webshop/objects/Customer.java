package com.mrKhoai.webshop.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mrKhoai.webshop.tools.IdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Identifiable {
    @Id
    @GeneratedValue(generator = "customer_generator", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "customer_generator",
            strategy = "com.mrKhoai.webshop.tools.IdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INFIX_PARAMETER, value = "CUSTOMER"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d")
            }
    )
    @Column(name = "CUSTOMER_ID", nullable = false, unique = true, length = 30)
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

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
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

    @Override
    public Serializable getId() {
        return customerId;
    }
}
