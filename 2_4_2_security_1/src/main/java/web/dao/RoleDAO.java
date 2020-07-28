package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> allRolesExist();
    Role getById(int id);
    Role getByName(String username);
}
