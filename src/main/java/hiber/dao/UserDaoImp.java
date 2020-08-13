package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
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

   public User getUserByIdAuto(int series) {
//      User query;
//      User query;
//      query = (User) getSessionFactory().getCurrentSession().createQuery("from User where auto.series = :autoSeries")
//              .setParameter("autoSeries",series).executeUpdate();
      TypedQuery<User> query= sessionFactory.getCurrentSession().createQuery("from User user where user.auto.series = :series");
      User user = query.setParameter("series", series).getSingleResult();

      return user;

   }

   private SessionFactory getSessionFactory() {
      return sessionFactory;
   }

}
