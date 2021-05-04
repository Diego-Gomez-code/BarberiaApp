package com.proyectoweb.barberia.Products.Product.Domain.Exceptions;

public class PriceError extends RuntimeException{
    public PriceError(String message){
        super(message);
    }
}
