package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> allRolesExist();

    Role getById(int id);

    Role getByName(String nameRole);

    List<Role> getRoleNames(String nameUser);
}
