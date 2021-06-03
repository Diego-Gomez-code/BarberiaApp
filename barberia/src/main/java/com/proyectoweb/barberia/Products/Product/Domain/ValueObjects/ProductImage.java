package com.proyectoweb.barberia.Products.Product.Domain.ValueObjects;

import com.proyectoweb.barberia.Shared.Domain.StringValueObject;

public class ProductImage extends StringValueObject {

    public ProductImage(String value){
        this.value = value;
    }

    public ProductImage() {}
}
