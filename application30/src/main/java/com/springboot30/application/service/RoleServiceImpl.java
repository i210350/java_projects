package com.springboot30.application.service;

import com.springboot30.application.model.Role;
import com.springboot30.application.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//@Qualifier("roleRepository")

@Service
public class RoleServiceImpl {


@Qualifier("roleRepository")
@Autowired
    private RoleRepository roleRespository;

    @Transactional
    public Role findByName(String name) {
       return roleRespository.findByName(name);
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