package com.springboot30.application.repository;

import com.springboot30.application.model.Role;

import java.util.List;

public interface RoleService {

    public Role findByName(String name);
    public List<Role> findAllRoles();
    public Role getRoleById(Long id);
}
