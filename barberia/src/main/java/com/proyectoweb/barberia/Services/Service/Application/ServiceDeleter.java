package com.proyectoweb.barberia.Services.Service.Application;

import com.proyectoweb.barberia.Services.Service.Domain.Exceptions.ServiceNotExist;
import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;
import com.proyectoweb.barberia.Services.Service.Domain.Service;

import java.util.Optional;

public class ServiceDeleter {

    private ServiceRepository repository;

    public ServiceDeleter(ServiceRepository repository) {
        this.repository = repository;
    }

    public void execute(String id){
        Optional<Service> service = repository.find(id);
        if(service.isEmpty()){
            throw new ServiceNotExist("El carrito con id " + id + " no existe.");
        }
        Service service1 = service.get();
        if(!service1.getSchedules().isEmpty()){
            throw new RuntimeException("No eliminar horarios");
        }
        this.repository.delete(service1);
    }
}
