package com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.ValueObjects;

import com.proyectoweb.barberia.Shared.Domain.StringValueObject;

public class MetodoDePago extends StringValueObject {
    public MetodoDePago(String value){
        this.validate(value);
        this.value = value;
    }

    public MetodoDePago(){}

    public void validate(String value){

    }
}
