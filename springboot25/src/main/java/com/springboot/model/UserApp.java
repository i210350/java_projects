package com.springboot.model;

import javax.persistence.*;


@Entity
@Table(name = "users", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "users_UK", columnNames = "mail") })
public class UserApp {

    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private int id;

    @Column(name = "name", length = 36, nullable = false)
    private String userName;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @Column(name = "mail", length = 128, nullable = false)
    private String mail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
