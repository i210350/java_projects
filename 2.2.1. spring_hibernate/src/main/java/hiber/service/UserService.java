package hiber.service;

import hiber.model.User;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UserService {
    void add(User user);

    List<User> listUsers();

    public List<User> listUsersIdAndSeries(Long id, int series);
}
