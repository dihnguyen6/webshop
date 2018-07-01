package com.mrKhoai.webshop.objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "STAFF")
public class Staff {

    private enum Role {
        ADMINISTRATOR, SALE_ASSISTANT, PRODUCT_MANAGER, WEB_DEV, CUSTOMER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STAFF_ID", length = 20, nullable = false, unique = true)
    private String staffId;

    @Column(name = "STAFF_NAME", nullable = false)
    private String staffName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
    private List<Order> oders;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Order> getOders() {
        return oders;
    }

    public void setOders(List<Order> oders) {
        this.oders = oders;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId : " + staffId + ", " +
                "staffName : " + staffName +
                "password : " + password +
                "email : " + email +
                "companyName : " + companyName +
                "}";
    }
}
