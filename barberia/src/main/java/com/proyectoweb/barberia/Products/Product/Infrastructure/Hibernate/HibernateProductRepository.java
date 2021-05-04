package com.proyectoweb.barberia.Products.Product.Infrastructure.Hibernate;

import com.proyectoweb.barberia.Products.Product.Domain.Ports.ProductRepository;
import com.proyectoweb.barberia.Products.Product.Domain.Product;
import com.proyectoweb.barberia.Shared.Domain.Products.ProductId;
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
public class HibernateProductRepository implements ProductRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Product> aggregateClass;

    public HibernateProductRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Product.class;
    }

    @Override
    public void update(Product product) {
        this.sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public Optional<Product> find(String productId) {
        ProductId id = new ProductId(productId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Product>> all() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root);
        Query<Product> query = session.createQuery(criteriaQuery);
        return Optional.ofNullable(query.getResultList());
    }
}
