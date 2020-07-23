package web.dao;

import web.model.Role;
import web.model.UserApp;
import web.model.UserApp;

import java.util.List;

public interface UserDAO {
    List<UserApp> allUsers();
    UserApp add(UserApp userApp);
    void delete(UserApp userApp);
    void edit(UserApp userApp);
    UserApp getById(int id);
    UserApp getByName(String username) ;
//    Role getRoleByName(String roleName);
}