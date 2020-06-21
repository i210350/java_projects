package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
///
    private SessionFactory sessionFactory;
    private static UserServiceImpl userServiceImpl ;
    public static UserServiceImpl getInstance() {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImpl(Util.getSessionFactory());
        }
        return userServiceImpl;
    }

    private UserServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserServiceImpl() {
    }


    public void createUsersTable() {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl(sessionFactory.openSession());
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl(sessionFactory.openSession());
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl(sessionFactory.openSession());
        userDaoHibernate.saveUser(name, lastName, age);
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl(sessionFactory.openSession());
        userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl(sessionFactory.openSession());
        List<User> list = userDaoHibernate.getAllUsers();
        list.forEach(u -> System.out.println(u.toString()));
        return list;
    }

    public void cleanUsersTable() {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl(sessionFactory.openSession());
        userDaoHibernate.cleanUsersTable();
    }
}
