package com.proyectoweb.barberia.Products.CarritoCompra.Domain.ValueObjects;

import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions.NegativeTotalError;
import com.proyectoweb.barberia.Shared.Domain.DoubleValueObject;

public class CompraTotal extends DoubleValueObject {

    public CompraTotal(Double value){
        this.validate(value);
        this.value = value;
    }

    public CompraTotal(){}

    public void validate(Double value){
        this.negativeRule(value);
    }

    public void negativeRule(Double value){
        if(value < 0){
            throw new NegativeTotalError("Total no puede ser negativo");
        }
    }
}
