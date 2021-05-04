package com.proyectoweb.barberia.Services.Service.Application.All;

import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;
import com.proyectoweb.barberia.Services.Service.Domain.Service;

import java.util.List;
import java.util.Optional;

public class ServiceFindAll {

    private ServiceRepository serviceRepository;

    public ServiceFindAll(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> execute(){
        Optional<List<Service>> services = serviceRepository.findAll();
        if (services.isEmpty())
        {
            //TODO: Exception
        }
        return services.get();

        //return serviceRepository.findAll();
    }
}
