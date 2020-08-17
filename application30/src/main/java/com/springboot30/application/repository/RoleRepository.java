package com.springboot30.application.repository;

import com.springboot30.application.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository ("roleRepository")
public
interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    List<Role> findAll();

    Role getRoleById(Long id);
}
