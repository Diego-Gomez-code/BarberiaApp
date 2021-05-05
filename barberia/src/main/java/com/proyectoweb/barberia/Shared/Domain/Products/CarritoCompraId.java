package com.proyectoweb.barberia.Shared.Domain.Products;

import com.proyectoweb.barberia.Shared.Domain.CustomUUID;

public class CarritoCompraId extends CustomUUID {
    public CarritoCompraId(String value){
        super(value);
    }
    public CarritoCompraId(){
        super("");
    }
}
