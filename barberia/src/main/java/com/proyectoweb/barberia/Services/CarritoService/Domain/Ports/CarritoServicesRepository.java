package com.proyectoweb.barberia.Services.CarritoService.Domain.Ports;

import com.proyectoweb.barberia.Services.CarritoService.Domain.CarritoServices;

import java.util.List;
import java.util.Optional;

public interface CarritoServicesRepository {

    void save(CarritoServices carritoServices);
    void update(CarritoServices carritoServices);
    Optional<CarritoServices> find(String carritoServiceId);
    Optional<List<CarritoServices>> findAll();

}
