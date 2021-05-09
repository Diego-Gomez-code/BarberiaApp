package com.proyectoweb.barberia.Products.CarritoCompra.Domain.Ports;

import com.proyectoweb.barberia.Products.CarritoCompra.Domain.CarritoCompra;

import java.util.List;
import java.util.Optional;

public interface CarritoCompraRepository {
    void update(CarritoCompra carritoCompra);
    Optional<CarritoCompra> find(String carritoCompraId);
    void save(CarritoCompra carritoCompra);
    Optional<List<CarritoCompra>> all();
    void delete(CarritoCompra carritoCompra);
}
