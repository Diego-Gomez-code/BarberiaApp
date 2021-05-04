package com.proyectoweb.barberia.Products.Product.Domain.ValueObjects;

import com.proyectoweb.barberia.Products.Product.Domain.Exceptions.PriceError;
import com.proyectoweb.barberia.Shared.Domain.DoubleValueObject;

public class ProductPrice extends DoubleValueObject {

    public ProductPrice(Double value){
        this.validate(value);
        this.value = value;
    }

    public ProductPrice(){}

    public void validate(Double value){
        this.negativeRule(value);
    }

    public void negativeRule(Double value){
        if(value < 0){
            throw new PriceError("Price can not be negative.");
        }
    }
}
