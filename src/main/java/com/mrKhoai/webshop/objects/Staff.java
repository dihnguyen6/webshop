package com.mrKhoai.webshop.objects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STAFF")
public class Staff {
    @Id
    @GenericGenerator(name = "staff_generator", strategy = "com.mrKhoai.webshop.objects.StaffIdGenerator")
    @GeneratedValue(generator = "staff_generator")
    @Column(name = "STAFF_ID", length = 30, nullable = false, unique = true)
    private String staffId;

    @Column(name = "STAFF_USERNAME", nullable = false)
    private String staffUsername;

    @Column(name = "STAFF_PASSWORD", nullable = false)
    private String staffPassword;

    @ManyToOne
    @JoinColumn(name = "ROLE_NAME")
    private Role role;


    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "idd : " + staffId + ", " +
                "username : " + staffUsername + ", " +
                "password : " + staffPassword +
                "}";
    }
}
