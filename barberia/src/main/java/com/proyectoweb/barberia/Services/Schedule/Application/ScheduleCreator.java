package com.proyectoweb.barberia.Services.Schedule.Application;

import com.proyectoweb.barberia.Services.Schedule.Domain.Ports.ScheduleRepository;
import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleDate;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleOption;
import com.proyectoweb.barberia.Shared.Domain.Bus.Event.EventBus;
import com.proyectoweb.barberia.Shared.Domain.Schedule.ScheduleId;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;

import java.sql.Timestamp;

public class ScheduleCreator {

    private ScheduleRepository repository;
    private EventBus eventBus;

    public ScheduleCreator(ScheduleRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute( String id, String time, String service_id, char type){
        Schedule schedule = new Schedule(new ScheduleId(id),new ServiceId(service_id),new ScheduleDate(Timestamp.valueOf(time)),new ScheduleOption(type));
        repository.save(schedule);
        this.eventBus.publish(schedule.pullDomainEvents());
    }
}