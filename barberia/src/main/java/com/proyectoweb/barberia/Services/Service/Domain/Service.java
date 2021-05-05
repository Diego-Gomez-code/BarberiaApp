package com.proyectoweb.barberia.Services.Service.Domain;

import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceDescription;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceName;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServicePrice;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Service {

    private ServiceId serviceId;
    private ServiceName serviceName;
    private ServiceDescription serviceDescription;
    private ServicePrice servicePrice;
    private Optional<List<Schedule>> schedules;

    public Service() {
    }

    public Service(ServiceId serviceId, ServiceName serviceName, ServiceDescription serviceDescription, ServicePrice servicePrice, List<Schedule> schedules) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
        this.schedules = Optional.ofNullable(schedules);
    }

    public static Service create(ServiceId serviceId, ServiceName serviceName, ServiceDescription serviceDescription, ServicePrice servicePrice){
        return new Service( serviceId,  serviceName,  serviceDescription,  servicePrice, null);
    }

    public String info(){
        return "El servicio: " + this.serviceName.value() + " vale: " + this.servicePrice.value();
    }

    public boolean equalsById(String id){
        return this.serviceId.equals(new ServiceId(id));
    }

    public HashMap<String,String> busqueda(List<Service> services){
        HashMap<String,String> resp = new HashMap<String,String>();
        for (Service valor:
             services) {
            resp.put("Servicio",valor.info());
            resp.put("valores",valor.info());
        }
        return resp;
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", serviceId.value());
            put("name", serviceName.value());
            put("description", serviceDescription.value());
            put("price", servicePrice.value());
        }};
        return data;
    }
}
