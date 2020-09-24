package com.springboot30.application.controller;

import com.springboot30.application.model.UserApp;
import com.springboot30.application.repository.RoleRepository;
import com.springboot30.application.repository.UserRepository;
import com.springboot30.application.repository.UserService;
import com.springboot30.application.service.RoleServiceImpl;
import com.springboot30.application.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAPIController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public UserApp getUserById(@PathVariable("id") Long id) {
//            throws RecordNotFoundException {
        UserApp userApp = userService.getUserById(id);

        return userApp;
    }

    @PostMapping("/add")
    void addUser(@RequestBody UserApp newUser) {
        userService.saveUser(newUser);
    }

    @PutMapping("/edit")
    void editUser(@RequestBody UserApp editUser) {
        userService.saveUser(editUser);
    }

    @DeleteMapping("/delete")
    void deleteUser(@RequestBody UserApp deleteUser) {
        userService.deleteUser(deleteUser);
    }

    @GetMapping("/users")
    public List<UserApp> getAllUsers() {
        List<UserApp> usersApp = userService.getAllByActive(1);
        return usersApp;
    }

    @GetMapping("/currentUser")
    public List<UserApp> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserApp user = userService.findUserByEmail(auth.getName());
        UserApp user = userService.findUserByEmail(auth.getName());
        List<UserApp> usersList = new ArrayList<>();
        usersList.add(user);
        return usersList;
    }

}
