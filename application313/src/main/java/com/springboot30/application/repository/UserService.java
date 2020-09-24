package com.springboot30.application.repository;

import com.springboot30.application.model.UserApp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public UserApp findUserByEmail(String email);

    public void deleteUser(UserApp delUser);

    public UserApp getUserById(Long id);

    public List<UserApp> getAllByActive(int active);

    public Optional<UserApp> getById(Long id);

    public void saveUser(UserApp user);
}
