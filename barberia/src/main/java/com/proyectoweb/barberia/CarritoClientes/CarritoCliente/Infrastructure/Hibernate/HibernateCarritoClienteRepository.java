package com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Infrastructure.Hibernate;

import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.CarritoCliente;
import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.Ports.CarritoClienteRepository;
import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.ValueObjects.CarritoClienteId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateCarritoClienteRepository implements CarritoClienteRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<CarritoCliente> aggregateClass;

    public HibernateCarritoClienteRepository(@Qualifier("session-factory") SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.aggregateClass = CarritoCliente.class;
    }

    @Override
    public void save(CarritoCliente carritoCliente) {
        sessionFactory.getCurrentSession().save(carritoCliente);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<CarritoCliente> find(String carritoClienteId) {
        CarritoClienteId id = new CarritoClienteId(carritoClienteId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }
}
