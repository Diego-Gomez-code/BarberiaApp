package com.proyectoweb.barberia.Products.Product.Domain.Exceptions;

public class ProductEmptyError extends RuntimeException{
    public ProductEmptyError(String message){
        super(message);
    }
}
