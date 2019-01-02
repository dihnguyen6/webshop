package com.mrKhoai.webshop.objects;

import com.mrKhoai.webshop.tools.IdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STAFF")
public class Staff implements Identifiable{
    @Id
    @GeneratedValue(generator = "staff_generator", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "staff_generator",
            strategy = "com.mrKhoai.webshop.tools.IdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INFIX_PARAMETER, value = "STAFF"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            }
    )
    @Column(name = "STAFF_ID", length = 30, nullable = false, unique = true)
    private String staffId;

    @Column(name = "STAFF_USERNAME", nullable = false)
    private String staffUsername;

    @Column(name = "STAFF_PASSWORD", nullable = false)
    private String staffPassword;

    @ManyToOne
    @JoinColumn(name = "ROLE_NAME")
    private Role role;

    @OneToOne(mappedBy = "staff")
    private CV cv;

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

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "idd : " + staffId + ", " +
                "username : " + staffUsername + ", " +
                "password : " + staffPassword +
                "}";
    }

    @Override
    public Serializable getId() {
        return staffId;
    }
}
