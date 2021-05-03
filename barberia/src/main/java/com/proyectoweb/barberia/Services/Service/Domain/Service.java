package com.proyectoweb.barberia.Services.Service.Domain;

import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceDescription;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceName;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServicePrice;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;

public class Service {

    private ServiceId serviceId;
    private ServiceName serviceName;
    private ServiceDescription serviceDescription;
    private ServicePrice servicePrice;

    public Service(ServiceId serviceId, ServiceName serviceName, ServiceDescription serviceDescription, ServicePrice servicePrice) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
    }

}
