package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository("RoleDAO")
public class RoleDAOImpl implements RoleDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Role> allRolesExist() {

        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Role> query = session.createQuery("from Role ");
        return query.getResultList();
    }
}
