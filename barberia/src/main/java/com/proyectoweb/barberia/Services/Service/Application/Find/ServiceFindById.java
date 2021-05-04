package com.proyectoweb.barberia.Services.Service.Application.Find;

import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;
import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;

import java.util.Optional;

public class ServiceFindById {

    private ServiceRepository serviceRepository;

    public ServiceFindById(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceFindByIdResponse execute(String id){
        Optional<Service> result = serviceRepository.find(new ServiceId(id).value());
        if(result.isEmpty()){
            //TODO: Realizar una exception particular
            throw new RuntimeException("error string id");
        }
        Service service = result.get();
        return new ServiceFindByIdResponse(service);
    }
}
