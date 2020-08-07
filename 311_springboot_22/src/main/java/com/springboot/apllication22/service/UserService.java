package com.springboot.apllication22.service;

import com.springboot.apllication22.model.User;

import java.util.List;

public interface UserService {

    public User findUserByEmail(String email);
    public List<User> getAllByActive(int active);

    public void saveUser(User user);
}
