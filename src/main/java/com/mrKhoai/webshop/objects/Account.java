package com.mrKhoai.webshop.objects;

import com.mrKhoai.webshop.tools.IdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Identifiable {
    @Id
    @GeneratedValue(generator = "account_generator", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "account_generator",
            strategy = "com.mrKhoai.webshop.tools.IdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INFIX_PARAMETER, value = "ACCOUNT"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    @Column(name = "ACCOUNT_ID", length = 30, nullable = false, unique = true)
    private String accountId;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(mappedBy = "account")
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Delivery> deliveries = new HashSet<>();

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id : " + accountId + ", " +
                "username : " + username +
                "password : " + password +
                "}";
    }

    @Override
    public Serializable getId() {
        return accountId;
    }
}
