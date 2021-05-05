package com.proyectoweb.barberia.Products.CarritoCompra.Application.Create;

import com.proyectoweb.barberia.Products.CarritoCompra.Domain.CarritoCompra;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Ports.CarritoCompraRepository;
import com.proyectoweb.barberia.Shared.Domain.Products.CarritoCompraId;

public class CreateCarritoCompra {

    private CarritoCompraRepository repository;

    public CreateCarritoCompra(CarritoCompraRepository repository){
        this.repository = repository;
    }

    public void execute(String carritoCompraId){
        CarritoCompra compra = CarritoCompra.create(new CarritoCompraId(carritoCompraId));
        this.repository.save(compra);
    }
}
