package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import web.model.User;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Here we are using dummy data, you need to load user data from
     database or other third party application*/
//        User user = findUserbyUername(username);
//
//        UserBuilder builder = null;
//        if (user != null) {
//            builder = org.springframework.security.core.userdetails.User.withUsername(username);
//            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
//            builder.roles(user.getRoles().toString());
//        } else {
//            throw new UsernameNotFoundException("User not found.");
//        }
//
//        return builder.build();
        return  null;
    }


//    private User findUserbyUername(String username) {
//        return userDAO.getByName(username) ;
//    }
}