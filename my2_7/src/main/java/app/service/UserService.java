package app.service;

import app.DAO.UserDAO;
import app.entities.User;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class UserService {


    private SessionFactory sessionFactory;

    private static UserService userService ;

    public static UserService getInstance() {
        if (userService == null) {

            userService = new UserService();
        }
        return userService;
    }

//    private UserService(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    private UserService() {
    }


    public void add(User user) {
        app.DAO.UserDAO userDAO = new UserDAO();
        userDAO.insert(user.getName(), user.getAge());

    }


    public List<User> list() {
        app.DAO.UserDAO userDAO = new UserDAO();
        return userDAO.getAllUsers();
    }
}
