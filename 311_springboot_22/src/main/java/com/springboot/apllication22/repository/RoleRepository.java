package com.springboot.apllication22.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.apllication22.model.Role;

@Repository("roleRepository")
public
interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
}
