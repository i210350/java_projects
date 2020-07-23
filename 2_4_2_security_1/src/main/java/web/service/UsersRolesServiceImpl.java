package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.dao.UsersRolesDAO;
import web.model.Users_Roles;

import javax.transaction.Transactional;

@Service
public class UsersRolesServiceImpl implements UsersRolesService {
    private UsersRolesDAO usersRolesDAO;

    public UsersRolesDAO getUsersRolesDAO() {
        return usersRolesDAO;
    }

    @Autowired
    public void setUsersRolesDAO(UsersRolesDAO usersRolesDAO) {
        this.usersRolesDAO = usersRolesDAO;
    }

    @Override
    @Transactional
    public Users_Roles getById_Users_Roles(int idUsers, int idRoles) {
        return usersRolesDAO.getById_Users_Roles(idUsers, idRoles);
    }

}
