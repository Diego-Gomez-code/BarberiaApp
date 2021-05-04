package com.proyectoweb.barberia.Services.Service.Application;

import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;
import com.proyectoweb.barberia.Services.Service.Domain.Service;

public class ServiceFindById {

    private ServiceRepository serviceRepository;

    public ServiceFindById(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public String execute(String id){
        return serviceRepository.find(id);
    }
}
