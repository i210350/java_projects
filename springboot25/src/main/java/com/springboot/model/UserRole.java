package com.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "UserRole",
        uniqueConstraints = {
                @UniqueConstraint(name = "USERROLE_UK", columnNames = { "user_id", "role_id" }) })
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserApp appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleApp appRole;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserApp getAppUser() {
        return appUser;
    }

    public void setAppUser(UserApp appUser) {
        this.appUser = appUser;
    }

    public RoleApp getAppRole() {
        return appRole;
    }

    public void setAppRole(RoleApp appRole) {
        this.appRole = appRole;
    }
}