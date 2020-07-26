package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDAO;
import web.dao.UserDAO;
import web.model.Role;
import web.model.UserApp;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    private RoleDAO roleDAO;

//    public RoleDAO getRoleDAO() {
//        return roleDAO;
//    }

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public List<Role> allRolesExist() {
        return roleDAO.allRolesExist();
    }

    @Override
    @Transactional
    public Role getById(int id) {
        return roleDAO.getById(id);
    }
}
