package com.example.demo.service;

import com.example.demo.model.UserApp;

import java.util.List;

public interface UserService {
    List<UserApp> allUsers();

    UserApp add(UserApp userApp);

    void delete(UserApp userApp);

    void edit(UserApp userApp);

    UserApp getById(int id);

    UserApp getByName(String username);


}
