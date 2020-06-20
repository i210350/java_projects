package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public Session session = null;

    public UserDaoHibernateImpl(Session session) {
        this.session = session;
    }

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String query = "create table if not exists users (" +
                                                    "id bigint primary key not null auto_increment, " +
                                                    "name varchar(20), " +
                                                    "lastName varchar(30), " +
                                                    "age tinyint)";

        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery(query).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {
        String query = "drop table if exists users ";
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery(query).executeUpdate();
        session.getTransaction().commit();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = session.beginTransaction();
        session.save(new User(name, lastName, age));
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete User where id = :id");
        query.setParameter("id", id) ;
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public List<User> getAllUsers() {
        return session.createQuery("from User").list();
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete User");
        query.executeUpdate();
        transaction.commit();
    }
}
