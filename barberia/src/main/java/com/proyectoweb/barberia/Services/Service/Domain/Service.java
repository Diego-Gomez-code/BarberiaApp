package com.proyectoweb.barberia.Services.Service.Domain;

import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceDescription;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceImage;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceName;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServicePrice;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {

    private ServiceId serviceId;
    private ServiceName serviceName;
    private ServiceDescription serviceDescription;
    private ServicePrice servicePrice;
    private Optional<List<Schedule>> schedules;
    private ServiceImage image;

    public Service() {
    }

    public Service(ServiceId serviceId, ServiceName serviceName, ServiceDescription serviceDescription, ServicePrice servicePrice, List<Schedule> schedules, ServiceImage imagen) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.schedules = Optional.ofNullable(schedules);
        this.image = imagen;
    }

    public static Service create(ServiceId serviceId, ServiceName serviceName, ServiceDescription serviceDescription, ServicePrice servicePrice){
        return new Service( serviceId,  serviceName,  serviceDescription,  servicePrice, null, new ServiceImage("servicedefault.jpg"));
    }

    public boolean equalsById(String id){
        return this.serviceId.equals(new ServiceId(id));
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", serviceId.value());
            put("name", serviceName.value());
            put("description", serviceDescription.value());
            put("price", servicePrice.value());
            put("image", image.value());
        }};
        return data;
    }

    public Optional<List<HashMap<String, Object>>> getSchedules(){
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.schedules.isPresent()){
            response = Optional.of(this.schedules.get().stream().map(schedule -> schedule.data()).collect(Collectors.toList()));
        }
        return response;
    }



    public void addSchedule(Schedule schedule){
        List<Schedule> schedulesList = this.schedules.isEmpty() ? new ArrayList<>() : this.schedules.get();
        for (Schedule s: schedulesList) {
            if(schedule.data().get("datetime_start").equals(s.data().get("datetime_start"))){
                System.out.println("error fechas iguales");
                new RuntimeException("Ya hay una cita agendada");
            }
        }
        schedulesList.add(schedule);
        this.schedules = Optional.ofNullable(schedulesList);

    }

    public void updateService(String serviceName, String serviceDescription, Double servicePrice){
        this.serviceName = new ServiceName(serviceName);
        this.serviceDescription = new ServiceDescription(serviceDescription);
        this.servicePrice = new ServicePrice(servicePrice);
    }
}
