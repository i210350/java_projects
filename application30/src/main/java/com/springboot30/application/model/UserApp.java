package com.springboot30.application.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
public class UserApp implements Serializable, UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "active")
    private int active;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;


//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)    //
//    @JoinTable(name = "users_roles",
//        joinColumns = { @JoinColumn(name = "id") },
//        inverseJoinColumns = { @JoinColumn(name = "users_id") })
//    @JoinTable(name = "users_roles",
//            joinColumns = { @JoinColumn(name = "users_id") },
//            inverseJoinColumns = { @JoinColumn(name = "roles_id") })
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)    //
    @JoinTable(name = "users_roles",
        joinColumns = { @JoinColumn(name = "users_id") },
        inverseJoinColumns = { @JoinColumn(name = "roles_id") })
    Set <Role> roles = new HashSet <> ();

    public UserApp() {
    }

    public UserApp(String name, String lastname, int active, String mail, String password, Set<Role> roles) {
        this.name = name;
        this.lastname = lastname;
        this.active = active;
        this.mail = mail;
        this.password = password;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addRole(Role role) {
        roles.add(role);
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles.addAll(roles);
    }

    public String getStingRoles() {
        StringBuilder strR = new StringBuilder();
        for (Role r : getRoles()) {
            strR.append(r.getName());
            strR.append(" ");
        }
        return strR.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", active=" + active +
                ", mail='" + mail + '\'' +
                '}';
    }
}