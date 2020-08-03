package com.example.demo.dao;


import com.example.demo.model.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserAppDAOImpl {

    @Autowired
    private EntityManager entityManager;

    public UserApp findById(Long id) {
        return this.entityManager.find(UserApp.class, id);
    }

    public UserApp findUserAccount(String userName) {
        try {
            String sql = "Select e from " + UserApp.class.getName() + " e " //
                    + " Where e.userName = :userName ";

            Query query = entityManager.createQuery(sql, UserApp.class);
            query.setParameter("userName", userName);

            return (UserApp) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

