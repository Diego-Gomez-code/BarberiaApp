package com.proyectoweb.barberia.Products.CarritoCompra.Infrastructure.Hibernate;

import com.proyectoweb.barberia.Products.CarritoCompra.Domain.CarritoCompra;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Ports.CarritoCompraRepository;
import com.proyectoweb.barberia.Shared.Domain.Products.CarritoCompraId;
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
public class HibernateCarritoCompraRepository implements CarritoCompraRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<CarritoCompra> aggregateClass;

    public HibernateCarritoCompraRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = CarritoCompra.class;
    }

    @Override
    public void update(CarritoCompra carritoCompra) {
        this.sessionFactory.getCurrentSession().update(carritoCompra);
    }

    @Override
    public Optional<CarritoCompra> find(String carritoCompraId) {
        CarritoCompraId id = new CarritoCompraId(carritoCompraId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(CarritoCompra carritoCompra) {
        sessionFactory.getCurrentSession().save(carritoCompra);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<CarritoCompra>> all() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CarritoCompra> criteriaQuery = criteriaBuilder.createQuery(CarritoCompra.class);
        Root<CarritoCompra> root = criteriaQuery.from(CarritoCompra.class);
        criteriaQuery.select(root);
        Query<CarritoCompra> query = session.createQuery(criteriaQuery);
        return Optional.ofNullable(query.getResultList());
    }
}
