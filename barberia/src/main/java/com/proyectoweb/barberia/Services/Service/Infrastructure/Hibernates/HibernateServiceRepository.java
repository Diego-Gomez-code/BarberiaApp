package com.proyectoweb.barberia.Services.Service.Infrastructure.Hibernates;


import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;
import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;
import com.proyectoweb.barberia.Shared.Domain.Users.UserId;
import com.proyectoweb.barberia.Users.User.Domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateServiceRepository implements ServiceRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Service> aggregateClass;

    public HibernateServiceRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Service.class;
    }

    @Override
    public void save(Service service) {
        sessionFactory.getCurrentSession().save(service);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<Service> find(String serviceId) {
        ServiceId id = new ServiceId(serviceId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void update(Service service) {
        this.sessionFactory.getCurrentSession().update(service);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Service>> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Service> criteriaQuery = criteriaBuilder.createQuery(Service.class);
        Root<Service> root = criteriaQuery.from(Service.class);
        criteriaQuery.select(root);
        Query<Service> query = session.createQuery(criteriaQuery);
        return Optional.ofNullable(query.getResultList());
    }
}
