package com.proyectoweb.barberia.Services.Service.Application;

import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;

public class ServiceUpdate {

    private ServiceRepository serviceRepository;

    public ServiceUpdate(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void execute(String serviceId, String serviceName, String serviceDescription, Double servicePrice){
        //TODO: Ver si el id de userdomain es para ver que el usuario puede modificar o para que lo usaron
    }
}
