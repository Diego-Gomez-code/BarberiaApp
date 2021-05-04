package com.proyectoweb.barberia.Products.Product.Domain.ValueObjects;

import com.proyectoweb.barberia.Products.Product.Domain.Exceptions.AmountError;
import com.proyectoweb.barberia.Shared.Domain.IntegerValueObject;

public class ProductAmount extends IntegerValueObject {

    public ProductAmount(Integer value){
        this.validate(value);
        this.value = value;
    }

    public ProductAmount(){}

    public void validate(Integer value){
        this.positiveRule(value);
    }

    public void positiveRule(Integer value){
        if(value < 0){
            throw new AmountError("Amount of product can not be negative.");
        }
    }
}
