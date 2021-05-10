package com.proyectoweb.barberia.Services.CarritoService.Application.All;

import com.proyectoweb.barberia.Services.CarritoService.Domain.CarritoServices;
import com.proyectoweb.barberia.Services.CarritoService.Domain.Ports.CarritoServicesRepository;

import java.util.List;
import java.util.Optional;

public class CarritoFindAll {

    private CarritoServicesRepository carritoServicesRepository;

    public CarritoFindAll(CarritoServicesRepository carritoServicesRepository) {
        this.carritoServicesRepository = carritoServicesRepository;
    }

    public List<CarritoServices> execute(){
        Optional<List<CarritoServices>> carritos= carritoServicesRepository.findAll();
        if(carritos.isEmpty()){
            //TODO: Exception horarios empty
        }
        return carritos.get();
    }
}
