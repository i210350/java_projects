package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.UserApp;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository("RoleDAO")
//разница между component   /scoop beans    / контейнер спринг  /beanfactory & application context
public class RoleDAOImpl implements RoleDAO {
    @Lazy   // @PostContract
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

    @Override
    public Role getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class, id);
    }

    @Override
    public Role getByName(String nameRole) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Role> query = session.createQuery("from Role as r where r.name like :name ");
        query.setParameter("name", nameRole);
        return query.getResultList().get(0);
    }

}
