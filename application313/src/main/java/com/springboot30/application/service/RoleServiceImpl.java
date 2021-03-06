package com.springboot30.application.service;

import com.springboot30.application.model.Role;
import com.springboot30.application.model.UserApp;
import com.springboot30.application.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl {


@Qualifier("roleRepository")
@Autowired
    private RoleRepository roleRespository;

    @Transactional
    public Role findByName(String name) {
       return roleRespository.findByName(name);
    }



    @Transactional
    public List<Role> findAllRoles() {
        return roleRespository.findAll();
    }

    @Transactional
    public Role getRoleById(Long id) {
        Optional<Role> roleAppResponse =  roleRespository.findById(id);
        if(roleAppResponse.isPresent()) {
            return roleAppResponse.get();
        }else {
            throw new RuntimeException("No record found for given id: "+id);
        }
    }

}



//    @Autowired
//    private CustomizedEmployeesCrudRepository employeesCrudRepository;
//
//    @Transactional
//    public void testEmployeesCrudRepository() {
//        Optional<Employees> employeesOptional = employeesCrudRepository.findById(127L);
//        //....
//    }