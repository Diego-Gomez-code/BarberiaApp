package com.proyectoweb.barberia.Products.Product.Domain.ValueObjects;

import com.proyectoweb.barberia.Shared.Domain.StringValueObject;
import com.proyectoweb.barberia.Users.User.Domain.Exceptions.LengthNotValid;

public class ProductName extends StringValueObject {
    public ProductName(String value){
        this.validate(value);
        this.value = value;
    }

    public ProductName(){}

    public void validate(String value){
        this.lengthRule(value);
    }

    public void lengthRule(String value){
        if(value.length() < 3){
            throw new LengthNotValid("Product name not valid");
        }
    }
}
