package com.springboot30.application.service;


import com.springboot30.application.model.Role;
import com.springboot30.application.model.UserApp;
import com.springboot30.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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

    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserApp userApp = userRepository.findByMail(email);

        if (userApp == null) {
            throw new UsernameNotFoundException("Unknown mail: " + email);
        }

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (userApp.getRoles() != null) {
            for (Role role : userApp.getRoles()) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                grantList.add(authority);
            }
        }

        return new
                User(userApp.getName(), userApp.getPassword(), grantList);
    }


    @Transactional
    public void saveUser(UserApp user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        userRepository.save(user);
    }
}
