package com.proyectoweb.barberia.Services.Service.Application.Find;

import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Shared.Application.Response;

import java.util.HashMap;

public class ServiceFindByIdResponse implements Response {
    private final Service service;
    private HashMap<String,Object> response;

    public ServiceFindByIdResponse(Service service) {
        this.service = service;
    }

    @Override
    public HashMap<String, Object> response() {
        this.response = service.data();
        return response;
    }


}
