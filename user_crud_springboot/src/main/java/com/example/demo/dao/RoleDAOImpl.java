package com.example.demo.dao;

import com.example.demo.model.Role;
import com.example.demo.model.UserApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("RoleDAO")
@Transactional
public class RoleDAOImpl implements RoleDAO {
//    private SessionFactory sessionFactory;

    @Autowired
    private EntityManager entityManager;

//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Override
    public List<Role> allRolesExist() {
        return (List<Role>) entityManager.createQuery("FROM Role ").getResultList();
    }

    @Override
    public Role getById(int id) {
        return this.entityManager.find(Role.class, id);
    }

    @Override
    public Role getByName(String nameRole) {
        try {
            String sql = "from UserApp  where name = :nameRole ";

            Query query = entityManager.createQuery(sql, UserApp.class);
            query.setParameter("nameRole", nameRole);

            return (Role) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Role> getRoleNames(String nameUser) {
        try {
            String sql = "from Role  where name = :userName ";

            Query query = entityManager.createQuery(sql, Role.class);
            query.setParameter("userName", nameUser);

            return (List<Role>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
