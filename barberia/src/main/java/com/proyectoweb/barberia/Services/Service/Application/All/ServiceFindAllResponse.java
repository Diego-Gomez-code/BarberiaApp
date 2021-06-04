package com.proyectoweb.barberia.Services.Service.Application.All;

import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Users.User.Domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceFindAllResponse {
    private List<Service> services;

    public ServiceFindAllResponse(List<Service> services) {
        this.services = services;
    }

    public List<HashMap> response(){
        List<HashMap> response = services.stream().map(p -> p.data()).collect(Collectors.toList());

        return response;
    }

}
