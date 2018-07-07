package com.mrKhoai.webshop.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "STAFF")
public class Staff {
    @Id
    @GenericGenerator(name = "staff_generator", strategy = "com.mrKhoai.webshop.objects.StaffIdGenerator")
    @GeneratedValue(generator = "staff_generator")
    @Column(name = "STAFF_ID", length = 50, nullable = false, unique = true)
    private String staffId;

    @Column(name = "STAFF_NAME", nullable = false)
    private String staffName;

    @Column(name = "STAFF_FULL_NAME", nullable = false)
    private String staffFullName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getStaffFullName() {
        return staffFullName;
    }

    public void setStaffFullName(String staffFullName) {
        this.staffFullName = staffFullName;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId : " + staffId + ", " +
                "staffName : " + staffName +
                "password : " + password +
                "email : " + email +
                "}";
    }
}
