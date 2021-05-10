package com.proyectoweb.barberia.Services.Service.Application;

import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleDate;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleOption;
import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;
import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceDescription;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceName;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServicePrice;
import com.proyectoweb.barberia.Shared.Domain.Schedule.ScheduleId;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ServiceCreator {

    private ServiceRepository repository;

    public ServiceCreator(ServiceRepository repository) {
        this.repository = repository;
    }

    public void execute(String serviceId, String serviceName, String serviceDescription, Double servicePrice){
        Service service = Service.create(new ServiceId(serviceId), new ServiceName(serviceName), new ServiceDescription(serviceDescription),new ServicePrice(servicePrice));
        repository.save(service);
    }
}
