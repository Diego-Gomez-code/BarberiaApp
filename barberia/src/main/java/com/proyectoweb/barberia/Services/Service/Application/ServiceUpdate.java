package com.proyectoweb.barberia.Services.Service.Application;

import com.proyectoweb.barberia.Services.Service.Domain.Exceptions.ServiceNotExist;
import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;
import com.proyectoweb.barberia.Services.Service.Domain.Service;

import java.util.Optional;

public class ServiceUpdate {

    private ServiceRepository serviceRepository;

    public ServiceUpdate(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void execute(String serviceId, String serviceName, String serviceDescription, Double servicePrice){
        //TODO: Ver si el id de userdomain es para ver que el usuario puede modificar o para que lo usaron
        Optional<Service> service = serviceRepository.find(serviceId);
        if(service.isEmpty()){
            throw new ServiceNotExist("El servicio con id " + serviceId + " no existe.");
        }
        Service service1 = service.get();
        service1.updateService(serviceName, serviceDescription, servicePrice);
        if(!service1.getSchedules().isEmpty()){
            throw new RuntimeException("No change horarios");
        }
        this.serviceRepository.update(service1);
    }
}
