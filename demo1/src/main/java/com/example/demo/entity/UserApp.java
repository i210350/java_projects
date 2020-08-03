package com.example.demo.entity;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
class UserApp {

    @Id
    Long id;

    String name;

    @ManyToMany
    Set<Role> allRoless;

    // additional properties
    // standard constructors, getters, and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getLikedCourses() {
        return likedCourses;
    }

    public void setLikedCourses(Set<Role> likedCourses) {
        this.likedCourses = likedCourses;
    }
}

