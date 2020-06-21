package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = UserServiceImpl.getInstance();
        userService.createUsersTable();
        userService.saveUser("Maria", "Ivanova", (byte) 20);
        userService.saveUser("Anna", "Petrova", (byte) 25);
        userService.saveUser("Katya", "Koroleva", (byte) 30);
        userService.saveUser("Natali", "Alexandrova", (byte) 35);
        userService.getAllUsers();
        userService.dropUsersTable();
    }
}
