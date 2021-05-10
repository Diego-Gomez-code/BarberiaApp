package com.proyectoweb.barberia.Services.Service.Application;

import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleDate;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleOption;
import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;
import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Shared.Domain.Schedule.ScheduleId;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;

import java.sql.Timestamp;
import java.util.Optional;

public class ScheduleUpdateService {

    private ServiceRepository serviceRepository;

    public ScheduleUpdateService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void execute(String serviceId, String scheduleId, Timestamp starttime, String option){
        Optional<Service> service = this.serviceRepository.find(serviceId);
        if(service.isEmpty()){
            //TODO: error
        }
        Service update = service.get();
        update.addSchedule(new Schedule(new ScheduleId(scheduleId),new ServiceId(serviceId),new ScheduleDate(starttime),new ScheduleOption(option)));
        this.serviceRepository.update(update);
    }
}
