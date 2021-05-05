package com.proyectoweb.barberia.Products.CarritoCompra.Application.Find;

import com.proyectoweb.barberia.Products.CarritoCompra.Domain.CarritoCompra;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions.CarritoCompraNotExist;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Ports.CarritoCompraRepository;

import java.util.Optional;

public class CarritoCompraFinder {

    private CarritoCompraRepository repository;

    public CarritoCompraFinder(CarritoCompraRepository repository){
        this.repository = repository;
    }

    public CarritoCompraResponse execute(String id){
        Optional<CarritoCompra> result = repository.find(id);
        if(result.isEmpty()){
            throw new CarritoCompraNotExist("El carrito con id " + id + " no existe.");
        }
        CarritoCompra compra = result.get();
        return new CarritoCompraResponse(compra);
    }

}
