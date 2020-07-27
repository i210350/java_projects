package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.Users_Roles;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository("UsersRolesDAO")
public class UsersRolesDAOImpl implements UsersRolesDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Users_Roles getById_Users_Roles(int idUsers, int idRoles) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Users_Roles> query = session.createQuery("from Users_Roles as ur where ur.users_id = :idUsers and ur.roles_id = :idRoles ");
        return query.getResultList().get(0);
    }
}
