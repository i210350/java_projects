package com.springboot30.application.repository;

import com.springboot30.application.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public
interface UserRepository extends JpaRepository<UserApp, Long> {

    UserApp findByMail(String mail);
    List<UserApp> getAllByActive(int active);

    @Override
    Optional<UserApp> findById(Long aLong);

    @Override
    void delete(UserApp userApp);

    @Override
    UserApp getOne(Long aLong);
}