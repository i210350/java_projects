package com.springboot.apllication22.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.apllication22.model.User;

import java.util.List;

@Repository("userRepository")
public
interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    List<User> getAllByActive(int active);
}