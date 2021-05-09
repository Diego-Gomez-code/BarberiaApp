package com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.ValueObjects;

import com.proyectoweb.barberia.Shared.Domain.CustomUUID;

public class CarritoClienteId extends CustomUUID {
    public CarritoClienteId(String value){
        super(value);
    }

    public CarritoClienteId(){
        super("");
    }
}
