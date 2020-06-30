package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }


   @Override
   public List<User> listUsersIdAndSeries(Long id, int series) {
      Session session = sessionFactory.getCurrentSession(); //.getSession();
//      Transaction transaction = session.beginTransaction();
      Query query = session.createQuery("from User as u join u.car c where u.car = c.id and u.id = :id and c.series = :series");
      query.setParameter("id", id);
      query.setParameter("series", series);
//      transaction.commit();
      return (List<User>)query.list();
   }

}
