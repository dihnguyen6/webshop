package com.mrKhoai.webshop.objects;

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
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", nullable = false, unique = true)
    private int roleId;

    @Column(name = "ROLE_NAME", nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<Staff> staffs;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId : " + roleId + ", " +
                "roleName : " + roleName +
                "}";
    }
}
