package com.proyectoweb.barberia.Products.CarritoCompra.Application.AddProduct;

import com.proyectoweb.barberia.Products.CarritoCompra.Domain.CarritoCompra;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions.CarritoCompraNotExist;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Ports.CarritoCompraRepository;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.ValueObjects.ProductDetails;

import java.util.Optional;

public class CarritoAddProduct {

    private CarritoCompraRepository repository;

    public CarritoAddProduct(CarritoCompraRepository repository){
        this.repository = repository;
    }

    public void execute(String carritoCompraId, String productId, String name, Integer quantity, Double price){
        Optional<CarritoCompra> compra = repository.find(carritoCompraId);
        if(compra.isEmpty()){
            throw new CarritoCompraNotExist("El carrito con id " + carritoCompraId + " no existe.");
        }
        CarritoCompra finalCompra = compra.get();
        finalCompra.addProduct(new ProductDetails(productId, name, quantity, price));
        repository.update(finalCompra);
    }

}
