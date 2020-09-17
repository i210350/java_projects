package com.example.application314.controller;


import com.example.application314.model.UserApp;
import com.example.application314.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAPIController {
    @Autowired
    UserServiceImpl userServiceImpl;


    @GetMapping("/{id}")
    public UserApp getUserById(@PathVariable("id") Long id) {
//            throws RecordNotFoundException {
        UserApp userApp = userServiceImpl.getUserById(id);

        return userApp;
    }

//    @PostMapping("/add")
//    void addUser(@RequestBody UserApp newUser) {
//        userServiceImpl.saveUser(newUser);
//    }

//    @PutMapping("/edit")
//    void editUser(@RequestBody UserApp editUser) {

//        userServiceImpl.saveUser(editUser);
//    }

    @DeleteMapping("/delete")
    void deleteUser(@RequestBody UserApp deleteUser) {
        userServiceImpl.deleteUser(deleteUser);
    }

    @GetMapping("/users")
    public List<UserApp> getAllUsers() {
        List<UserApp> usersApp = userServiceImpl.getAllByActive(1);
        return usersApp;
    }

    @GetMapping("/currentUser")
    public List<UserApp> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserApp user = userServiceImpl.findUserByEmail(auth.getName());
        List<UserApp> usersList = new ArrayList<>();
        usersList.add(user);
        return usersList;
    }

}
