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
public class UserServiceImpl {  // implements UserService, UserDetailsService {

//    @Qualifier("userRepository")
@Qualifier("userRepository")
@Autowired
    private UserRepository userRepository;

//    @Qualifier("roleRepository")
//    @Autowired
//    private RoleRepository roleRespository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


//    @Override
    @Transactional
    public UserApp findUserByEmail(String email) {
        return userRepository.findByMail(email);
    }

    @Transactional
    public void deleteById(Long id) {
//        userRepository.deleteById(id);
        userRepository.deleteById(id);
    }

    @Transactional
    public UserApp getById(Long id) {
        return userRepository.findById(id).get();
    }

//    @Transactional
//    public void editUser(UserApp user) {
////        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
////        user.setActive(1);
////        Role userRole = roleRespository.findByName("ADMIN");
////        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//        userRepository.save(user);
//    }

//    @Override
    @Transactional
    public List<UserApp> getAllByActive(int active) {
        return userRepository.getAllByActive(active);
    }


//    @Override
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

//    @Override
    @Transactional
    public void saveUser(UserApp user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
//        Role userRole = roleRespository.findByName("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}
