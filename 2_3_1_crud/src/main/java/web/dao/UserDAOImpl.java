package web.dao;

import web.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UserDAOImpl implements UserDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, User> users = new HashMap<>();

    static {
        User user1 = new User();
        user1.setId(AUTO_ID.getAndIncrement());
        user1.setName("Vasya");
        user1.setLastname("Petrov");
        user1.setOld(30);
        user1.setMail("bb@nnnn.com");
        users.put(user1.getId(), user1);

        User user2 = new User();
        user2.setId(AUTO_ID.getAndIncrement());
        user2.setName("Tanya");
        user2.setLastname("Petrova");
        user2.setOld(30);
        user2.setMail("dd@hhhh.com");
        users.put(user2.getId(), user1);
    }
    @Override
    public List<User> allUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void add(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public void edit(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }
}