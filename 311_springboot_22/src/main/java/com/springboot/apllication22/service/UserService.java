package com.springboot.apllication22.service;

import com.springboot.apllication22.model.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}
