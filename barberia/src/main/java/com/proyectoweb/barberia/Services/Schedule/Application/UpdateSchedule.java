package com.proyectoweb.barberia.Services.Schedule.Application;

import com.proyectoweb.barberia.Services.Schedule.Domain.Ports.ScheduleRepository;
import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Service.Domain.Exceptions.ServiceNotExist;
import com.proyectoweb.barberia.Shared.Domain.Bus.Event.EventBus;

import java.util.Optional;

public class UpdateSchedule {

    private ScheduleRepository repository;
    private EventBus eventBus;

    public UpdateSchedule(ScheduleRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String scheduleId, String date, String serviceId, String type){
        Optional<Schedule> schedule = repository.find(scheduleId);
        if(schedule.isEmpty()){
            throw new ServiceNotExist("El horario con id " + serviceId + " no existe.");
        }
        Schedule schedule1 = schedule.get();
        schedule1.updateSchedule(date, serviceId, type);
        this.repository.update(schedule1);
        this.eventBus.publish(schedule1.pullDomainEvents());
    }
}
