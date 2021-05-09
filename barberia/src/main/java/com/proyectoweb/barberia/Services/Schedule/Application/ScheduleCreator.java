package com.proyectoweb.barberia.Services.Schedule.Application;

import com.proyectoweb.barberia.Services.Schedule.Domain.Ports.ScheduleRepository;
import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleDate;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleOption;
import com.proyectoweb.barberia.Shared.Domain.Schedule.ScheduleId;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;

import java.sql.Timestamp;

public class ScheduleCreator {

    private ScheduleRepository repository;

    public ScheduleCreator(ScheduleRepository repository) {
        this.repository = repository;
    }

    public void execute( String id, Timestamp time, String service_id, char type){
        Schedule schedule = new Schedule(new ScheduleId(id),new ServiceId(service_id),new ScheduleDate(),new ScheduleOption(type));
        repository.save(schedule);
    }
}