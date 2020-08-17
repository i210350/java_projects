package com.springboot30.application.repository;

import com.springboot30.application.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public
interface UserRepository extends JpaRepository<UserApp, Long> {

    UserApp findByMail(String mail);
    List<UserApp> getAllByActive(int active);
}