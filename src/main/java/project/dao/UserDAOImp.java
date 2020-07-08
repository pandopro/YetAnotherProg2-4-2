package project.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.Model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
class UserDAOImp implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);

    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = this.sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public Boolean remove(long id) {
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("delete from User where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public Boolean edit(long id, User user) {
        try {
            sessionFactory.getCurrentSession().update(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User getUser(long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
