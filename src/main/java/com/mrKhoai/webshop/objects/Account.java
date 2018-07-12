package com.mrKhoai.webshop.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GenericGenerator(name = "account_generator", strategy = "com.mrKhoai.webshop.objects.AccountIdGenerator")
    @GeneratedValue(generator = "account_generator")
    @Column(name = "ACCOUNT_ID", length = 20, nullable = false, unique = true)
    private String accountId;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(mappedBy = "account")
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
}
