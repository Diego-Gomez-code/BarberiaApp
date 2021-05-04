package com.proyectoweb.barberia.Shared.Domain.Products;

import com.proyectoweb.barberia.Shared.Domain.CustomUUID;

public class ProductId extends CustomUUID {

    public ProductId(String value){
        super(value);
    }

    private ProductId(){
        super("");
    }
}
