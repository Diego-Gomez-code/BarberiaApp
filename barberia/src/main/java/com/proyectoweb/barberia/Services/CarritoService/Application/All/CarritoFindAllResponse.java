package com.proyectoweb.barberia.Services.CarritoService.Application.All;

import com.proyectoweb.barberia.Services.CarritoService.Domain.CarritoServices;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CarritoFindAllResponse {

    private List<CarritoServices> carritos;

    public CarritoFindAllResponse(List<CarritoServices> carritos) {
        this.carritos = carritos;
    }

    public List<HashMap> response(){
        List<HashMap> response = carritos.stream().map(p -> p.data()).collect(Collectors.toList());
        return response;
    }
}
