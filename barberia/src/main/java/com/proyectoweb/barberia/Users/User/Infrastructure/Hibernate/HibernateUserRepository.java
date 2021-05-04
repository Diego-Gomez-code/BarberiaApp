package com.proyectoweb.barberia.Users.User.Infrastructure.Hibernate;

import com.proyectoweb.barberia.Shared.Domain.Users.UserId;
import com.proyectoweb.barberia.Users.User.Domain.User;
import com.proyectoweb.barberia.Users.User.Domain.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateUserRepository implements UserRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<User> aggregateClass;

   public HibernateUserRepository(@Qualifier("session-factory") SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.aggregateClass = User.class;
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<User> find(String userId) {
        UserId id = new UserId(userId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void update(String userId, User user) {
       this.sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public Optional<List<User>> all() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        Query<User> query = session.createQuery(criteriaQuery);
        //String select = "";
        //Query query = sessionFactory.getCurrentSession().createQuery(select);
        return Optional.ofNullable(query.getResultList());
    }
}
