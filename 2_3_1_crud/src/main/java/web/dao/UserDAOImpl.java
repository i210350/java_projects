package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
import web.dao.UserDAO;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
}













//package web.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import web.model.User;
//
//import java.util.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Repository
//public class UserDAOImpl implements UserDAO {
//    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
//    private static Map<Integer, User> users = new HashMap<>();
//
//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public List<User> allUsers() {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("from User").list();
//    }
////    public List<User> allUsers() {
////        return new ArrayList<>(users.values());
////    }
//
//    @Override
//    public void add(User user) {
//        user.setId(AUTO_ID.getAndIncrement());
//        users.put(user.getId(), user);
//    }
//
//    @Override
//    public void delete(User user) {
//        users.remove(user.getId());
//    }
//
//    @Override
//    public void edit(User user) {
//        users.put(user.getId(), user);
//    }
//
//    @Override
//    public User getById(int id) {
//        return users.get(id);
//    }
//}