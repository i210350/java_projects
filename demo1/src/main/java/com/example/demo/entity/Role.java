package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role {


    @Id
    int id;

    @ManyToMany
    Set<UserApp> allUsers;
}
