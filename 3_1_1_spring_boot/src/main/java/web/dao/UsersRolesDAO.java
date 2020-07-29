package web.dao;

import web.model.Users_Roles;

public interface UsersRolesDAO {
    Users_Roles getById_Users_Roles(int idUsers, int idRoles);
}
