package com.proyectoweb.barberia.Services.CarritoService.Infrastructure.Hibernates;

import com.proyectoweb.barberia.Services.CarritoService.Domain.CarritoServices;
import com.proyectoweb.barberia.Services.CarritoService.Domain.Ports.CarritoServicesRepository;
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
public class HibernatesCarritoServicesReposiroty implements CarritoServicesRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<CarritoServices> aggregateClass;


    public HibernatesCarritoServicesReposiroty(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = CarritoServices.class;
    }

    @Override
    public void save(CarritoServices carritoServices) {
        sessionFactory.getCurrentSession().save(carritoServices);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public void update(CarritoServices carritoServices) {

    }

    @Override
    public Optional<CarritoServices> find(String carritoServiceId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<CarritoServices>> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarritoServices> criteriaQuery = criteriaBuilder.createQuery(CarritoServices.class);
        Root<CarritoServices> root = criteriaQuery.from(CarritoServices.class);
        criteriaQuery.select(root);
        Query<CarritoServices> query = session.createQuery(criteriaQuery);
        return Optional.ofNullable(query.getResultList());
    }
}
