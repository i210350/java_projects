package com.example.demo.dao;

import com.example.demo.model.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> allRolesExist();

    Role getById(int id);

    Role getByName(String nameRole);
}
