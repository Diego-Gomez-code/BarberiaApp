package com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions;

public class CarritoCompraNotExist extends RuntimeException{
    public CarritoCompraNotExist(String message){
        super(message);
    }
}
