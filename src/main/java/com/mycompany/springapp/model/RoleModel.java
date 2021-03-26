package com.mycompany.springapp.model;

import javax.persistence.*;

@Entity(name="ROLE_TABLE")
public class RoleModel {

    @Column(name="ROLE_NAME")
    private String roleName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ROLE_ID")
    private Long roleId;

    @Column(name="ROLE_NAME")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
