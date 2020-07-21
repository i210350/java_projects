package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import web.model.UserApp;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserApp> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from UserApp").list();
    }

    @Override
    public void add(UserApp userApp) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(userApp);
    }

    @Override
    public void delete(UserApp userApp) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(userApp);
    }

    @Override
    public void edit(UserApp userApp) {
        Session session = sessionFactory.getCurrentSession();
        session.update(userApp);
    }

    @Override
    public UserApp getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserApp.class, id);
    }

    @Override
    public UserApp getByName(String username) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<UserApp> query = session.createQuery("from UserApp as u where u.name like :name ");
        query.setParameter("name", username);
//        query.setParameter("id", 2);
        return query.getResultList().get(0);
    }
}
