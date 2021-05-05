package com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions;

public class NoProductsError extends RuntimeException{
    public NoProductsError(String message){
        super(message);
    }
}
