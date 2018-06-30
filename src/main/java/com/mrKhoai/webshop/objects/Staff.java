package com.mrKhoai.webshop.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Staff {

    private enum Role {
        ADMINISTRATOR, SALE_ASSISTANT, PRODUCT_MANAGER, WEB_DEV, CUSTOMER
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID", length = 20, nullable = false, unique = true)
    private String staffId;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String staffName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;

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
}
