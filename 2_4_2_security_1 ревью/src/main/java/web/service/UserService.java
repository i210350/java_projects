package web.service;

import org.springframework.security.core.userdetails.User;
import web.model.Role;
import web.model.UserApp;
import web.model.UserApp;

import java.util.List;

public interface UserService {
    List<UserApp> allUsers();

    UserApp add(UserApp userApp);

    void delete(UserApp userApp);

    void edit(UserApp userApp);

    UserApp getById(int id);

    UserApp getByName(String username);


}
