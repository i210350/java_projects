package com.example.demo.dao;


import com.example.demo.model.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManager;



    @Override
    public List<UserApp> allUsers() {
        return (List<UserApp>) entityManager.createQuery("FROM UserApp ").getResultList();
    }

    @Override
    public void add(UserApp userApp) {
        entityManager.persist(userApp);
    }

    @Override
    public void delete(UserApp userApp) {
        entityManager.remove(getById(userApp.getId()));
    }

    @Override
    public void edit(UserApp userApp) {
        UserApp user = getById(userApp.getId());
        user.setName(userApp.getName());
        user.setLastname(userApp.getLastname());
        user.setPassword(userApp.getPassword());
        user.setOld(userApp.getOld());
        user.setMail(userApp.getMail());
        entityManager.flush();
    }

    @Override
    public UserApp getById(int id) {
        return this.entityManager.find(UserApp.class, id);
    }

    @Override
    public UserApp getByName(String username) {
        try {
            String sql = "select e from UserApp where name = :userName ";

            Query query = entityManager.createQuery(sql, UserApp.class);
            query.setParameter("userName", username);

            return (UserApp) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

