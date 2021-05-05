package com.proyectoweb.barberia.Services.Schedule.Infrastructure.Hibernates;


import com.proyectoweb.barberia.Services.Schedule.Domain.Ports.ScheduleRepository;
import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Shared.Domain.Schedule.ScheduleId;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateScheduleRepository implements ScheduleRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Schedule> aggregateClass;

    public HibernateScheduleRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Schedule.class;
    }

    @Override
    public void save(Schedule schedule) {
        sessionFactory.getCurrentSession().save(schedule);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public void update(Schedule schedule) {
        this.sessionFactory.getCurrentSession().update(schedule);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<Schedule> find(String scheduleId) {
        ScheduleId id = new ScheduleId(scheduleId);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }
}
