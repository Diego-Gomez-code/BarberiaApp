package com.proyectoweb.barberia.Products.CarritoCompra.Application.Delete;

import com.proyectoweb.barberia.Products.CarritoCompra.Domain.CarritoCompra;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions.CarritoCompraNotExist;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Ports.CarritoCompraRepository;

import java.util.Optional;

public class CarritoDeleter {

    private CarritoCompraRepository repository;

    public CarritoDeleter(CarritoCompraRepository repository){
        this.repository = repository;
    }

    public void execute(String id){
        Optional<CarritoCompra> carrito = repository.find(id);
        if(carrito.isEmpty()){
            throw new CarritoCompraNotExist("El carrito con id " + id + " no existe.");
        }
        CarritoCompra compra = carrito.get();
        this.repository.delete(compra);
    }
}
