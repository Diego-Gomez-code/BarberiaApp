package com.proyectoweb.barberia.Products.Product.Domain.Exceptions;

public class AmountError extends RuntimeException{
    public AmountError(String message){
        super(message);
    }
}
