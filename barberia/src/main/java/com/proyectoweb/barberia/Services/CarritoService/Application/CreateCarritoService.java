package com.proyectoweb.barberia.Services.CarritoService.Application;


import com.proyectoweb.barberia.Services.CarritoService.Domain.Ports.CarritoServicesRepository;

import java.sql.Timestamp;
import java.util.Optional;

public class CreateCarritoService {

    private CarritoServicesRepository carritoServicesRepository;

    public CreateCarritoService(CarritoServicesRepository carritoServicesRepository) {
        this.carritoServicesRepository = carritoServicesRepository;
    }

    public void execute(String serviceId, String scheduleId, Timestamp starttime, String option){

    }

}
