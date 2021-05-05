package com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions;

public class NegativeTotalError extends RuntimeException{
    public NegativeTotalError(String message){
        super(message);
    }
}
