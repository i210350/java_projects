package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.RoleDAO;
import web.dao.UserDAO;
import web.model.Role;

public class RoleServiceImpl implements RoleDAO {
    private RoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDAO.getRoleByName(roleName) ;
    }
}
