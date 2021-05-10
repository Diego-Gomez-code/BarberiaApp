package com.proyectoweb.barberia.Services.Schedule.Application;

import com.proyectoweb.barberia.Services.Schedule.Domain.Ports.ScheduleRepository;
import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Service.Domain.Exceptions.ServiceNotExist;
import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Shared.Domain.Bus.Event.EventBus;

import java.util.Optional;

public class ScheduleDeleter {

    private ScheduleRepository scheduleRepository;
    private EventBus eventBus;

    public ScheduleDeleter(ScheduleRepository scheduleRepository, EventBus eventBus) {
        this.scheduleRepository = scheduleRepository;
        this.eventBus = eventBus;
    }

    public void execute(String id){
        Optional<Schedule> schedule = scheduleRepository.find(id);
        if(schedule.isEmpty()){
            throw new ServiceNotExist("El horario con id " + id + " no existe.");
        }
        Schedule schedule1 = schedule.get();
        this.scheduleRepository.delete(schedule1);
        this.eventBus.publish(schedule1.pullDomainEvents());
    }
}
