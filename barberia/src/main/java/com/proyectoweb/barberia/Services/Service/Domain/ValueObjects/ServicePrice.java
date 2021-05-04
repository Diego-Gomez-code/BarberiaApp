package com.proyectoweb.barberia.Services.Service.Domain.ValueObjects;

import com.proyectoweb.barberia.Shared.Domain.DoubleNotValid;
import com.proyectoweb.barberia.Shared.Domain.DoubleValueObject;

public class ServicePrice extends DoubleValueObject {

    public ServicePrice(Double value) {
        this.validate(value);
        this.value = value;
    }

    public ServicePrice() {

    }

    public void validate(Double value) {
        this.pricevalue(value);
    }

    public void pricevalue(Double value){
        if(value < 0){
            throw new DoubleNotValid("The price can't be negative");
        }
    }
}
