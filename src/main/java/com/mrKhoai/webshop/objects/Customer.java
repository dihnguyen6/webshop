package com.mrKhoai.webshop.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GenericGenerator(name = "customer_generator", strategy = "com.mrKhoai.webshop.objects.CustomerIdGenerator")
    @GeneratedValue(generator = "customer_generator")
    @Column(name = "CUSTOMER_ID", length = 20, nullable = false, unique = true)
    private String customerId;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customerName;

    @Column(name = "CUSTOMER_FULL_NAME", nullable = false)
    private String customerFullName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Order> oders;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOders() {
        return oders;
    }

    public void setOders(List<Order> oders) {
        this.oders = oders;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId : " + customerId + ", " +
                "staffName : " + customerName +
                "password : " + password +
                "email : " + email +
                "}";
    }
}
