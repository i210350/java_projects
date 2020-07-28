package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import web.model.Role;
import web.model.UserApp;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.UserApp;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<UserApp> allUsers() {
        return userDAO.allUsers();
    }

//    @Override
//    @Transactional
//    public void add(UserApp userApp) {
//        userDAO.add(userApp);
//    }

    @Override
    @Transactional
    public UserApp add(UserApp userApp) {
        userDAO.add(userApp);
        return userApp;
    }

    @Override
    @Transactional
    public void delete(UserApp userApp) {
        userDAO.delete(userApp);
    }

    @Override
    @Transactional
    public void edit(UserApp userApp) {
        userDAO.edit(userApp);
    }

    @Override
    @Transactional
    public UserApp getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp userApp = findUserbyUername(username);

        if (userApp == null) {
            throw new UsernameNotFoundException("Unknown user: " + username);
        }

//        UserDetails userDetails = User.builder()
//                .username(userApp.getName())
//                .password(userApp.getPassword())
//                .roles(userApp.getRoles().stream().map(Role::getName).toArray(String[]::new))
//                .build();
////        System.out.println(userApp.getAuthorities());
//        return userDetails;

        // с помощью нашего сервиса UserService получаем User
//        User user = userService.getUser("colibri");
        // указываем роли для этого пользователя
        //        roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));
        Set<GrantedAuthority> roles = new HashSet<>(userApp.getAuthorities());

        // на основании полученных данных формируем объект UserDetails
        // который позволит проверить введенный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя

        return new User(userApp.getName(),     //org.springframework.security.core.userdetails.
                userApp.getPassword(),
                roles);

    }


    private UserApp findUserbyUername(String username) {
        return userDAO.getByName(username) ;
    }


}