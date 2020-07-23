package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import web.model.Role;

import javax.persistence.TypedQuery;

public class RoleDAOImpl implements RoleDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Role getRoleByName(String roleName) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Role> query = session.createQuery("from Role as r where r.name like :roleName ");
        query.setParameter("roleName", roleName);
        return query.getResultList().get(0);
    }
}
