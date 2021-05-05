package com.proyectoweb.barberia.Services.Service.Domain.ValueObjects;

import com.proyectoweb.barberia.Shared.Domain.IntegerValueObject;

public class ServiceDuration extends IntegerValueObject {

    public ServiceDuration(Integer value) {
        this.validate(value);
        this.value = value;
    }

    public void validate(Integer value){
        this.rango(value);
    }

    public void rango(Integer value){
        if(value < 0){
            throw new RuntimeException("error en el rango de minutos");
        }
    }
}
