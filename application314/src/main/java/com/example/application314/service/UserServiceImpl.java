package com.example.application314.service;

import com.example.application314.model.UserApp;
import com.example.application314.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service("userService")
public class UserServiceImpl {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public UserApp findUserByEmail(String email) {
        return userRepository.findByMail(email);
    }

    @Transactional
    public void deleteUser(UserApp delUser) {
        userRepository.delete(delUser);
    }

    @Transactional
    public UserApp getUserById(Long id) {
        Optional<UserApp> userAppResponse =  userRepository.findById(id);
        if(userAppResponse.isPresent()) {
            return userAppResponse.get();
        }else {
            throw new RuntimeException("No record found for given id: "+id);
        }
    }

    @Transactional
    public Optional<UserApp> getById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public List<UserApp> getAllByActive(int active) {
        return userRepository.getAllByActive(active);
    }


}
