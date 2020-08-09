package com.springboot30.application.repository;

import com.springboot30.application.model.Role;
import com.springboot30.application.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository ("roleRepository")
public
interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
