package com.example.demo.service;

import com.example.demo.dao.RoleDAO;
import com.example.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    private RoleDAO roleDAO;

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

    @Override
    @Transactional
    public Role getByName(String nameRole) {
        return roleDAO.getByName(nameRole);
    }

    @Override
    @Transactional
    public List<Role> getRoleNames(String nameUser) {
        return roleDAO.getRoleNames(nameUser);
    }
}
