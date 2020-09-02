package com.springboot30.application.controller;

import com.springboot30.application.model.UserApp;
import com.springboot30.application.repository.RoleRepository;
import com.springboot30.application.repository.UserRepository;
import com.springboot30.application.service.RoleServiceImpl;
import com.springboot30.application.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAPIController {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
    @Autowired
    UserServiceImpl userServiceImpl;

//    @PostMapping(
//            value = "/users",
//            consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
//            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE}
//    )
//    public UserApp create(@RequestBody UserApp userApp)
//    {
//        return userRepository.save(userApp);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<UserApp> getUserById(@PathVariable("id") Long id) {
////            throws RecordNotFoundException {
//        UserApp userApp = userServiceImpl.getUserById(id);
//
//        return new ResponseEntity<UserApp>(userApp, new HttpHeaders(), HttpStatus.OK);
//    }


    @GetMapping("/{id}")
    public UserApp getUserById(@PathVariable("id") Long id) {
//            throws RecordNotFoundException {
        UserApp userApp = userServiceImpl.getUserById(id);

        return userApp;
    }

    @GetMapping("/testUser")
    public UserApp getUserTest() {
        UserApp user = new UserApp();
        user.setName("Сигизмунд");
        user.setLastname("Петров");
        user.setMail("kdkdkd@hjjdhj");
        return user;
    }
}
