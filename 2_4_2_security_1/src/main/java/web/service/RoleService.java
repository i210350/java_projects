package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> allRolesExist();
    Role getById(int id);
    Role getByName(String nameRole);
}
