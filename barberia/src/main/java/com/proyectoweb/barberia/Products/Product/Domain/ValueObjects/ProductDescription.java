package com.proyectoweb.barberia.Products.Product.Domain.ValueObjects;

import com.proyectoweb.barberia.Services.Service.Domain.Exceptions.DescriptionNotValid;
import com.proyectoweb.barberia.Shared.Domain.StringValueObject;

public class ProductDescription extends StringValueObject {

    public ProductDescription(String value){
        this.validate(value);
        this.value = value;
    }

    public ProductDescription(){}

    public void validate(String value){
        this.lengthRule(value);
    }

    public void lengthRule(String value){
        if(value.length() < 8){
            throw new DescriptionNotValid("Description not valid.");
        }
    }

}
